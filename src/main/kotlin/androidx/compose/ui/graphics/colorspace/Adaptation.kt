/*
 * Copyright 2019 The Android Open Source Project
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

package androidx.compose.ui.graphics.colorspace

/**
 * List of adaptation matrices that can be used for chromatic adaptation
 * using the von Kries transform. These matrices are used to convert values
 * in the CIE XYZ space to values in the LMS space (Long Medium Short).
 *
 * Given an adaptation matrix `A`, the conversion from XYZ to
 * LMS is straightforward:
 *
 * [See equation](https://developer.android.com/reference/android/graphics/ColorSpace.Adaptation.html)
 *
 * The complete von Kries transform `T` uses a diagonal matrix
 * noted `D` to perform the adaptation in LMS space. In addition
 * to `A` and `D`, the source white point `W1` and the destination
 * white point `W2` must be specified:
 *
 * [See equation](https://developer.android.com/reference/android/graphics/ColorSpace.Adaptation.html)
 *
 * As an example, the resulting matrix `T` can then be used to
 * perform the chromatic adaptation of sRGB XYZ transform from D65
 * to D50:
 *
 * [See equation](https://developer.android.com/reference/android/graphics/ColorSpace.Adaptation.html)
 *
 * @see Connector
 * @see ColorSpace.connect
 */
abstract class Adaptation private constructor(internal val transform: FloatArray) {
    companion object {
        /**
         * Bradford chromatic adaptation transform, as defined in the
         * CIECAM97s color appearance model.
         */
        val Bradford = object : Adaptation(
            floatArrayOf(
                0.8951f, -0.7502f, 0.0389f,
                0.2664f, 1.7135f, -0.0685f,
                -0.1614f, 0.0367f, 1.0296f
            )
        ) {
            override fun toString() = "Bradford"
        }
    }
}