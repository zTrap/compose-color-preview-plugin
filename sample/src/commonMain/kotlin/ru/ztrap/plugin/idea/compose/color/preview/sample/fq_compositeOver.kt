@file:Suppress("RemoveRedundantQualifierName", "unused", "UNUSED_VARIABLE", "UNREACHABLE_CODE", "UNUSED_PARAMETER", "SameReturnValue", "FunctionName")

package ru.ztrap.plugin.idea.compose.color.preview.sample

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.compositeOver

val compositeOverC1 = Color.White
val compositeOverC2 = White
val compositeOverC3 = Color(0xffffffff)

val compositeOverC4 = Color.Black
val compositeOverC5 = Black
val compositeOverC6 = Color(0xff000000)

//region KtPropertyAccessor
val compositeOverP1 get() = Color.White.compositeOver(background = Color.Black)
val compositeOverP2 get() = Color.White.compositeOver(Color.Black)

val compositeOverP3 get() = Color.White.compositeOver(background = Color(0xff000000))
val compositeOverP4 get() = Color.White.compositeOver(Color(0xff000000))

val compositeOverP5 get() = Color.White.compositeOver(background = compositeOverC4)
val compositeOverP6 get() = Color.White.compositeOver(compositeOverC4)

val compositeOverP7 get() = Color.White.compositeOver(background = compositeOverC5)
val compositeOverP8 get() = Color.White.compositeOver(compositeOverC5)

val compositeOverP9 get() = Color.White.compositeOver(background = compositeOverC6)
val compositeOverP10 get() = Color.White.compositeOver(compositeOverC6)

val compositeOverP11 get() = Color(0xffffffff).compositeOver(background = Color.Black)
val compositeOverP12 get() = Color(0xffffffff).compositeOver(Color.Black)

val compositeOverP13 get() = Color(0xffffffff).compositeOver(background = Color(0xff000000))
val compositeOverP14 get() = Color(0xffffffff).compositeOver(Color(0xff000000))

val compositeOverP15 get() = Color(0xffffffff).compositeOver(background = compositeOverC4)
val compositeOverP16 get() = Color(0xffffffff).compositeOver(compositeOverC4)

val compositeOverP17 get() = Color(0xffffffff).compositeOver(background = compositeOverC5)
val compositeOverP18 get() = Color(0xffffffff).compositeOver(compositeOverC5)

val compositeOverP19 get() = Color(0xffffffff).compositeOver(background = compositeOverC6)
val compositeOverP20 get() = Color(0xffffffff).compositeOver(compositeOverC6)

val compositeOverP21 get() = compositeOverC1.compositeOver(background = Color.Black)
val compositeOverP22 get() = compositeOverC1.compositeOver(Color.Black)

val compositeOverP23 get() = compositeOverC1.compositeOver(background = Color(0xff000000))
val compositeOverP24 get() = compositeOverC1.compositeOver(Color(0xff000000))

val compositeOverP25 get() = compositeOverC1.compositeOver(background = compositeOverC4)
val compositeOverP26 get() = compositeOverC1.compositeOver(compositeOverC4)

val compositeOverP27 get() = compositeOverC1.compositeOver(background = compositeOverC5)
val compositeOverP28 get() = compositeOverC1.compositeOver(compositeOverC5)

val compositeOverP29 get() = compositeOverC1.compositeOver(background = compositeOverC6)
val compositeOverP30 get() = compositeOverC1.compositeOver(compositeOverC6)

val compositeOverP31 get() = compositeOverC2.compositeOver(background = Color.Black)
val compositeOverP32 get() = compositeOverC2.compositeOver(Color.Black)

val compositeOverP33 get() = compositeOverC2.compositeOver(background = Color(0xff000000))
val compositeOverP34 get() = compositeOverC2.compositeOver(Color(0xff000000))

val compositeOverP35 get() = compositeOverC2.compositeOver(background = compositeOverC4)
val compositeOverP36 get() = compositeOverC2.compositeOver(compositeOverC4)

val compositeOverP37 get() = compositeOverC2.compositeOver(background = compositeOverC5)
val compositeOverP38 get() = compositeOverC2.compositeOver(compositeOverC5)

val compositeOverP39 get() = compositeOverC2.compositeOver(background = compositeOverC6)
val compositeOverP40 get() = compositeOverC2.compositeOver(compositeOverC6)

val compositeOverP41 get() = compositeOverC3.compositeOver(background = Color.Black)
val compositeOverP42 get() = compositeOverC3.compositeOver(Color.Black)

val compositeOverP43 get() = compositeOverC3.compositeOver(background = Color(0xff000000))
val compositeOverP44 get() = compositeOverC3.compositeOver(Color(0xff000000))

