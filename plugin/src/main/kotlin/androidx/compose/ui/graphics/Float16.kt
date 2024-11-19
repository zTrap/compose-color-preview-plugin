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
package androidx.compose.ui.graphics

import androidx.compose.ui.graphics.Float16.Companion.toString
import androidx.compose.ui.util.floatFromBits

/**
 * The `Float16` class is a wrapper and a utility class to manipulate half-precision 16-bit
 * [IEEE 754](https://en.wikipedia.org/wiki/Half-precision_floating-point_format)
 * floating point data types (also called fp16 or binary16). A half-precision float can be
 * created from or converted to single-precision floats, and is stored in a short data type.
 * To distinguish short values holding half-precision floats from regular short values,
 * it is recommended to use the `@HalfFloat` annotation.
 *
 * The IEEE 754 standard specifies an fp16 as having the following format:
 *
 *  - Sign bit: 1 bit
 *  - Exponent width: 5 bits
 *  - Significand: 10 bits
 *
 * The format is laid out as follows:
 * ```
 *     1   11111   1111111111
 *     ^   --^--   -----^----
 *     sign  |          |_______ significand
 *     |
 *     -- exponent
 * ```
 *
 * Half-precision floating points can be useful to save memory and/or
 * bandwidth at the expense of range and precision when compared to single-precision
 * floating points (fp32).
 *
 * To help you decide whether fp16 is the right storage type for you need, please
 * refer to the table below that shows the available precision throughout the range of
 * possible values. The *precision* column indicates the step size between two
 * consecutive numbers in a specific part of the range.
 *
 * <table summary="Precision of fp16 across the range">
 * <tr><th>Range start</th><th>Precision</th></tr>
 * <tr><td>0</td><td>1/16,777,216</td></tr>
 * <tr><td>1/16,384</td><td>1/16,777,216</td></tr>
 * <tr><td>1/8,192</td><td>1/8,388,608</td></tr>
 * <tr><td>1/4,096</td><td>1/4,194,304</td></tr>
 * <tr><td>1/2,048</td><td>1/2,097,152</td></tr>
 * <tr><td>1/1,024</td><td>1/1,048,576</td></tr>
 * <tr><td>1/512</td><td>1/524,288</td></tr>
 * <tr><td>1/256</td><td>1/262,144</td></tr>
 * <tr><td>1/128</td><td>1/131,072</td></tr>
 * <tr><td>1/64</td><td>1/65,536</td></tr>
 * <tr><td>1/32</td><td>1/32,768</td></tr>
 * <tr><td>1/16</td><td>1/16,384</td></tr>
 * <tr><td>1/8</td><td>1/8,192</td></tr>
 * <tr><td>1/4</td><td>1/4,096</td></tr>
 * <tr><td>1/2</td><td>1/2,048</td></tr>
 * <tr><td>1</td><td>1/1,024</td></tr>
 * <tr><td>2</td><td>1/512</td></tr>
 * <tr><td>4</td><td>1/256</td></tr>
 * <tr><td>8</td><td>1/128</td></tr>
 * <tr><td>16</td><td>1/64</td></tr>
 * <tr><td>32</td><td>1/32</td></tr>
 * <tr><td>64</td><td>1/16</td></tr>
 * <tr><td>128</td><td>1/8</td></tr>
 * <tr><td>256</td><td>1/4</td></tr>
 * <tr><td>512</td><td>1/2</td></tr>
 * <tr><td>1,024</td><td>1</td></tr>
 * <tr><td>2,048</td><td>2</td></tr>
 * <tr><td>4,096</td><td>4</td></tr>
 * <tr><td>8,192</td><td>8</td></tr>
 * <tr><td>16,384</td><td>16</td></tr>
 * <tr><td>32,768</td><td>32</td></tr>
 * </table>
 *
 * This table shows that numbers higher than 1024 lose all fractional precision.
 */
@JvmInline
internal value class Float16(private val halfValue: Short) : Comparable<Float16> {

    /**
     * Returns the value of this `Float16` as a `Float` after
     * a widening primitive conversion.
     *
     * @return The half-precision float value represented by this object
     * converted to type `Float`
     */
    private fun toFloat(): Float = halfToFloat(halfValue)

    /**
     * Returns a string representation of the specified half-precision
     * float value. See [toString] for more information.
     *
     * @return A string representation of this `Float16` object
     */
    override fun toString(): String = toFloat().toString()

    /**
     * Compares to another half-precision float value. The following
     * conditions apply during the comparison:
     *
     *  * [NaN] is considered by this method to be equal to itself and greater
     * than all other half-precision float values (including [PositiveInfinity])
     *  * [PositiveZero] is considered by this method to be greater than
     * [NegativeZero].
     *
     * @param other The half-precision float value to compare to the half-precision value
     * represented by this `Float16` object
     *
     * @return The value `0` if `this` is numerically equal to [other]; a
     * value less than `0` if `this` is numerically less than [other];
     * and a value greater than `0` if `this` is numerically greater
     * than [other]
     */
    override operator fun compareTo(other: Float16): Int {
        if (isNaN()) {
            return if (other.isNaN()) 0 else 1
        } else if (other.isNaN()) {
            return -1
        }
        return toCompareValue(halfValue).compareTo(toCompareValue(other.halfValue))
    }

    /**
     * Returns true if this `Float16` value represents a Not-a-Number,
     * false otherwise.
     *
     * @return True if the value is a NaN, false otherwise
     */
    private fun isNaN(): Boolean = halfValue.toInt() and Fp16Combined > Fp16ExponentMax

    companion object {
        /**
         * A Not-a-Number representation of a half-precision float.
         */
        val NaN = Float16(0x7e00.toShort())
        /**
         * Negative 0 of type half-precision float.
         */
        val NegativeZero = Float16(0x8000.toShort())
        /**
         * Positive infinity of type half-precision float.
         */
        val PositiveInfinity = Float16(0x7c00.toShort())
        /**
         * Positive 0 of type half-precision float.
         */
        val PositiveZero = Float16(0x0000.toShort())
    }
}

private const val Fp16SignShift = 15
private const val Fp16SignMask = 0x8000
private const val Fp16ExponentShift = 10
private const val Fp16ExponentMask = 0x1f
private const val Fp16SignificandMask = 0x3ff
private const val Fp16ExponentBias = 15
private const val Fp16Combined = 0x7fff
private const val Fp16ExponentMax = 0x7c00

private const val Fp32SignShift = 31
private const val Fp32ExponentShift = 23
private const val Fp32ExponentMask = 0xff
private const val Fp32SignificandMask = 0x7fffff
private const val Fp32ExponentBias = 127
private const val Fp32QNaNMask = 0x400000

private const val Fp32DenormalMagic = 126 shl 23
private val Fp32DenormalFloat = floatFromBits(Fp32DenormalMagic)

@Suppress("NOTHING_TO_INLINE")
private inline fun toCompareValue(value: Short): Int {
    return if (value.toInt() and Fp16SignMask != 0) {
        0x8000 - (value.toInt() and 0xffff)
    } else {
        value.toInt() and 0xffff
    }
}

/**
 * Convert a single-precision float to a half-precision float, stored as
 * [Short] data type to hold its 16 bits.
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

/**
 * Convert a half-precision float to a single-precision float.
 */
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
