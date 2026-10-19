package io.github.eduardomcb.valiantui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape

@Immutable
data class ValiantShapes(
    val none: Shape = ValiantRadius.None.toShape(),
    val small: Shape = ValiantRadius.Sm.toShape(),
    val medium: Shape = ValiantRadius.Md.toShape(),
    val large: Shape = ValiantRadius.Lg.toShape(),
    val full: Shape = ValiantRadius.Full.toShape()
)