val compositeOverP45 get() = compositeOverC3.compositeOver(background = compositeOverC4)
val compositeOverP46 get() = compositeOverC3.compositeOver(compositeOverC4)

val compositeOverP47 get() = compositeOverC3.compositeOver(background = compositeOverC5)
val compositeOverP48 get() = compositeOverC3.compositeOver(compositeOverC5)

val compositeOverP49 get() = compositeOverC3.compositeOver(background = compositeOverC6)
val compositeOverP50 get() = compositeOverC3.compositeOver(compositeOverC6)
//endregion

//region KtBlockExpression
fun compositeOverKtBlockExpression_KtDotQualifiedExpression_KtDotQualifiedExpression() {
    Color.White.compositeOver(background = Color.Black)
    Color.White.compositeOver(Color.Black)
}

fun compositeOverKtBlockExpression_KtDotQualifiedExpression_KtCallExpression() {
    Color.White.compositeOver(background = Color(0xff000000))
    Color.White.compositeOver(Color(0xff000000))
}

fun compositeOverKtBlockExpression_KtDotQualifiedExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    Color.White.compositeOver(background = compositeOverC4)
    Color.White.compositeOver(compositeOverC4)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    Color.White.compositeOver(background = compositeOverC5)
    Color.White.compositeOver(compositeOverC5)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    Color.White.compositeOver(background = compositeOverC6)
    Color.White.compositeOver(compositeOverC6)
    //endregion
}

fun compositeOverKtBlockExpression_KtCallExpression_KtDotQualifiedExpression() {
    Color(0xffffffff).compositeOver(background = Color.Black)
    Color(0xffffffff).compositeOver(Color.Black)
}

fun compositeOverKtBlockExpression_KtCallExpression_KtCallExpression() {
    Color(0xffffffff).compositeOver(background = Color(0xff000000))
    Color(0xffffffff).compositeOver(Color(0xff000000))
}

fun compositeOverKtBlockExpression_KtCallExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    Color(0xffffffff).compositeOver(background = compositeOverC4)
    Color(0xffffffff).compositeOver(compositeOverC4)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    Color(0xffffffff).compositeOver(background = compositeOverC5)
    Color(0xffffffff).compositeOver(compositeOverC5)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    Color(0xffffffff).compositeOver(background = compositeOverC6)
    Color(0xffffffff).compositeOver(compositeOverC6)
    //endregion
}

fun compositeOverKtBlockExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    compositeOverC1.compositeOver(background = Color.Black)
    compositeOverC1.compositeOver(Color.Black)

    compositeOverC1.compositeOver(background = Color(0xff000000))
    compositeOverC1.compositeOver(Color(0xff000000))

    compositeOverC1.compositeOver(background = compositeOverC4)
    compositeOverC1.compositeOver(compositeOverC4)

    compositeOverC1.compositeOver(background = compositeOverC5)
    compositeOverC1.compositeOver(compositeOverC5)

    compositeOverC1.compositeOver(background = compositeOverC6)
    compositeOverC1.compositeOver(compositeOverC6)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    compositeOverC2.compositeOver(background = Color.Black)
    compositeOverC2.compositeOver(Color.Black)

    compositeOverC2.compositeOver(background = Color(0xff000000))
    compositeOverC2.compositeOver(Color(0xff000000))

    compositeOverC2.compositeOver(background = compositeOverC4)
    compositeOverC2.compositeOver(compositeOverC4)

    compositeOverC2.compositeOver(background = compositeOverC5)
    compositeOverC2.compositeOver(compositeOverC5)

    compositeOverC2.compositeOver(background = compositeOverC6)
    compositeOverC2.compositeOver(compositeOverC6)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    compositeOverC3.compositeOver(background = Color.Black)
    compositeOverC3.compositeOver(Color.Black)

    compositeOverC3.compositeOver(background = Color(0xff000000))
    compositeOverC3.compositeOver(Color(0xff000000))

    compositeOverC3.compositeOver(background = compositeOverC4)
    compositeOverC3.compositeOver(compositeOverC4)

    compositeOverC3.compositeOver(background = compositeOverC5)
    compositeOverC3.compositeOver(compositeOverC5)

    compositeOverC3.compositeOver(background = compositeOverC6)
    compositeOverC3.compositeOver(compositeOverC6)
    //endregion
}
//endregion

//region KtProperty
fun compositeOverKtProperty_KtDotQualifiedExpression_KtDotQualifiedExpression() {
    val p1 = Color.White.compositeOver(background = Color.Black)
    val p2 = Color.White.compositeOver(Color.Black)
}

