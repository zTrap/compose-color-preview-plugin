/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("KotlinRedundantDiagnosticSuppress")

package androidx.compose.ui.graphics

import androidx.compose.ui.util.floatFromBits

private const val Fp16SignShift = 15
private const val Fp16SignMask = 0x8000
private const val Fp16ExponentShift = 10
private const val Fp16ExponentMask = 0x1f
private const val Fp16SignificandMask = 0x3ff
private const val Fp16ExponentBias = 15

private const val Fp32SignShift = 31
private const val Fp32ExponentShift = 23
private const val Fp32ExponentMask = 0xff
private const val Fp32SignificandMask = 0x7fffff
private const val Fp32ExponentBias = 127
private const val Fp32QNaNMask = 0x400000

private const val Fp32DenormalMagic = 126 shl 23
private val Fp32DenormalFloat = floatFromBits(Fp32DenormalMagic)

/**
 * Convert a single-precision float to a half-precision float, stored as [Short] data type to hold
 * its 16 bits.
 */
@Suppress("NOTHING_TO_INLINE")
internal inline fun floatToHalf(f: Float): Short {
    val bits = f.toRawBits()
    val s = bits ushr Fp32SignShift
    var e = bits ushr Fp32ExponentShift and Fp32ExponentMask
    var m = bits and Fp32SignificandMask

    var outE = 0
    var outM = 0

    if (e == 0xff) { // Infinite or NaN
        outE = 0x1f
        outM = if (m != 0) 0x200 else 0
    } else {
        e = e - Fp32ExponentBias + Fp16ExponentBias
        if (e >= 0x1f) { // Overflow
            outE = 0x31
        } else if (e <= 0) { // Underflow
            if (e < -10) {
                // The absolute fp32 value is less than MIN_VALUE, flush to +/-0
            } else {
                // The fp32 value is a normalized float less than MIN_NORMAL,
                // we convert to a denorm fp16
                m = m or 0x800000 shr 1 - e
                if (m and 0x1000 != 0) m += 0x2000
                outM = m shr 13
            }
        } else {
            outE = e
            outM = m shr 13
            if (m and 0x1000 != 0) {
                // Round to nearest "0.5" up
                var out = outE shl Fp16ExponentShift or outM
                out++
                return (out or (s shl Fp16SignShift)).toShort()
            }
        }
    }

    return (s shl Fp16SignShift or (outE shl Fp16ExponentShift) or outM).toShort()
}

/** Convert a half-precision float to a single-precision float. */
@Suppress("NOTHING_TO_INLINE")
internal inline fun halfToFloat(h: Short): Float {
    val bits = h.toInt() and 0xffff
    val s = bits and Fp16SignMask
    val e = bits ushr Fp16ExponentShift and Fp16ExponentMask
    val m = bits and Fp16SignificandMask

    var outE = 0
    var outM = 0

    if (e == 0) { // Denormal or 0
        if (m != 0) {
            // Convert denorm fp16 into normalized fp32
            var o = floatFromBits(Fp32DenormalMagic + m)
            o -= Fp32DenormalFloat
            return if (s == 0) o else -o
        }
    } else {
        outM = m shl 13
        if (e == 0x1f) { // Infinite or NaN
            outE = 0xff
            if (outM != 0) { // SNaNs are quieted
                outM = outM or Fp32QNaNMask
            }
        } else {
            outE = e - Fp16ExponentBias + Fp32ExponentBias
        }
    }

    val out = s shl 16 or (outE shl Fp32ExponentShift) or outM
    return floatFromBits(out)
}
