package io.github.eduardomcb.valiantui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class ValiantRadius(val dp: Dp) {
    None(0.dp),
    Sm(8.dp),
    Md(12.dp),
    Lg(14.dp),
    Full(9999.dp);

    fun toShape(): RoundedCornerShape = when (this) {
        None -> RoundedCornerShape(0.dp)
        Sm -> RoundedCornerShape(8.dp)
        Md -> RoundedCornerShape(12.dp)
        Lg -> RoundedCornerShape(14.dp)
        Full -> RoundedCornerShape(percent = 50)
    }

    fun toShape(
        topStart: Boolean = true,
        topEnd: Boolean = true,
        bottomEnd: Boolean = true,
        bottomStart: Boolean = true
    ): RoundedCornerShape {
        val radius = if (this == Full) 9999.dp else this.dp
        val zero = 0.dp
        return RoundedCornerShape(
            topStart = if (topStart) radius else zero,
            topEnd = if (topEnd) radius else zero,
            bottomEnd = if (bottomEnd) radius else zero,
            bottomStart = if (bottomStart) radius else zero
        )
    }
}