fun compositeOverKtProperty_KtDotQualifiedExpression_KtCallExpression() {
    val p1 = Color.White.compositeOver(background = Color(0xff000000))
    val p2 = Color.White.compositeOver(Color(0xff000000))
}

fun compositeOverKtProperty_KtDotQualifiedExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    val p1 = Color.White.compositeOver(background = compositeOverC4)
    val p2 = Color.White.compositeOver(compositeOverC4)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    val p3 = Color.White.compositeOver(background = compositeOverC5)
    val p4 = Color.White.compositeOver(compositeOverC5)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    val p5 = Color.White.compositeOver(background = compositeOverC6)
    val p6 = Color.White.compositeOver(compositeOverC6)
    //endregion
}

fun compositeOverKtProperty_KtCallExpression_KtDotQualifiedExpression() {
    val p1 = Color(0xffffffff).compositeOver(background = Color.Black)
    val p2 = Color(0xffffffff).compositeOver(Color.Black)
}

fun compositeOverKtProperty_KtCallExpression_KtCallExpression() {
    val p1 = Color(0xffffffff).compositeOver(background = Color(0xff000000))
    val p2 = Color(0xffffffff).compositeOver(Color(0xff000000))
}

fun compositeOverKtProperty_KtCallExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    val p1 = Color(0xffffffff).compositeOver(background = compositeOverC4)
    val p2 = Color(0xffffffff).compositeOver(compositeOverC4)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    val p3 = Color(0xffffffff).compositeOver(background = compositeOverC5)
    val p4 = Color(0xffffffff).compositeOver(compositeOverC5)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    val p5 = Color(0xffffffff).compositeOver(background = compositeOverC6)
    val p6 = Color(0xffffffff).compositeOver(compositeOverC6)
    //endregion
}

fun compositeOverKtProperty_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    val p1 = compositeOverC1.compositeOver(background = Color.Black)
    val p2 = compositeOverC1.compositeOver(Color.Black)

    val p3 = compositeOverC1.compositeOver(background = Color(0xff000000))
    val p4 = compositeOverC1.compositeOver(Color(0xff000000))

    val p5 = compositeOverC1.compositeOver(background = compositeOverC4)
    val p6 = compositeOverC1.compositeOver(compositeOverC4)

    val p7 = compositeOverC1.compositeOver(background = compositeOverC5)
    val p8 = compositeOverC1.compositeOver(compositeOverC5)

    val p9 = compositeOverC1.compositeOver(background = compositeOverC6)
    val p10 = compositeOverC1.compositeOver(compositeOverC6)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    val p11 = compositeOverC2.compositeOver(background = Color.Black)
    val p12 = compositeOverC2.compositeOver(Color.Black)

    val p13 = compositeOverC2.compositeOver(background = Color(0xff000000))
    val p14 = compositeOverC2.compositeOver(Color(0xff000000))

    val p15 = compositeOverC2.compositeOver(background = compositeOverC4)
    val p16 = compositeOverC2.compositeOver(compositeOverC4)

    val p17 = compositeOverC2.compositeOver(background = compositeOverC5)
    val p18 = compositeOverC2.compositeOver(compositeOverC5)

    val p19 = compositeOverC2.compositeOver(background = compositeOverC6)
    val p20 = compositeOverC2.compositeOver(compositeOverC6)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    val p21 = compositeOverC3.compositeOver(background = Color.Black)
    val p22 = compositeOverC3.compositeOver(Color.Black)

    val p23 = compositeOverC3.compositeOver(background = Color(0xff000000))
    val p24 = compositeOverC3.compositeOver(Color(0xff000000))

    val p25 = compositeOverC3.compositeOver(background = compositeOverC4)
    val p26 = compositeOverC3.compositeOver(compositeOverC4)

    val p27 = compositeOverC3.compositeOver(background = compositeOverC5)
    val p28 = compositeOverC3.compositeOver(compositeOverC5)

    val p29 = compositeOverC3.compositeOver(background = compositeOverC6)
    val p30 = compositeOverC3.compositeOver(compositeOverC6)
    //endregion
}
//endregion

//region KtParameter
fun compositeOverKtParameter_KtDotQualifiedExpression_KtDotQualifiedExpression(
    p1: Color = Color.White.compositeOver(background = Color.Black),
    p2: Color = Color.White.compositeOver(Color.Black),
) = Unit

fun compositeOverKtParameter_KtDotQualifiedExpression_KtCallExpression(
    p1: Color = Color.White.compositeOver(background = Color(0xff000000)),
    p2: Color = Color.White.compositeOver(Color(0xff000000)),
) = Unit

