@file:Suppress("RemoveRedundantQualifierName", "unused", "UNUSED_VARIABLE", "UNREACHABLE_CODE", "UNUSED_PARAMETER", "SameReturnValue", "FunctionName")

package ru.ztrap.plugin.idea.compose.color.preview.sample

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.lerp

val lerpColor1 = Color.White
val lerpColor2 = White
val lerpColor3 = Color(0xffffffff)

val lerpColor4 = Color.Black
val lerpColor5 = Black
val lerpColor6 = Color(0xff000000)

//region KtPropertyAccessor
val lerpP1 get() = lerp(start = Color.White, stop = Color.Black, fraction = 0.5f)
val lerpP2 get() = lerp(Color.White, stop = Color.Black, fraction = 0.5f)
val lerpP3 get() = lerp(Color.White, Color.Black, 0.5f)

val lerpP4 get() = lerp(start = Color.White, stop = Color(0xff000000), fraction = 0.5f)
val lerpP5 get() = lerp(Color.White, stop = Color(0xff000000), fraction = 0.5f)
val lerpP6 get() = lerp(Color.White, Color(0xff000000), 0.5f)

val lerpP7 get() = lerp(start = Color.White, stop = lerpColor4, fraction = 0.5f)
val lerpP8 get() = lerp(Color.White, stop = lerpColor4, fraction = 0.5f)
val lerpP9 get() = lerp(Color.White, lerpColor4, 0.5f)

val lerpP10 get() = lerp(start = Color.White, stop = lerpColor5, fraction = 0.5f)
val lerpP11 get() = lerp(Color.White, stop = lerpColor5, fraction = 0.5f)
val lerpP12 get() = lerp(Color.White, lerpColor5, 0.5f)

val lerpP13 get() = lerp(start = Color.White, stop = lerpColor6, fraction = 0.5f)
val lerpP14 get() = lerp(Color.White, stop = lerpColor6, fraction = 0.5f)
val lerpP15 get() = lerp(Color.White, lerpColor6, 0.5f)

val lerpP16 get() = lerp(start = Color(0xffffffff), stop = Color.Black, fraction = 0.5f)
val lerpP17 get() = lerp(Color(0xffffffff), stop = Color.Black, fraction = 0.5f)
val lerpP18 get() = lerp(Color(0xffffffff), Color.Black, 0.5f)

val lerpP19 get() = lerp(start = Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f)
val lerpP20 get() = lerp(Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f)
val lerpP21 get() = lerp(Color(0xffffffff), Color(0xff000000), 0.5f)

val lerpP22 get() = lerp(start = Color(0xffffffff), stop = lerpColor4, fraction = 0.5f)
val lerpP23 get() = lerp(Color(0xffffffff), stop = lerpColor4, fraction = 0.5f)
val lerpP24 get() = lerp(Color(0xffffffff), lerpColor4, 0.5f)

val lerpP25 get() = lerp(start = Color(0xffffffff), stop = lerpColor5, fraction = 0.5f)
val lerpP26 get() = lerp(Color(0xffffffff), stop = lerpColor5, fraction = 0.5f)
val lerpP27 get() = lerp(Color(0xffffffff), lerpColor5, 0.5f)

val lerpP28 get() = lerp(start = Color(0xffffffff), stop = lerpColor6, fraction = 0.5f)
val lerpP29 get() = lerp(Color(0xffffffff), stop = lerpColor6, fraction = 0.5f)
val lerpP30 get() = lerp(Color(0xffffffff), lerpColor6, 0.5f)

val lerpP31 get() = lerp(start = lerpColor1, stop = Color.Black, fraction = 0.5f)
val lerpP32 get() = lerp(lerpColor1, stop = Color.Black, fraction = 0.5f)
val lerpP33 get() = lerp(lerpColor1, Color.Black, 0.5f)

val lerpP34 get() = lerp(start = lerpColor1, stop = Color(0xff000000), fraction = 0.5f)
val lerpP35 get() = lerp(lerpColor1, stop = Color(0xff000000), fraction = 0.5f)
val lerpP36 get() = lerp(lerpColor1, Color(0xff000000), 0.5f)

val lerpP37 get() = lerp(start = lerpColor1, stop = lerpColor4, fraction = 0.5f)
val lerpP38 get() = lerp(lerpColor1, stop = lerpColor4, fraction = 0.5f)
val lerpP39 get() = lerp(lerpColor1, lerpColor4, 0.5f)

val lerpP40 get() = lerp(start = lerpColor1, stop = lerpColor5, fraction = 0.5f)
val lerpP41 get() = lerp(lerpColor1, stop = lerpColor5, fraction = 0.5f)
val lerpP42 get() = lerp(lerpColor1, lerpColor5, 0.5f)

val lerpP43 get() = lerp(start = lerpColor1, stop = lerpColor6, fraction = 0.5f)
val lerpP44 get() = lerp(lerpColor1, stop = lerpColor6, fraction = 0.5f)
val lerpP45 get() = lerp(lerpColor1, lerpColor6, 0.5f)

val lerpP46 get() = lerp(start = lerpColor2, stop = Color.Black, fraction = 0.5f)
val lerpP47 get() = lerp(lerpColor2, stop = Color.Black, fraction = 0.5f)
val lerpP48 get() = lerp(lerpColor2, Color.Black, 0.5f)

val lerpP49 get() = lerp(start = lerpColor2, stop = Color(0xff000000), fraction = 0.5f)
val lerpP50 get() = lerp(lerpColor2, stop = Color(0xff000000), fraction = 0.5f)
val lerpP51 get() = lerp(lerpColor2, Color(0xff000000), 0.5f)

val lerpP52 get() = lerp(start = lerpColor2, stop = lerpColor4, fraction = 0.5f)
val lerpP53 get() = lerp(lerpColor2, stop = lerpColor4, fraction = 0.5f)
val lerpP54 get() = lerp(lerpColor2, lerpColor4, 0.5f)

val lerpP55 get() = lerp(start = lerpColor2, stop = lerpColor5, fraction = 0.5f)
val lerpP56 get() = lerp(lerpColor2, stop = lerpColor5, fraction = 0.5f)
val lerpP57 get() = lerp(lerpColor2, lerpColor5, 0.5f)

val lerpP58 get() = lerp(start = lerpColor2, stop = lerpColor6, fraction = 0.5f)
val lerpP59 get() = lerp(lerpColor2, stop = lerpColor6, fraction = 0.5f)
val lerpP60 get() = lerp(lerpColor2, lerpColor6, 0.5f)

val lerpP61 get() = lerp(start = lerpColor3, stop = Color.Black, fraction = 0.5f)
val lerpP62 get() = lerp(lerpColor3, stop = Color.Black, fraction = 0.5f)
val lerpP63 get() = lerp(lerpColor3, Color.Black, 0.5f)

val lerpP64 get() = lerp(start = lerpColor3, stop = Color(0xff000000), fraction = 0.5f)
val lerpP65 get() = lerp(lerpColor3, stop = Color(0xff000000), fraction = 0.5f)
val lerpP66 get() = lerp(lerpColor3, Color(0xff000000), 0.5f)

val lerpP67 get() = lerp(start = lerpColor3, stop = lerpColor4, fraction = 0.5f)
val lerpP68 get() = lerp(lerpColor3, stop = lerpColor4, fraction = 0.5f)
val lerpP69 get() = lerp(lerpColor3, lerpColor4, 0.5f)