fun compositeOverKtParameter_KtDotQualifiedExpression_KtNameReferenceExpression(
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    p1: Color = Color.White.compositeOver(background = compositeOverC4),
    p2: Color = Color.White.compositeOver(compositeOverC4),
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    p3: Color = Color.White.compositeOver(background = compositeOverC5),
    p4: Color = Color.White.compositeOver(compositeOverC5),
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    p5: Color = Color.White.compositeOver(background = compositeOverC6),
    p6: Color = Color.White.compositeOver(compositeOverC6),
    //endregion
) = Unit

fun compositeOverKtParameter_KtCallExpression_KtDotQualifiedExpression(
    p1: Color = Color(0xffffffff).compositeOver(background = Color.Black),
    p2: Color = Color(0xffffffff).compositeOver(Color.Black),
) = Unit

fun compositeOverKtParameter_KtCallExpression_KtCallExpression(
    p1: Color = Color(0xffffffff).compositeOver(background = Color(0xff000000)),
    p2: Color = Color(0xffffffff).compositeOver(Color(0xff000000)),
) = Unit

fun compositeOverKtParameter_KtCallExpression_KtNameReferenceExpression(
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    p1: Color = Color(0xffffffff).compositeOver(background = compositeOverC4),
    p2: Color = Color(0xffffffff).compositeOver(compositeOverC4),
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    p3: Color = Color(0xffffffff).compositeOver(background = compositeOverC5),
    p4: Color = Color(0xffffffff).compositeOver(compositeOverC5),
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    p5: Color = Color(0xffffffff).compositeOver(background = compositeOverC6),
    p6: Color = Color(0xffffffff).compositeOver(compositeOverC6),
    //endregion
) = Unit

fun compositeOverKtParameter_KtNameReferenceExpression(
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    p1: Color = compositeOverC1.compositeOver(background = Color.Black),
    p2: Color = compositeOverC1.compositeOver(Color.Black),

    p3: Color = compositeOverC1.compositeOver(background = Color(0xff000000)),
    p4: Color = compositeOverC1.compositeOver(Color(0xff000000)),

    p5: Color = compositeOverC1.compositeOver(background = compositeOverC4),
    p6: Color = compositeOverC1.compositeOver(compositeOverC4),

    p7: Color = compositeOverC1.compositeOver(background = compositeOverC5),
    p8: Color = compositeOverC1.compositeOver(compositeOverC5),

    p9: Color = compositeOverC1.compositeOver(background = compositeOverC6),
    p10: Color = compositeOverC1.compositeOver(compositeOverC6),
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    p11: Color = compositeOverC2.compositeOver(background = Color.Black),
    p12: Color = compositeOverC2.compositeOver(Color.Black),

    p13: Color = compositeOverC2.compositeOver(background = Color(0xff000000)),
    p14: Color = compositeOverC2.compositeOver(Color(0xff000000)),

    p15: Color = compositeOverC2.compositeOver(background = compositeOverC4),
    p16: Color = compositeOverC2.compositeOver(compositeOverC4),

    p17: Color = compositeOverC2.compositeOver(background = compositeOverC5),
    p18: Color = compositeOverC2.compositeOver(compositeOverC5),

    p19: Color = compositeOverC2.compositeOver(background = compositeOverC6),
    p20: Color = compositeOverC2.compositeOver(compositeOverC6),
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    p21: Color = compositeOverC3.compositeOver(background = Color.Black),
    p22: Color = compositeOverC3.compositeOver(Color.Black),

    p23: Color = compositeOverC3.compositeOver(background = Color(0xff000000)),
    p24: Color = compositeOverC3.compositeOver(Color(0xff000000)),

    p25: Color = compositeOverC3.compositeOver(background = compositeOverC4),
    p26: Color = compositeOverC3.compositeOver(compositeOverC4),

    p27: Color = compositeOverC3.compositeOver(background = compositeOverC5),
    p28: Color = compositeOverC3.compositeOver(compositeOverC5),

    p29: Color = compositeOverC3.compositeOver(background = compositeOverC6),
    p30: Color = compositeOverC3.compositeOver(compositeOverC6),
    //endregion
) = Unit
//endregion

//region KtValueArgument
fun compositeOverKtValueArgument_KtDotQualifiedExpression_KtDotQualifiedExpression() =
    compositeOverKtParameter_KtDotQualifiedExpression_KtDotQualifiedExpression(
        White.compositeOver(background = Black),
        White.compositeOver(Black),
    )

fun compositeOverKtValueArgument_KtDotQualifiedExpression_KtCallExpression() =
    compositeOverKtParameter_KtDotQualifiedExpression_KtCallExpression(
        White.compositeOver(background = Color(0xff000000)),
        White.compositeOver(Color(0xff000000)),
    )

fun compositeOverKtValueArgument_KtDotQualifiedExpression_KtNameReferenceExpression() =
    compositeOverKtParameter_KtDotQualifiedExpression_KtNameReferenceExpression(
        //region KtNameReferenceExpression -> KtDotQualifiedExpression
        White.compositeOver(background = compositeOverC4),
        White.compositeOver(compositeOverC4),
        //endregion

        //region KtNameReferenceExpression -> KtNameReferenceExpression
        White.compositeOver(background = compositeOverC5),
        White.compositeOver(compositeOverC5),
        //endregion

        //region KtNameReferenceExpression -> KtCallExpression
        White.compositeOver(background = compositeOverC6),
        White.compositeOver(compositeOverC6),
        //endregion
    )

fun compositeOverKtValueArgument_KtCallExpression_KtDotQualifiedExpression() =
    compositeOverKtParameter_KtCallExpression_KtDotQualifiedExpression(
        Color(0xffffffff).compositeOver(background = Black),
        Color(0xffffffff).compositeOver(Black),
    )

fun compositeOverKtValueArgument_KtCallExpression_KtCallExpression() =
    compositeOverKtParameter_KtCallExpression_KtCallExpression(
        Color(0xffffffff).compositeOver(background = Color(0xff000000)),
        Color(0xffffffff).compositeOver(Color(0xff000000)),
    )

fun compositeOverKtValueArgument_KtCallExpression_KtNameReferenceExpression() =
    compositeOverKtParameter_KtCallExpression_KtNameReferenceExpression(
        //region KtNameReferenceExpression -> KtDotQualifiedExpression
        Color(0xffffffff).compositeOver(background = compositeOverC4),
        Color(0xffffffff).compositeOver(compositeOverC4),
        //endregion

        //region KtNameReferenceExpression -> KtNameReferenceExpression
        Color(0xffffffff).compositeOver(background = compositeOverC5),
        Color(0xffffffff).compositeOver(compositeOverC5),
        //endregion

        //region KtNameReferenceExpression -> KtCallExpression
        Color(0xffffffff).compositeOver(background = compositeOverC6),
        Color(0xffffffff).compositeOver(compositeOverC6),
        //endregion
    )

fun compositeOverKtValueArgument_KtNameReferenceExpression() =
    compositeOverKtParameter_KtNameReferenceExpression(
        //region KtNameReferenceExpression -> KtDotQualifiedExpression
        compositeOverC1.compositeOver(background = Black),
        compositeOverC1.compositeOver(Black),

        compositeOverC1.compositeOver(background = Color(0xff000000)),
        compositeOverC1.compositeOver(Color(0xff000000)),

        compositeOverC1.compositeOver(background = compositeOverC4),
        compositeOverC1.compositeOver(compositeOverC4),

        compositeOverC1.compositeOver(background = compositeOverC5),
        compositeOverC1.compositeOver(compositeOverC5),

        compositeOverC1.compositeOver(background = compositeOverC6),
        compositeOverC1.compositeOver(compositeOverC6),
        //endregion

        //region KtNameReferenceExpression -> KtNameReferenceExpression
        compositeOverC2.compositeOver(background = Black),
        compositeOverC2.compositeOver(Black),

        compositeOverC2.compositeOver(background = Color(0xff000000)),
        compositeOverC2.compositeOver(Color(0xff000000)),

        compositeOverC2.compositeOver(background = compositeOverC4),
        compositeOverC2.compositeOver(compositeOverC4),

        compositeOverC2.compositeOver(background = compositeOverC5),
        compositeOverC2.compositeOver(compositeOverC5),

        compositeOverC2.compositeOver(background = compositeOverC6),
        compositeOverC2.compositeOver(compositeOverC6),
        //endregion

        //region KtNameReferenceExpression -> KtCallExpression
        compositeOverC3.compositeOver(background = Black),
        compositeOverC3.compositeOver(Black),

        compositeOverC3.compositeOver(background = Color(0xff000000)),
        compositeOverC3.compositeOver(Color(0xff000000)),

        compositeOverC3.compositeOver(background = compositeOverC4),
        compositeOverC3.compositeOver(compositeOverC4),

        compositeOverC3.compositeOver(background = compositeOverC5),
        compositeOverC3.compositeOver(compositeOverC5),

        compositeOverC3.compositeOver(background = compositeOverC6),
        compositeOverC3.compositeOver(compositeOverC6),
        //endregion
    )
//endregion

//region KtValueArgumentName
fun compositeOverKtValueArgumentName_KtDotQualifiedExpression_KtDotQualifiedExpression() =
    compositeOverKtParameter_KtDotQualifiedExpression_KtDotQualifiedExpression(
        p1 = White.compositeOver(background = Black),
        p2 = White.compositeOver(Black),
    )