val lerpP70 get() = lerp(start = lerpColor3, stop = lerpColor5, fraction = 0.5f)
val lerpP71 get() = lerp(lerpColor3, stop = lerpColor5, fraction = 0.5f)
val lerpP72 get() = lerp(lerpColor3, lerpColor5, 0.5f)

val lerpP73 get() = lerp(start = lerpColor3, stop = lerpColor6, fraction = 0.5f)
val lerpP74 get() = lerp(lerpColor3, stop = lerpColor6, fraction = 0.5f)
val lerpP75 get() = lerp(lerpColor3, lerpColor6, 0.5f)
//endregion

//region KtBlockExpression
fun lerpKtBlockExpression_KtDotQualifiedExpression_KtDotQualifiedExpression() {
    lerp(start = Color.White, stop = Color.Black, fraction = 0.5f)
    lerp(Color.White, stop = Color.Black, fraction = 0.5f)
    lerp(Color.White, Color.Black, 0.5f)
}

fun lerpKtBlockExpression_KtDotQualifiedExpression_KtCallExpression() {
    lerp(start = Color.White, stop = Color(0xff000000), fraction = 0.5f)
    lerp(Color.White, stop = Color(0xff000000), fraction = 0.5f)
    lerp(Color.White, Color(0xff000000), 0.5f)
}