fun compositeOverKtValueArgumentName_KtDotQualifiedExpression_KtCallExpression() =
    compositeOverKtParameter_KtDotQualifiedExpression_KtCallExpression(
        p1 = White.compositeOver(background = Color(0xff000000)),
        p2 = White.compositeOver(Color(0xff000000)),
    )

fun compositeOverKtValueArgumentName_KtDotQualifiedExpression_KtNameReferenceExpression() =
    compositeOverKtParameter_KtDotQualifiedExpression_KtNameReferenceExpression(
        //region KtNameReferenceExpression -> KtDotQualifiedExpression
        p1 = White.compositeOver(background = compositeOverC4),
        p2 = White.compositeOver(compositeOverC4),
        //endregion

        //region KtNameReferenceExpression -> KtNameReferenceExpression
        p3 = White.compositeOver(background = compositeOverC5),
        p4 = White.compositeOver(compositeOverC5),
        //endregion

        //region KtNameReferenceExpression -> KtCallExpression
        p5 = White.compositeOver(background = compositeOverC6),
        p6 = White.compositeOver(compositeOverC6),
        //endregion
    )

fun compositeOverKtValueArgumentName_KtCallExpression_KtDotQualifiedExpression() =
    compositeOverKtParameter_KtCallExpression_KtDotQualifiedExpression(
        p1 = Color(0xffffffff).compositeOver(background = Black),
        p2 = Color(0xffffffff).compositeOver(Black),
    )

fun compositeOverKtValueArgumentName_KtCallExpression_KtCallExpression() =
    compositeOverKtParameter_KtCallExpression_KtCallExpression(
        p1 = Color(0xffffffff).compositeOver(background = Color(0xff000000)),
        p2 = Color(0xffffffff).compositeOver(Color(0xff000000)),
    )

fun compositeOverKtValueArgumentName_KtCallExpression_KtNameReferenceExpression() =
    compositeOverKtParameter_KtCallExpression_KtNameReferenceExpression(
        //region KtNameReferenceExpression -> KtDotQualifiedExpression
        p1 = Color(0xffffffff).compositeOver(background = compositeOverC4),
        p2 = Color(0xffffffff).compositeOver(compositeOverC4),
        //endregion

        //region KtNameReferenceExpression -> KtNameReferenceExpression
        p3 = Color(0xffffffff).compositeOver(background = compositeOverC5),
        p4 = Color(0xffffffff).compositeOver(compositeOverC5),
        //endregion

        //region KtNameReferenceExpression -> KtCallExpression
        p5 = Color(0xffffffff).compositeOver(background = compositeOverC6),
        p6 = Color(0xffffffff).compositeOver(compositeOverC6),
        //endregion
    )

fun compositeOverKtValueArgumentName_KtNameReferenceExpression() =
    compositeOverKtParameter_KtNameReferenceExpression(
        //region KtNameReferenceExpression -> KtDotQualifiedExpression
        p1 = compositeOverC1.compositeOver(background = Black),
        p2 = compositeOverC1.compositeOver(Black),

        p3 = compositeOverC1.compositeOver(background = Color(0xff000000)),
        p4 = compositeOverC1.compositeOver(Color(0xff000000)),

        p5 = compositeOverC1.compositeOver(background = compositeOverC4),
        p6 = compositeOverC1.compositeOver(compositeOverC4),

        p7 = compositeOverC1.compositeOver(background = compositeOverC5),
        p8 = compositeOverC1.compositeOver(compositeOverC5),

        p9 = compositeOverC1.compositeOver(background = compositeOverC6),
        p10 = compositeOverC1.compositeOver(compositeOverC6),
        //endregion

        //region KtNameReferenceExpression -> KtNameReferenceExpression
        p11 = compositeOverC2.compositeOver(background = Black),
        p12 = compositeOverC2.compositeOver(Black),

        p13 = compositeOverC2.compositeOver(background = Color(0xff000000)),
        p14 = compositeOverC2.compositeOver(Color(0xff000000)),

        p15 = compositeOverC2.compositeOver(background = compositeOverC4),
        p16 = compositeOverC2.compositeOver(compositeOverC4),

        p17 = compositeOverC2.compositeOver(background = compositeOverC5),
        p18 = compositeOverC2.compositeOver(compositeOverC5),

        p19 = compositeOverC2.compositeOver(background = compositeOverC6),
        p20 = compositeOverC2.compositeOver(compositeOverC6),
        //endregion

        //region KtNameReferenceExpression -> KtCallExpression
        p21 = compositeOverC3.compositeOver(background = Black),
        p22 = compositeOverC3.compositeOver(Black),

        p23 = compositeOverC3.compositeOver(background = Color(0xff000000)),
        p24 = compositeOverC3.compositeOver(Color(0xff000000)),

        p25 = compositeOverC3.compositeOver(background = compositeOverC4),
        p26 = compositeOverC3.compositeOver(compositeOverC4),

        p27 = compositeOverC3.compositeOver(background = compositeOverC5),
        p28 = compositeOverC3.compositeOver(compositeOverC5),

        p29 = compositeOverC3.compositeOver(background = compositeOverC6),
        p30 = compositeOverC3.compositeOver(compositeOverC6),
        //endregion
    )
//endregion

//region KtReturnExpression
fun compositeOverKtReturnExpression_KtDotQualifiedExpression_KtDotQualifiedExpression(): Color {
    return Color.White.compositeOver(background = Color.Black)
    return Color.White.compositeOver(Color.Black)
}

fun compositeOverKtReturnExpression_KtDotQualifiedExpression_KtCallExpression(): Color {
    return Color.White.compositeOver(background = Color(0xff000000))
    return Color.White.compositeOver(Color(0xff000000))
}

fun compositeOverKtReturnExpression_KtDotQualifiedExpression_KtNameReferenceExpression(): Color {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    return Color.White.compositeOver(background = compositeOverC4)
    return Color.White.compositeOver(compositeOverC4)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    return Color.White.compositeOver(background = compositeOverC5)
    return Color.White.compositeOver(compositeOverC5)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    return Color.White.compositeOver(background = compositeOverC6)
    return Color.White.compositeOver(compositeOverC6)
    //endregion
}

fun compositeOverKtReturnExpression_KtCallExpression_KtDotQualifiedExpression(): Color {
    return Color(0xffffffff).compositeOver(background = Color.Black)
    return Color(0xffffffff).compositeOver(Color.Black)
}

fun compositeOverKtReturnExpression_KtCallExpression_KtCallExpression(): Color {
    return Color(0xffffffff).compositeOver(background = Color(0xff000000))
    return Color(0xffffffff).compositeOver(Color(0xff000000))
}

fun compositeOverKtReturnExpression_KtCallExpression_KtNameReferenceExpression(): Color {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    return Color(0xffffffff).compositeOver(background = compositeOverC4)
    return Color(0xffffffff).compositeOver(compositeOverC4)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    return Color(0xffffffff).compositeOver(background = compositeOverC5)
    return Color(0xffffffff).compositeOver(compositeOverC5)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    return Color(0xffffffff).compositeOver(background = compositeOverC6)
    return Color(0xffffffff).compositeOver(compositeOverC6)
    //endregion
}

fun compositeOverKtReturnExpression_KtNameReferenceExpression(): Color {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    return compositeOverC1.compositeOver(background = Color.Black)
    return compositeOverC1.compositeOver(Color.Black)

    return compositeOverC1.compositeOver(background = Color(0xff000000))
    return compositeOverC1.compositeOver(Color(0xff000000))

    return compositeOverC1.compositeOver(background = compositeOverC4)
    return compositeOverC1.compositeOver(compositeOverC4)

    return compositeOverC1.compositeOver(background = compositeOverC5)
    return compositeOverC1.compositeOver(compositeOverC5)

    return compositeOverC1.compositeOver(background = compositeOverC6)
    return compositeOverC1.compositeOver(compositeOverC6)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    return compositeOverC2.compositeOver(background = Color.Black)
    return compositeOverC2.compositeOver(Color.Black)

    return compositeOverC2.compositeOver(background = Color(0xff000000))
    return compositeOverC2.compositeOver(Color(0xff000000))

    return compositeOverC2.compositeOver(background = compositeOverC4)
    return compositeOverC2.compositeOver(compositeOverC4)

    return compositeOverC2.compositeOver(background = compositeOverC5)
    return compositeOverC2.compositeOver(compositeOverC5)

    return compositeOverC2.compositeOver(background = compositeOverC6)
    return compositeOverC2.compositeOver(compositeOverC6)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    return compositeOverC3.compositeOver(background = Color.Black)
    return compositeOverC3.compositeOver(Color.Black)

    return compositeOverC3.compositeOver(background = Color(0xff000000))
    return compositeOverC3.compositeOver(Color(0xff000000))

    return compositeOverC3.compositeOver(background = compositeOverC4)
    return compositeOverC3.compositeOver(compositeOverC4)

    return compositeOverC3.compositeOver(background = compositeOverC5)
    return compositeOverC3.compositeOver(compositeOverC5)

    return compositeOverC3.compositeOver(background = compositeOverC6)
    return compositeOverC3.compositeOver(compositeOverC6)
    //endregion
}
//endregion