fun lerpKtBlockExpression_KtDotQualifiedExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    lerp(start = Color.White, stop = lerpColor4, fraction = 0.5f)
    lerp(Color.White, stop = lerpColor4, fraction = 0.5f)
    lerp(Color.White, lerpColor4, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    lerp(start = Color.White, stop = lerpColor5, fraction = 0.5f)
    lerp(Color.White, stop = lerpColor5, fraction = 0.5f)
    lerp(Color.White, lerpColor5, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    lerp(start = Color.White, stop = lerpColor6, fraction = 0.5f)
    lerp(Color.White, stop = lerpColor6, fraction = 0.5f)
    lerp(Color.White, lerpColor6, 0.5f)
    //endregion
}

fun lerpKtBlockExpression_KtCallExpression_KtDotQualifiedExpression() {
    lerp(start = Color(0xffffffff), stop = Color.Black, fraction = 0.5f)
    lerp(Color(0xffffffff), stop = Color.Black, fraction = 0.5f)
    lerp(Color(0xffffffff), Color.Black, 0.5f)
}

fun lerpKtBlockExpression_KtCallExpression_KtCallExpression() {
    lerp(start = Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f)
    lerp(Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f)
    lerp(Color(0xffffffff), Color(0xff000000), 0.5f)
}

fun lerpKtBlockExpression_KtCallExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    lerp(start = Color(0xffffffff), stop = lerpColor4, fraction = 0.5f)
    lerp(Color(0xffffffff), stop = lerpColor4, fraction = 0.5f)
    lerp(Color(0xffffffff), lerpColor4, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    lerp(start = Color(0xffffffff), stop = lerpColor5, fraction = 0.5f)
    lerp(Color(0xffffffff), stop = lerpColor5, fraction = 0.5f)
    lerp(Color(0xffffffff), lerpColor5, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    lerp(start = Color(0xffffffff), stop = lerpColor6, fraction = 0.5f)
    lerp(Color(0xffffffff), stop = lerpColor6, fraction = 0.5f)
    lerp(Color(0xffffffff), lerpColor6, 0.5f)
    //endregion
}

fun lerpKtBlockExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    lerp(start = lerpColor1, stop = Color.Black, fraction = 0.5f)
    lerp(lerpColor1, stop = Color.Black, fraction = 0.5f)
    lerp(lerpColor1, Color.Black, 0.5f)

    lerp(start = lerpColor1, stop = Color(0xff000000), fraction = 0.5f)
    lerp(lerpColor1, stop = Color(0xff000000), fraction = 0.5f)
    lerp(lerpColor1, Color(0xff000000), 0.5f)

    lerp(start = lerpColor1, stop = lerpColor4, fraction = 0.5f)
    lerp(lerpColor1, stop = lerpColor4, fraction = 0.5f)
    lerp(lerpColor1, lerpColor4, 0.5f)

    lerp(start = lerpColor1, stop = lerpColor5, fraction = 0.5f)
    lerp(lerpColor1, stop = lerpColor5, fraction = 0.5f)
    lerp(lerpColor1, lerpColor5, 0.5f)

    lerp(start = lerpColor1, stop = lerpColor6, fraction = 0.5f)
    lerp(lerpColor1, stop = lerpColor6, fraction = 0.5f)
    lerp(lerpColor1, lerpColor6, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    lerp(start = lerpColor2, stop = Color.Black, fraction = 0.5f)
    lerp(lerpColor2, stop = Color.Black, fraction = 0.5f)
    lerp(lerpColor2, Color.Black, 0.5f)

    lerp(start = lerpColor2, stop = Color(0xff000000), fraction = 0.5f)
    lerp(lerpColor2, stop = Color(0xff000000), fraction = 0.5f)
    lerp(lerpColor2, Color(0xff000000), 0.5f)

    lerp(start = lerpColor2, stop = lerpColor4, fraction = 0.5f)
    lerp(lerpColor2, stop = lerpColor4, fraction = 0.5f)
    lerp(lerpColor2, lerpColor4, 0.5f)

    lerp(start = lerpColor2, stop = lerpColor5, fraction = 0.5f)
    lerp(lerpColor2, stop = lerpColor5, fraction = 0.5f)
    lerp(lerpColor2, lerpColor5, 0.5f)

    lerp(start = lerpColor2, stop = lerpColor6, fraction = 0.5f)
    lerp(lerpColor2, stop = lerpColor6, fraction = 0.5f)
    lerp(lerpColor2, lerpColor6, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    lerp(start = lerpColor3, stop = Color.Black, fraction = 0.5f)
    lerp(lerpColor3, stop = Color.Black, fraction = 0.5f)
    lerp(lerpColor3, Color.Black, 0.5f)

    lerp(start = lerpColor3, stop = Color(0xff000000), fraction = 0.5f)
    lerp(lerpColor3, stop = Color(0xff000000), fraction = 0.5f)
    lerp(lerpColor3, Color(0xff000000), 0.5f)

    lerp(start = lerpColor3, stop = lerpColor4, fraction = 0.5f)
    lerp(lerpColor3, stop = lerpColor4, fraction = 0.5f)
    lerp(lerpColor3, lerpColor4, 0.5f)

    lerp(start = lerpColor3, stop = lerpColor5, fraction = 0.5f)
    lerp(lerpColor3, stop = lerpColor5, fraction = 0.5f)
    lerp(lerpColor3, lerpColor5, 0.5f)

    lerp(start = lerpColor3, stop = lerpColor6, fraction = 0.5f)
    lerp(lerpColor3, stop = lerpColor6, fraction = 0.5f)
    lerp(lerpColor3, lerpColor6, 0.5f)
    //endregion
}
//endregion

//region KtProperty
fun lerpKtProperty_KtDotQualifiedExpression_KtDotQualifiedExpression() {
    val p1 = lerp(start = Color.White, stop = Color.Black, fraction = 0.5f)
    val p2 = lerp(Color.White, stop = Color.Black, fraction = 0.5f)
    val p3 = lerp(Color.White, Color.Black, 0.5f)
}

fun lerpKtProperty_KtDotQualifiedExpression_KtCallExpression() {
    val p1 = lerp(start = Color.White, stop = Color(0xff000000), fraction = 0.5f)
    val p2 = lerp(Color.White, stop = Color(0xff000000), fraction = 0.5f)
    val p3 = lerp(Color.White, Color(0xff000000), 0.5f)
}

fun lerpKtProperty_KtDotQualifiedExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    val p1 = lerp(start = Color.White, stop = lerpColor4, fraction = 0.5f)
    val p2 = lerp(Color.White, stop = lerpColor4, fraction = 0.5f)
    val p3 = lerp(Color.White, lerpColor4, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    val p4 = lerp(start = Color.White, stop = lerpColor5, fraction = 0.5f)
    val p5 = lerp(Color.White, stop = lerpColor5, fraction = 0.5f)
    val p6 = lerp(Color.White, lerpColor5, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    val p7 = lerp(start = Color.White, stop = lerpColor6, fraction = 0.5f)
    val p8 = lerp(Color.White, stop = lerpColor6, fraction = 0.5f)
    val p9 = lerp(Color.White, lerpColor6, 0.5f)
    //endregion
}

fun lerpKtProperty_KtCallExpression_KtDotQualifiedExpression() {
    val p1 = lerp(start = Color(0xffffffff), stop = Color.Black, fraction = 0.5f)
    val p2 = lerp(Color(0xffffffff), stop = Color.Black, fraction = 0.5f)
    val p3 = lerp(Color(0xffffffff), Color.Black, 0.5f)
}

fun lerpKtProperty_KtCallExpression_KtCallExpression() {
    val p1 = lerp(start = Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f)
    val p2 = lerp(Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f)
    val p3 = lerp(Color(0xffffffff), Color(0xff000000), 0.5f)
}

fun lerpKtProperty_KtCallExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    val p1 = lerp(start = Color(0xffffffff), stop = lerpColor4, fraction = 0.5f)
    val p2 = lerp(Color(0xffffffff), stop = lerpColor4, fraction = 0.5f)
    val p3 = lerp(Color(0xffffffff), lerpColor4, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    val p4 = lerp(start = Color(0xffffffff), stop = lerpColor5, fraction = 0.5f)
    val p5 = lerp(Color(0xffffffff), stop = lerpColor5, fraction = 0.5f)
    val p6 = lerp(Color(0xffffffff), lerpColor5, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    val p7 = lerp(start = Color(0xffffffff), stop = lerpColor6, fraction = 0.5f)
    val p8 = lerp(Color(0xffffffff), stop = lerpColor6, fraction = 0.5f)
    val p9 = lerp(Color(0xffffffff), lerpColor6, 0.5f)
    //endregion
}

fun lerpKtProperty_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    val p1 = lerp(start = lerpColor1, stop = Color.Black, fraction = 0.5f)
    val p2 = lerp(lerpColor1, stop = Color.Black, fraction = 0.5f)
    val p3 = lerp(lerpColor1, Color.Black, 0.5f)

    val p4 = lerp(start = lerpColor1, stop = Color(0xff000000), fraction = 0.5f)
    val p5 = lerp(lerpColor1, stop = Color(0xff000000), fraction = 0.5f)
    val p6 = lerp(lerpColor1, Color(0xff000000), 0.5f)

    val p7 = lerp(start = lerpColor1, stop = lerpColor4, fraction = 0.5f)
    val p8 = lerp(lerpColor1, stop = lerpColor4, fraction = 0.5f)
    val p9 = lerp(lerpColor1, lerpColor4, 0.5f)

    val p10 = lerp(start = lerpColor1, stop = lerpColor5, fraction = 0.5f)
    val p11 = lerp(lerpColor1, stop = lerpColor5, fraction = 0.5f)
    val p12 = lerp(lerpColor1, lerpColor5, 0.5f)

    val p13 = lerp(start = lerpColor1, stop = lerpColor6, fraction = 0.5f)
    val p14 = lerp(lerpColor1, stop = lerpColor6, fraction = 0.5f)
    val p15 = lerp(lerpColor1, lerpColor6, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    val p16 = lerp(start = lerpColor2, stop = Color.Black, fraction = 0.5f)
    val p17 = lerp(lerpColor2, stop = Color.Black, fraction = 0.5f)
    val p18 = lerp(lerpColor2, Color.Black, 0.5f)

    val p19 = lerp(start = lerpColor2, stop = Color(0xff000000), fraction = 0.5f)
    val p20 = lerp(lerpColor2, stop = Color(0xff000000), fraction = 0.5f)
    val p21 = lerp(lerpColor2, Color(0xff000000), 0.5f)

    val p22 = lerp(start = lerpColor2, stop = lerpColor4, fraction = 0.5f)
    val p23 = lerp(lerpColor2, stop = lerpColor4, fraction = 0.5f)
    val p24 = lerp(lerpColor2, lerpColor4, 0.5f)

    val p25 = lerp(start = lerpColor2, stop = lerpColor5, fraction = 0.5f)
    val p26 = lerp(lerpColor2, stop = lerpColor5, fraction = 0.5f)
    val p27 = lerp(lerpColor2, lerpColor5, 0.5f)

    val p28 = lerp(start = lerpColor2, stop = lerpColor6, fraction = 0.5f)
    val p29 = lerp(lerpColor2, stop = lerpColor6, fraction = 0.5f)
    val p30 = lerp(lerpColor2, lerpColor6, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    val p31 = lerp(start = lerpColor3, stop = Color.Black, fraction = 0.5f)
    val p32 = lerp(lerpColor3, stop = Color.Black, fraction = 0.5f)
    val p33 = lerp(lerpColor3, Color.Black, 0.5f)

    val p34 = lerp(start = lerpColor3, stop = Color(0xff000000), fraction = 0.5f)
    val p35 = lerp(lerpColor3, stop = Color(0xff000000), fraction = 0.5f)
    val p36 = lerp(lerpColor3, Color(0xff000000), 0.5f)

    val p37 = lerp(start = lerpColor3, stop = lerpColor4, fraction = 0.5f)
    val p38 = lerp(lerpColor3, stop = lerpColor4, fraction = 0.5f)
    val p39 = lerp(lerpColor3, lerpColor4, 0.5f)

    val p41 = lerp(start = lerpColor3, stop = lerpColor5, fraction = 0.5f)
    val p42 = lerp(lerpColor3, stop = lerpColor5, fraction = 0.5f)
    val p43 = lerp(lerpColor3, lerpColor5, 0.5f)

    val p44 = lerp(start = lerpColor3, stop = lerpColor6, fraction = 0.5f)
    val p45 = lerp(lerpColor3, stop = lerpColor6, fraction = 0.5f)
    val p46 = lerp(lerpColor3, lerpColor6, 0.5f)
    //endregion
}
//endregion

//region KtParameter
fun lerpKtParameter_KtDotQualifiedExpression_KtDotQualifiedExpression(
    p1: Color = lerp(start = Color.White, stop = Color.Black, fraction = 0.5f),
    p2: Color = lerp(Color.White, stop = Color.Black, fraction = 0.5f),
    p3: Color = lerp(Color.White, Color.Black, 0.5f),
) = Unit

fun lerpKtParameter_KtDotQualifiedExpression_KtCallExpression(
    p1: Color = lerp(start = Color.White, stop = Color(0xff000000), fraction = 0.5f),
    p2: Color = lerp(Color.White, stop = Color(0xff000000), fraction = 0.5f),
    p3: Color = lerp(Color.White, Color(0xff000000), 0.5f),
) = Unit

fun lerpKtParameter_KtDotQualifiedExpression_KtNameReferenceExpression(
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    p1: Color = lerp(start = Color.White, stop = lerpColor4, fraction = 0.5f),
    p2: Color = lerp(Color.White, stop = lerpColor4, fraction = 0.5f),
    p3: Color = lerp(Color.White, lerpColor4, 0.5f),
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    p4: Color = lerp(start = Color.White, stop = lerpColor5, fraction = 0.5f),
    p5: Color = lerp(Color.White, stop = lerpColor5, fraction = 0.5f),
    p6: Color = lerp(Color.White, lerpColor5, 0.5f),
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    p7: Color = lerp(start = Color.White, stop = lerpColor6, fraction = 0.5f),
    p8: Color = lerp(Color.White, stop = lerpColor6, fraction = 0.5f),
    p9: Color = lerp(Color.White, lerpColor6, 0.5f),
    //endregion
) = Unit

fun lerpKtParameter_KtCallExpression_KtDotQualifiedExpression(
    p1: Color = lerp(start = Color(0xffffffff), stop = Color.Black, fraction = 0.5f),
    p2: Color = lerp(Color(0xffffffff), stop = Color.Black, fraction = 0.5f),
    p3: Color = lerp(Color(0xffffffff), Color.Black, 0.5f),
) = Unit

fun lerpKtParameter_KtCallExpression_KtCallExpression(
    p1: Color = lerp(start = Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f),
    p2: Color = lerp(Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f),
    p3: Color = lerp(Color(0xffffffff), Color(0xff000000), 0.5f),
) = Unit

fun lerpKtParameter_KtCallExpression_KtNameReferenceExpression(
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    p1: Color = lerp(start = Color(0xffffffff), stop = lerpColor4, fraction = 0.5f),
    p2: Color = lerp(Color(0xffffffff), stop = lerpColor4, fraction = 0.5f),
    p3: Color = lerp(Color(0xffffffff), lerpColor4, 0.5f),
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    p4: Color = lerp(start = Color(0xffffffff), stop = lerpColor5, fraction = 0.5f),
    p5: Color = lerp(Color(0xffffffff), stop = lerpColor5, fraction = 0.5f),
    p6: Color = lerp(Color(0xffffffff), lerpColor5, 0.5f),
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    p7: Color = lerp(start = Color(0xffffffff), stop = lerpColor6, fraction = 0.5f),
    p8: Color = lerp(Color(0xffffffff), stop = lerpColor6, fraction = 0.5f),
    p9: Color = lerp(Color(0xffffffff), lerpColor6, 0.5f),
    //endregion
) = Unit

fun lerpKtParameter_KtNameReferenceExpression(
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    p1: Color = lerp(start = lerpColor1, stop = Color.Black, fraction = 0.5f),
    p2: Color = lerp(lerpColor1, stop = Color.Black, fraction = 0.5f),
    p3: Color = lerp(lerpColor1, Color.Black, 0.5f),

    p4: Color = lerp(start = lerpColor1, stop = Color(0xff000000), fraction = 0.5f),
    p5: Color = lerp(lerpColor1, stop = Color(0xff000000), fraction = 0.5f),
    p6: Color = lerp(lerpColor1, Color(0xff000000), 0.5f),

    p7: Color = lerp(start = lerpColor1, stop = lerpColor4, fraction = 0.5f),
    p8: Color = lerp(lerpColor1, stop = lerpColor4, fraction = 0.5f),
    p9: Color = lerp(lerpColor1, lerpColor4, 0.5f),

    p10: Color = lerp(start = lerpColor1, stop = lerpColor5, fraction = 0.5f),
    p11: Color = lerp(lerpColor1, stop = lerpColor5, fraction = 0.5f),
    p12: Color = lerp(lerpColor1, lerpColor5, 0.5f),

    p13: Color = lerp(start = lerpColor1, stop = lerpColor6, fraction = 0.5f),
    p14: Color = lerp(lerpColor1, stop = lerpColor6, fraction = 0.5f),
    p15: Color = lerp(lerpColor1, lerpColor6, 0.5f),
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    p16: Color = lerp(start = lerpColor2, stop = Color.Black, fraction = 0.5f),
    p17: Color = lerp(lerpColor2, stop = Color.Black, fraction = 0.5f),
    p18: Color = lerp(lerpColor2, Color.Black, 0.5f),

    p19: Color = lerp(start = lerpColor2, stop = Color(0xff000000), fraction = 0.5f),
    p20: Color = lerp(lerpColor2, stop = Color(0xff000000), fraction = 0.5f),
    p21: Color = lerp(lerpColor2, Color(0xff000000), 0.5f),

    p22: Color = lerp(start = lerpColor2, stop = lerpColor4, fraction = 0.5f),
    p23: Color = lerp(lerpColor2, stop = lerpColor4, fraction = 0.5f),
    p24: Color = lerp(lerpColor2, lerpColor4, 0.5f),

    p25: Color = lerp(start = lerpColor2, stop = lerpColor5, fraction = 0.5f),
    p26: Color = lerp(lerpColor2, stop = lerpColor5, fraction = 0.5f),
    p27: Color = lerp(lerpColor2, lerpColor5, 0.5f),

    p28: Color = lerp(start = lerpColor2, stop = lerpColor6, fraction = 0.5f),
    p29: Color = lerp(lerpColor2, stop = lerpColor6, fraction = 0.5f),
    p30: Color = lerp(lerpColor2, lerpColor6, 0.5f),
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    p31: Color = lerp(start = lerpColor3, stop = Color.Black, fraction = 0.5f),
    p32: Color = lerp(lerpColor3, stop = Color.Black, fraction = 0.5f),
    p33: Color = lerp(lerpColor3, Color.Black, 0.5f),

    p34: Color = lerp(start = lerpColor3, stop = Color(0xff000000), fraction = 0.5f),
    p35: Color = lerp(lerpColor3, stop = Color(0xff000000), fraction = 0.5f),
    p36: Color = lerp(lerpColor3, Color(0xff000000), 0.5f),

    p37: Color = lerp(start = lerpColor3, stop = lerpColor4, fraction = 0.5f),
    p38: Color = lerp(lerpColor3, stop = lerpColor4, fraction = 0.5f),
    p39: Color = lerp(lerpColor3, lerpColor4, 0.5f),

    p41: Color = lerp(start = lerpColor3, stop = lerpColor5, fraction = 0.5f),
    p42: Color = lerp(lerpColor3, stop = lerpColor5, fraction = 0.5f),
    p43: Color = lerp(lerpColor3, lerpColor5, 0.5f),

    p44: Color = lerp(start = lerpColor3, stop = lerpColor6, fraction = 0.5f),
    p45: Color = lerp(lerpColor3, stop = lerpColor6, fraction = 0.5f),
    p46: Color = lerp(lerpColor3, lerpColor6, 0.5f),
    //endregion
) = Unit
//endregion

//region KtValueArgument
fun lerpKtValueArgument_KtDotQualifiedExpression_KtDotQualifiedExpression() =
    lerpKtParameter_KtDotQualifiedExpression_KtDotQualifiedExpression(
        lerp(start = White, stop = Black, fraction = 0.5f),
        lerp(White, stop = Black, fraction = 0.5f),
        lerp(White, Black, 0.5f),
    )

fun lerpKtValueArgument_KtDotQualifiedExpression_KtCallExpression() =
    lerpKtParameter_KtDotQualifiedExpression_KtCallExpression(
        lerp(start = White, stop = Color(0xff000000), fraction = 0.5f),
        lerp(White, stop = Color(0xff000000), fraction = 0.5f),
        lerp(White, Color(0xff000000), 0.5f),
    )

fun lerpKtValueArgument_KtDotQualifiedExpression_KtNameReferenceExpression() =
    lerpKtParameter_KtDotQualifiedExpression_KtNameReferenceExpression(
        //region KtNameReferenceExpression -> KtDotQualifiedExpression
        lerp(start = White, stop = lerpColor4, fraction = 0.5f),
        lerp(White, stop = lerpColor4, fraction = 0.5f),
        lerp(White, lerpColor4, 0.5f),
        //endregion

        //region KtNameReferenceExpression -> KtNameReferenceExpression
        lerp(start = White, stop = lerpColor5, fraction = 0.5f),
        lerp(White, stop = lerpColor5, fraction = 0.5f),
        lerp(White, lerpColor5, 0.5f),
        //endregion

        //region KtNameReferenceExpression -> KtCallExpression
        lerp(start = White, stop = lerpColor6, fraction = 0.5f),
        lerp(White, stop = lerpColor6, fraction = 0.5f),
        lerp(White, lerpColor6, 0.5f),
        //endregion
    )

fun lerpKtValueArgument_KtCallExpression_KtDotQualifiedExpression() =
    lerpKtParameter_KtCallExpression_KtDotQualifiedExpression(
        lerp(start = Color(0xffffffff), stop = Black, fraction = 0.5f),
        lerp(Color(0xffffffff), stop = Black, fraction = 0.5f),
        lerp(Color(0xffffffff), Black, 0.5f),
    )

fun lerpKtValueArgument_KtCallExpression_KtCallExpression() =
    lerpKtParameter_KtCallExpression_KtCallExpression(
        lerp(start = Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f),
        lerp(Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f),
        lerp(Color(0xffffffff), Color(0xff000000), 0.5f),
    )

fun lerpKtValueArgument_KtCallExpression_KtNameReferenceExpression() =
    lerpKtParameter_KtCallExpression_KtNameReferenceExpression(
        //region KtNameReferenceExpression -> KtDotQualifiedExpression
        lerp(start = Color(0xffffffff), stop = lerpColor4, fraction = 0.5f),
        lerp(Color(0xffffffff), stop = lerpColor4, fraction = 0.5f),
        lerp(Color(0xffffffff), lerpColor4, 0.5f),
        //endregion

        //region KtNameReferenceExpression -> KtNameReferenceExpression
        lerp(start = Color(0xffffffff), stop = lerpColor5, fraction = 0.5f),
        lerp(Color(0xffffffff), stop = lerpColor5, fraction = 0.5f),
        lerp(Color(0xffffffff), lerpColor5, 0.5f),
        //endregion

        //region KtNameReferenceExpression -> KtCallExpression
        lerp(start = Color(0xffffffff), stop = lerpColor6, fraction = 0.5f),
        lerp(Color(0xffffffff), stop = lerpColor6, fraction = 0.5f),
        lerp(Color(0xffffffff), lerpColor6, 0.5f),
        //endregion
    )

fun lerpKtValueArgument_KtNameReferenceExpression() =
    lerpKtParameter_KtNameReferenceExpression(
        //region KtNameReferenceExpression -> KtDotQualifiedExpression
        lerp(start = lerpColor1, stop = Black, fraction = 0.5f),
        lerp(lerpColor1, stop = Black, fraction = 0.5f),
        lerp(lerpColor1, Black, 0.5f),

        lerp(start = lerpColor1, stop = Color(0xff000000), fraction = 0.5f),
        lerp(lerpColor1, stop = Color(0xff000000), fraction = 0.5f),
        lerp(lerpColor1, Color(0xff000000), 0.5f),

        lerp(start = lerpColor1, stop = lerpColor4, fraction = 0.5f),
        lerp(lerpColor1, stop = lerpColor4, fraction = 0.5f),
        lerp(lerpColor1, lerpColor4, 0.5f),

        lerp(start = lerpColor1, stop = lerpColor5, fraction = 0.5f),
        lerp(lerpColor1, stop = lerpColor5, fraction = 0.5f),
        lerp(lerpColor1, lerpColor5, 0.5f),

        lerp(start = lerpColor1, stop = lerpColor6, fraction = 0.5f),
        lerp(lerpColor1, stop = lerpColor6, fraction = 0.5f),
        lerp(lerpColor1, lerpColor6, 0.5f),
        //endregion

        //region KtNameReferenceExpression -> KtNameReferenceExpression
        lerp(start = lerpColor2, stop = Black, fraction = 0.5f),
        lerp(lerpColor2, stop = Black, fraction = 0.5f),
        lerp(lerpColor2, Black, 0.5f),

        lerp(start = lerpColor2, stop = Color(0xff000000), fraction = 0.5f),
        lerp(lerpColor2, stop = Color(0xff000000), fraction = 0.5f),
        lerp(lerpColor2, Color(0xff000000), 0.5f),

        lerp(start = lerpColor2, stop = lerpColor4, fraction = 0.5f),
        lerp(lerpColor2, stop = lerpColor4, fraction = 0.5f),
        lerp(lerpColor2, lerpColor4, 0.5f),

        lerp(start = lerpColor2, stop = lerpColor5, fraction = 0.5f),
        lerp(lerpColor2, stop = lerpColor5, fraction = 0.5f),
        lerp(lerpColor2, lerpColor5, 0.5f),

        lerp(start = lerpColor2, stop = lerpColor6, fraction = 0.5f),
        lerp(lerpColor2, stop = lerpColor6, fraction = 0.5f),
        lerp(lerpColor2, lerpColor6, 0.5f),
        //endregion

        //region KtNameReferenceExpression -> KtCallExpression
        lerp(start = lerpColor3, stop = Black, fraction = 0.5f),
        lerp(lerpColor3, stop = Black, fraction = 0.5f),
        lerp(lerpColor3, Black, 0.5f),

        lerp(start = lerpColor3, stop = Color(0xff000000), fraction = 0.5f),
        lerp(lerpColor3, stop = Color(0xff000000), fraction = 0.5f),
        lerp(lerpColor3, Color(0xff000000), 0.5f),

        lerp(start = lerpColor3, stop = lerpColor4, fraction = 0.5f),
        lerp(lerpColor3, stop = lerpColor4, fraction = 0.5f),
        lerp(lerpColor3, lerpColor4, 0.5f),

        lerp(start = lerpColor3, stop = lerpColor5, fraction = 0.5f),
        lerp(lerpColor3, stop = lerpColor5, fraction = 0.5f),
        lerp(lerpColor3, lerpColor5, 0.5f),

        lerp(start = lerpColor3, stop = lerpColor6, fraction = 0.5f),
        lerp(lerpColor3, stop = lerpColor6, fraction = 0.5f),
        lerp(lerpColor3, lerpColor6, 0.5f),
        //endregion
    )
//endregion

//region KtValueArgumentName
fun lerpKtValueArgumentName_KtDotQualifiedExpression_KtDotQualifiedExpression() =
    lerpKtParameter_KtDotQualifiedExpression_KtDotQualifiedExpression(
        p1 = lerp(start = White, stop = Black, fraction = 0.5f),
        p2 = lerp(White, stop = Black, fraction = 0.5f),
        p3 = lerp(White, Black, 0.5f),
    )

fun lerpKtValueArgumentName_KtDotQualifiedExpression_KtCallExpression() =
    lerpKtParameter_KtDotQualifiedExpression_KtCallExpression(
        p1 = lerp(start = White, stop = Color(0xff000000), fraction = 0.5f),
        p2 = lerp(White, stop = Color(0xff000000), fraction = 0.5f),
        p3 = lerp(White, Color(0xff000000), 0.5f),
    )

fun lerpKtValueArgumentName_KtDotQualifiedExpression_KtNameReferenceExpression() =
    lerpKtParameter_KtDotQualifiedExpression_KtNameReferenceExpression(
        //region KtNameReferenceExpression -> KtDotQualifiedExpression
        p1 = lerp(start = White, stop = lerpColor4, fraction = 0.5f),
        p2 = lerp(White, stop = lerpColor4, fraction = 0.5f),
        p3 = lerp(White, lerpColor4, 0.5f),
        //endregion

        //region KtNameReferenceExpression -> KtNameReferenceExpression
        p4 = lerp(start = White, stop = lerpColor5, fraction = 0.5f),
        p5 = lerp(White, stop = lerpColor5, fraction = 0.5f),
        p6 = lerp(White, lerpColor5, 0.5f),
        //endregion

        //region KtNameReferenceExpression -> KtCallExpression
        p7 = lerp(start = White, stop = lerpColor6, fraction = 0.5f),
        p8 = lerp(White, stop = lerpColor6, fraction = 0.5f),
        p9 = lerp(White, lerpColor6, 0.5f),
        //endregion
    )

fun lerpKtValueArgumentName_KtCallExpression_KtDotQualifiedExpression() =
    lerpKtParameter_KtCallExpression_KtDotQualifiedExpression(
        p1 = lerp(start = Color(0xffffffff), stop = Black, fraction = 0.5f),
        p2 = lerp(Color(0xffffffff), stop = Black, fraction = 0.5f),
        p3 = lerp(Color(0xffffffff), Black, 0.5f),
    )

fun lerpKtValueArgumentName_KtCallExpression_KtCallExpression() =
    lerpKtParameter_KtCallExpression_KtCallExpression(
        p1 = lerp(start = Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f),
        p2 = lerp(Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f),
        p3 = lerp(Color(0xffffffff), Color(0xff000000), 0.5f),
    )

fun lerpKtValueArgumentName_KtCallExpression_KtNameReferenceExpression() =
    lerpKtParameter_KtCallExpression_KtNameReferenceExpression(
        //region KtNameReferenceExpression -> KtDotQualifiedExpression
        p1 = lerp(start = Color(0xffffffff), stop = lerpColor4, fraction = 0.5f),
        p2 = lerp(Color(0xffffffff), stop = lerpColor4, fraction = 0.5f),
        p3 = lerp(Color(0xffffffff), lerpColor4, 0.5f),
        //endregion

        //region KtNameReferenceExpression -> KtNameReferenceExpression
        p4 = lerp(start = Color(0xffffffff), stop = lerpColor5, fraction = 0.5f),
        p5 = lerp(Color(0xffffffff), stop = lerpColor5, fraction = 0.5f),
        p6 = lerp(Color(0xffffffff), lerpColor5, 0.5f),
        //endregion

        //region KtNameReferenceExpression -> KtCallExpression
        p7 = lerp(start = Color(0xffffffff), stop = lerpColor6, fraction = 0.5f),
        p8 = lerp(Color(0xffffffff), stop = lerpColor6, fraction = 0.5f),
        p9 = lerp(Color(0xffffffff), lerpColor6, 0.5f),
        //endregion
    )

fun lerpKtValueArgumentName_KtNameReferenceExpression() =
    lerpKtParameter_KtNameReferenceExpression(
        //region KtNameReferenceExpression -> KtDotQualifiedExpression
        p1 = lerp(start = lerpColor1, stop = Black, fraction = 0.5f),
        p2 = lerp(lerpColor1, stop = Black, fraction = 0.5f),
        p3 = lerp(lerpColor1, Black, 0.5f),

        p4 = lerp(start = lerpColor1, stop = Color(0xff000000), fraction = 0.5f),
        p5 = lerp(lerpColor1, stop = Color(0xff000000), fraction = 0.5f),
        p6 = lerp(lerpColor1, Color(0xff000000), 0.5f),

        p7 = lerp(start = lerpColor1, stop = lerpColor4, fraction = 0.5f),
        p8 = lerp(lerpColor1, stop = lerpColor4, fraction = 0.5f),
        p9 = lerp(lerpColor1, lerpColor4, 0.5f),

        p10 = lerp(start = lerpColor1, stop = lerpColor5, fraction = 0.5f),
        p11 = lerp(lerpColor1, stop = lerpColor5, fraction = 0.5f),
        p12 = lerp(lerpColor1, lerpColor5, 0.5f),

        p13 = lerp(start = lerpColor1, stop = lerpColor6, fraction = 0.5f),
        p14 = lerp(lerpColor1, stop = lerpColor6, fraction = 0.5f),
        p15 = lerp(lerpColor1, lerpColor6, 0.5f),
        //endregion

        //region KtNameReferenceExpression -> KtNameReferenceExpression
        p16 = lerp(start = lerpColor2, stop = Black, fraction = 0.5f),
        p17 = lerp(lerpColor2, stop = Black, fraction = 0.5f),
        p18 = lerp(lerpColor2, Black, 0.5f),

        p19 = lerp(start = lerpColor2, stop = Color(0xff000000), fraction = 0.5f),
        p20 = lerp(lerpColor2, stop = Color(0xff000000), fraction = 0.5f),
        p21 = lerp(lerpColor2, Color(0xff000000), 0.5f),

        p22 = lerp(start = lerpColor2, stop = lerpColor4, fraction = 0.5f),
        p23 = lerp(lerpColor2, stop = lerpColor4, fraction = 0.5f),
        p24 = lerp(lerpColor2, lerpColor4, 0.5f),

        p25 = lerp(start = lerpColor2, stop = lerpColor5, fraction = 0.5f),
        p26 = lerp(lerpColor2, stop = lerpColor5, fraction = 0.5f),
        p27 = lerp(lerpColor2, lerpColor5, 0.5f),

        p28 = lerp(start = lerpColor2, stop = lerpColor6, fraction = 0.5f),
        p29 = lerp(lerpColor2, stop = lerpColor6, fraction = 0.5f),
        p30 = lerp(lerpColor2, lerpColor6, 0.5f),
        //endregion

        //region KtNameReferenceExpression -> KtCallExpression
        p31 = lerp(start = lerpColor3, stop = Black, fraction = 0.5f),
        p32 = lerp(lerpColor3, stop = Black, fraction = 0.5f),
        p33 = lerp(lerpColor3, Black, 0.5f),

        p34 = lerp(start = lerpColor3, stop = Color(0xff000000), fraction = 0.5f),
        p35 = lerp(lerpColor3, stop = Color(0xff000000), fraction = 0.5f),
        p36 = lerp(lerpColor3, Color(0xff000000), 0.5f),

        p37 = lerp(start = lerpColor3, stop = lerpColor4, fraction = 0.5f),
        p38 = lerp(lerpColor3, stop = lerpColor4, fraction = 0.5f),
        p39 = lerp(lerpColor3, lerpColor4, 0.5f),

        p41 = lerp(start = lerpColor3, stop = lerpColor5, fraction = 0.5f),
        p42 = lerp(lerpColor3, stop = lerpColor5, fraction = 0.5f),
        p43 = lerp(lerpColor3, lerpColor5, 0.5f),

        p44 = lerp(start = lerpColor3, stop = lerpColor6, fraction = 0.5f),
        p45 = lerp(lerpColor3, stop = lerpColor6, fraction = 0.5f),
        p46 = lerp(lerpColor3, lerpColor6, 0.5f),
        //endregion
    )
//endregion

//region KtReturnExpression
fun lerpKtReturnExpression_KtDotQualifiedExpression_KtDotQualifiedExpression(): Color {
    return lerp(start = Color.White, stop = Color.Black, fraction = 0.5f)
    return lerp(Color.White, stop = Color.Black, fraction = 0.5f)
    return lerp(Color.White, Color.Black, 0.5f)
}

fun lerpKtReturnExpression_KtDotQualifiedExpression_KtCallExpression(): Color {
    return lerp(start = Color.White, stop = Color(0xff000000), fraction = 0.5f)
    return lerp(Color.White, stop = Color(0xff000000), fraction = 0.5f)
    return lerp(Color.White, Color(0xff000000), 0.5f)
}

fun lerpKtReturnExpression_KtDotQualifiedExpression_KtNameReferenceExpression(): Color {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    return lerp(start = Color.White, stop = lerpColor4, fraction = 0.5f)
    return lerp(Color.White, stop = lerpColor4, fraction = 0.5f)
    return lerp(Color.White, lerpColor4, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    return lerp(start = Color.White, stop = lerpColor5, fraction = 0.5f)
    return lerp(Color.White, stop = lerpColor5, fraction = 0.5f)
    return lerp(Color.White, lerpColor5, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    return lerp(start = Color.White, stop = lerpColor6, fraction = 0.5f)
    return lerp(Color.White, stop = lerpColor6, fraction = 0.5f)
    return lerp(Color.White, lerpColor6, 0.5f)
    //endregion
}

fun lerpKtReturnExpression_KtCallExpression_KtDotQualifiedExpression(): Color {
    return lerp(start = Color(0xffffffff), stop = Color.Black, fraction = 0.5f)
    return lerp(Color(0xffffffff), stop = Color.Black, fraction = 0.5f)
    return lerp(Color(0xffffffff), Color.Black, 0.5f)
}

fun lerpKtReturnExpression_KtCallExpression_KtCallExpression(): Color {
    return lerp(start = Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f)
    return lerp(Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f)
    return lerp(Color(0xffffffff), Color(0xff000000), 0.5f)
}

fun lerpKtReturnExpression_KtCallExpression_KtNameReferenceExpression(): Color {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    return lerp(start = Color(0xffffffff), stop = lerpColor4, fraction = 0.5f)
    return lerp(Color(0xffffffff), stop = lerpColor4, fraction = 0.5f)
    return lerp(Color(0xffffffff), lerpColor4, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    return lerp(start = Color(0xffffffff), stop = lerpColor5, fraction = 0.5f)
    return lerp(Color(0xffffffff), stop = lerpColor5, fraction = 0.5f)
    return lerp(Color(0xffffffff), lerpColor5, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    return lerp(start = Color(0xffffffff), stop = lerpColor6, fraction = 0.5f)
    return lerp(Color(0xffffffff), stop = lerpColor6, fraction = 0.5f)
    return lerp(Color(0xffffffff), lerpColor6, 0.5f)
    //endregion
}

fun lerpKtReturnExpression_KtNameReferenceExpression(): Color {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    return lerp(start = lerpColor1, stop = Color.Black, fraction = 0.5f)
    return lerp(lerpColor1, stop = Color.Black, fraction = 0.5f)
    return lerp(lerpColor1, Color.Black, 0.5f)

    return lerp(start = lerpColor1, stop = Color(0xff000000), fraction = 0.5f)
    return lerp(lerpColor1, stop = Color(0xff000000), fraction = 0.5f)
    return lerp(lerpColor1, Color(0xff000000), 0.5f)

    return lerp(start = lerpColor1, stop = lerpColor4, fraction = 0.5f)
    return lerp(lerpColor1, stop = lerpColor4, fraction = 0.5f)
    return lerp(lerpColor1, lerpColor4, 0.5f)

    return lerp(start = lerpColor1, stop = lerpColor5, fraction = 0.5f)
    return lerp(lerpColor1, stop = lerpColor5, fraction = 0.5f)
    return lerp(lerpColor1, lerpColor5, 0.5f)

    return lerp(start = lerpColor1, stop = lerpColor6, fraction = 0.5f)
    return lerp(lerpColor1, stop = lerpColor6, fraction = 0.5f)
    return lerp(lerpColor1, lerpColor6, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    return lerp(start = lerpColor2, stop = Color.Black, fraction = 0.5f)
    return lerp(lerpColor2, stop = Color.Black, fraction = 0.5f)
    return lerp(lerpColor2, Color.Black, 0.5f)

    return lerp(start = lerpColor2, stop = Color(0xff000000), fraction = 0.5f)
    return lerp(lerpColor2, stop = Color(0xff000000), fraction = 0.5f)
    return lerp(lerpColor2, Color(0xff000000), 0.5f)

    return lerp(start = lerpColor2, stop = lerpColor4, fraction = 0.5f)
    return lerp(lerpColor2, stop = lerpColor4, fraction = 0.5f)
    return lerp(lerpColor2, lerpColor4, 0.5f)

    return lerp(start = lerpColor2, stop = lerpColor5, fraction = 0.5f)
    return lerp(lerpColor2, stop = lerpColor5, fraction = 0.5f)
    return lerp(lerpColor2, lerpColor5, 0.5f)

    return lerp(start = lerpColor2, stop = lerpColor6, fraction = 0.5f)
    return lerp(lerpColor2, stop = lerpColor6, fraction = 0.5f)
    return lerp(lerpColor2, lerpColor6, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    return lerp(start = lerpColor3, stop = Color.Black, fraction = 0.5f)
    return lerp(lerpColor3, stop = Color.Black, fraction = 0.5f)
    return lerp(lerpColor3, Color.Black, 0.5f)

    return lerp(start = lerpColor3, stop = Color(0xff000000), fraction = 0.5f)
    return lerp(lerpColor3, stop = Color(0xff000000), fraction = 0.5f)
    return lerp(lerpColor3, Color(0xff000000), 0.5f)

    return lerp(start = lerpColor3, stop = lerpColor4, fraction = 0.5f)
    return lerp(lerpColor3, stop = lerpColor4, fraction = 0.5f)
    return lerp(lerpColor3, lerpColor4, 0.5f)

    return lerp(start = lerpColor3, stop = lerpColor5, fraction = 0.5f)
    return lerp(lerpColor3, stop = lerpColor5, fraction = 0.5f)
    return lerp(lerpColor3, lerpColor5, 0.5f)

    return lerp(start = lerpColor3, stop = lerpColor6, fraction = 0.5f)
    return lerp(lerpColor3, stop = lerpColor6, fraction = 0.5f)
    return lerp(lerpColor3, lerpColor6, 0.5f)
    //endregion
}
//endregion

//region KtBinaryExpression
fun lerpKtBinaryExpression_KtDotQualifiedExpression_KtDotQualifiedExpression() {
    null ?: lerp(start = Color.White, stop = Color.Black, fraction = 0.5f)
    null ?: lerp(Color.White, stop = Color.Black, fraction = 0.5f)
    null ?: lerp(Color.White, Color.Black, 0.5f)
}

fun lerpKtBinaryExpression_KtDotQualifiedExpression_KtCallExpression() {
    null ?: lerp(start = Color.White, stop = Color(0xff000000), fraction = 0.5f)
    null ?: lerp(Color.White, stop = Color(0xff000000), fraction = 0.5f)
    null ?: lerp(Color.White, Color(0xff000000), 0.5f)
}

fun lerpKtBinaryExpression_KtDotQualifiedExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    null ?: lerp(start = Color.White, stop = lerpColor4, fraction = 0.5f)
    null ?: lerp(Color.White, stop = lerpColor4, fraction = 0.5f)
    null ?: lerp(Color.White, lerpColor4, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    null ?: lerp(start = Color.White, stop = lerpColor5, fraction = 0.5f)
    null ?: lerp(Color.White, stop = lerpColor5, fraction = 0.5f)
    null ?: lerp(Color.White, lerpColor5, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    null ?: lerp(start = Color.White, stop = lerpColor6, fraction = 0.5f)
    null ?: lerp(Color.White, stop = lerpColor6, fraction = 0.5f)
    null ?: lerp(Color.White, lerpColor6, 0.5f)
    //endregion
}

fun lerpKtBinaryExpression_KtCallExpression_KtDotQualifiedExpression() {
    null ?: lerp(start = Color(0xffffffff), stop = Color.Black, fraction = 0.5f)
    null ?: lerp(Color(0xffffffff), stop = Color.Black, fraction = 0.5f)
    null ?: lerp(Color(0xffffffff), Color.Black, 0.5f)
}

fun lerpKtBinaryExpression_KtCallExpression_KtCallExpression() {
    null ?: lerp(start = Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f)
    null ?: lerp(Color(0xffffffff), stop = Color(0xff000000), fraction = 0.5f)
    null ?: lerp(Color(0xffffffff), Color(0xff000000), 0.5f)
}

fun lerpKtBinaryExpression_KtCallExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    null ?: lerp(start = Color(0xffffffff), stop = lerpColor4, fraction = 0.5f)
    null ?: lerp(Color(0xffffffff), stop = lerpColor4, fraction = 0.5f)
    null ?: lerp(Color(0xffffffff), lerpColor4, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    null ?: lerp(start = Color(0xffffffff), stop = lerpColor5, fraction = 0.5f)
    null ?: lerp(Color(0xffffffff), stop = lerpColor5, fraction = 0.5f)
    null ?: lerp(Color(0xffffffff), lerpColor5, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    null ?: lerp(start = Color(0xffffffff), stop = lerpColor6, fraction = 0.5f)
    null ?: lerp(Color(0xffffffff), stop = lerpColor6, fraction = 0.5f)
    null ?: lerp(Color(0xffffffff), lerpColor6, 0.5f)
    //endregion
}

fun lerpKtBinaryExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    null ?: lerp(start = lerpColor1, stop = Color.Black, fraction = 0.5f)
    null ?: lerp(lerpColor1, stop = Color.Black, fraction = 0.5f)
    null ?: lerp(lerpColor1, Color.Black, 0.5f)

    null ?: lerp(start = lerpColor1, stop = Color(0xff000000), fraction = 0.5f)
    null ?: lerp(lerpColor1, stop = Color(0xff000000), fraction = 0.5f)
    null ?: lerp(lerpColor1, Color(0xff000000), 0.5f)

    null ?: lerp(start = lerpColor1, stop = lerpColor4, fraction = 0.5f)
    null ?: lerp(lerpColor1, stop = lerpColor4, fraction = 0.5f)
    null ?: lerp(lerpColor1, lerpColor4, 0.5f)

    null ?: lerp(start = lerpColor1, stop = lerpColor5, fraction = 0.5f)
    null ?: lerp(lerpColor1, stop = lerpColor5, fraction = 0.5f)
    null ?: lerp(lerpColor1, lerpColor5, 0.5f)

    null ?: lerp(start = lerpColor1, stop = lerpColor6, fraction = 0.5f)
    null ?: lerp(lerpColor1, stop = lerpColor6, fraction = 0.5f)
    null ?: lerp(lerpColor1, lerpColor6, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    null ?: lerp(start = lerpColor2, stop = Color.Black, fraction = 0.5f)
    null ?: lerp(lerpColor2, stop = Color.Black, fraction = 0.5f)
    null ?: lerp(lerpColor2, Color.Black, 0.5f)

    null ?: lerp(start = lerpColor2, stop = Color(0xff000000), fraction = 0.5f)
    null ?: lerp(lerpColor2, stop = Color(0xff000000), fraction = 0.5f)
    null ?: lerp(lerpColor2, Color(0xff000000), 0.5f)

    null ?: lerp(start = lerpColor2, stop = lerpColor4, fraction = 0.5f)
    null ?: lerp(lerpColor2, stop = lerpColor4, fraction = 0.5f)
    null ?: lerp(lerpColor2, lerpColor4, 0.5f)

    null ?: lerp(start = lerpColor2, stop = lerpColor5, fraction = 0.5f)
    null ?: lerp(lerpColor2, stop = lerpColor5, fraction = 0.5f)
    null ?: lerp(lerpColor2, lerpColor5, 0.5f)

    null ?: lerp(start = lerpColor2, stop = lerpColor6, fraction = 0.5f)
    null ?: lerp(lerpColor2, stop = lerpColor6, fraction = 0.5f)
    null ?: lerp(lerpColor2, lerpColor6, 0.5f)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    null ?: lerp(start = lerpColor3, stop = Color.Black, fraction = 0.5f)
    null ?: lerp(lerpColor3, stop = Color.Black, fraction = 0.5f)
    null ?: lerp(lerpColor3, Color.Black, 0.5f)

    null ?: lerp(start = lerpColor3, stop = Color(0xff000000), fraction = 0.5f)
    null ?: lerp(lerpColor3, stop = Color(0xff000000), fraction = 0.5f)
    null ?: lerp(lerpColor3, Color(0xff000000), 0.5f)

    null ?: lerp(start = lerpColor3, stop = lerpColor4, fraction = 0.5f)
    null ?: lerp(lerpColor3, stop = lerpColor4, fraction = 0.5f)
    null ?: lerp(lerpColor3, lerpColor4, 0.5f)

    null ?: lerp(start = lerpColor3, stop = lerpColor5, fraction = 0.5f)
    null ?: lerp(lerpColor3, stop = lerpColor5, fraction = 0.5f)
    null ?: lerp(lerpColor3, lerpColor5, 0.5f)

    null ?: lerp(start = lerpColor3, stop = lerpColor6, fraction = 0.5f)
    null ?: lerp(lerpColor3, stop = lerpColor6, fraction = 0.5f)
    null ?: lerp(lerpColor3, lerpColor6, 0.5f)
    //endregion
}
//endregion