//region KtBinaryExpression
fun compositeOverKtBinaryExpression_KtDotQualifiedExpression_KtDotQualifiedExpression() {
    null ?: Color.White.compositeOver(background = Color.Black)
    null ?: Color.White.compositeOver(Color.Black)
}

fun compositeOverKtBinaryExpression_KtDotQualifiedExpression_KtCallExpression() {
    null ?: Color.White.compositeOver(background = Color(0xff000000))
    null ?: Color.White.compositeOver(Color(0xff000000))
}

fun compositeOverKtBinaryExpression_KtDotQualifiedExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    null ?: Color.White.compositeOver(background = compositeOverC4)
    null ?: Color.White.compositeOver(compositeOverC4)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    null ?: Color.White.compositeOver(background = compositeOverC5)
    null ?: Color.White.compositeOver(compositeOverC5)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    null ?: Color.White.compositeOver(background = compositeOverC6)
    null ?: Color.White.compositeOver(compositeOverC6)
    //endregion
}

fun compositeOverKtBinaryExpression_KtCallExpression_KtDotQualifiedExpression() {
    null ?: Color(0xffffffff).compositeOver(background = Color.Black)
    null ?: Color(0xffffffff).compositeOver(Color.Black)
}

fun compositeOverKtBinaryExpression_KtCallExpression_KtCallExpression() {
    null ?: Color(0xffffffff).compositeOver(background = Color(0xff000000))
    null ?: Color(0xffffffff).compositeOver(Color(0xff000000))
}

fun compositeOverKtBinaryExpression_KtCallExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    null ?: Color(0xffffffff).compositeOver(background = compositeOverC4)
    null ?: Color(0xffffffff).compositeOver(compositeOverC4)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    null ?: Color(0xffffffff).compositeOver(background = compositeOverC5)
    null ?: Color(0xffffffff).compositeOver(compositeOverC5)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    null ?: Color(0xffffffff).compositeOver(background = compositeOverC6)
    null ?: Color(0xffffffff).compositeOver(compositeOverC6)
    //endregion
}

fun compositeOverKtBinaryExpression_KtNameReferenceExpression() {
    //region KtNameReferenceExpression -> KtDotQualifiedExpression
    null ?: compositeOverC1.compositeOver(background = Color.Black)
    null ?: compositeOverC1.compositeOver(Color.Black)

    null ?: compositeOverC1.compositeOver(background = Color(0xff000000))
    null ?: compositeOverC1.compositeOver(Color(0xff000000))

    null ?: compositeOverC1.compositeOver(background = compositeOverC4)
    null ?: compositeOverC1.compositeOver(compositeOverC4)

    null ?: compositeOverC1.compositeOver(background = compositeOverC5)
    null ?: compositeOverC1.compositeOver(compositeOverC5)

    null ?: compositeOverC1.compositeOver(background = compositeOverC6)
    null ?: compositeOverC1.compositeOver(compositeOverC6)
    //endregion

    //region KtNameReferenceExpression -> KtNameReferenceExpression
    null ?: compositeOverC2.compositeOver(background = Color.Black)
    null ?: compositeOverC2.compositeOver(Color.Black)

    null ?: compositeOverC2.compositeOver(background = Color(0xff000000))
    null ?: compositeOverC2.compositeOver(Color(0xff000000))

    null ?: compositeOverC2.compositeOver(background = compositeOverC4)
    null ?: compositeOverC2.compositeOver(compositeOverC4)

    null ?: compositeOverC2.compositeOver(background = compositeOverC5)
    null ?: compositeOverC2.compositeOver(compositeOverC5)

    null ?: compositeOverC2.compositeOver(background = compositeOverC6)
    null ?: compositeOverC2.compositeOver(compositeOverC6)
    //endregion

    //region KtNameReferenceExpression -> KtCallExpression
    null ?: compositeOverC3.compositeOver(background = Color.Black)
    null ?: compositeOverC3.compositeOver(Color.Black)

    null ?: compositeOverC3.compositeOver(background = Color(0xff000000))
    null ?: compositeOverC3.compositeOver(Color(0xff000000))

    null ?: compositeOverC3.compositeOver(background = compositeOverC4)
    null ?: compositeOverC3.compositeOver(compositeOverC4)

    null ?: compositeOverC3.compositeOver(background = compositeOverC5)
    null ?: compositeOverC3.compositeOver(compositeOverC5)

    null ?: compositeOverC3.compositeOver(background = compositeOverC6)
    null ?: compositeOverC3.compositeOver(compositeOverC6)
    //endregion
}
//endregion
