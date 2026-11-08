package io.github.eduardomcb.valiantui.components.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.theme.ValiantColorRole
import io.github.eduardomcb.valiantui.theme.ValiantRadius

enum class ButtonGroupPosition {
    Single,
    First,
    Middle,
    Last
}

class ButtonGroupScope internal constructor(
    val groupVariant: ButtonVariant,
    val groupColor: ValiantColorRole?,
    val groupSize: ButtonSize,
    val groupRadius: ValiantRadius,
    val groupDisabled: Boolean
) {
    @Composable
    fun Button(
        onClick: () -> Unit,
        position: ButtonGroupPosition,
        modifier: Modifier = Modifier,
        variant: ButtonVariant = groupVariant,
        color: ValiantColorRole? = groupColor,
        size: ButtonSize = groupSize,
        radius: ValiantRadius = groupRadius,
        isLoading: Boolean = false,
        isPending: Boolean = isLoading,
        showDefaultSpinner: Boolean = true,
        isDisabled: Boolean = groupDisabled,
        isIconOnly: Boolean = false,
        fullWidth: Boolean = false,
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
        startContent: (@Composable () -> Unit)? = null,
        endContent: (@Composable () -> Unit)? = null,
        content: @Composable RowScope.() -> Unit
    ) {
        val shape = when (position) {
            ButtonGroupPosition.Single -> radius.toShape()
            ButtonGroupPosition.First -> radius.toShape(topEnd = false, bottomEnd = false)
            ButtonGroupPosition.Middle -> radius.toShape(
                topStart = false,
                topEnd = false,
                bottomEnd = false,
                bottomStart = false
            )
            ButtonGroupPosition.Last -> radius.toShape(topStart = false, bottomStart = false)
        }

        Button(
            onClick = onClick,
            modifier = modifier,
            variant = variant,
            color = color,
            size = size,
            radius = radius,
            isLoading = isLoading,
            isPending = isPending,
            showDefaultSpinner = showDefaultSpinner,
            isDisabled = isDisabled,
            isIconOnly = isIconOnly,
            fullWidth = fullWidth,
            customShape = shape,
            interactionSource = interactionSource,
            startContent = startContent,
            endContent = endContent,
            content = content
        )
    }
}

@Composable
fun ButtonGroup(
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.Primary,
    color: ValiantColorRole? = null,
    size: ButtonSize = ButtonSize.Md,
    radius: ValiantRadius = ValiantRadius.Full,
    isDisabled: Boolean = false,
    content: @Composable ButtonGroupScope.() -> Unit
) {
    val scope = remember(variant, color, size, radius, isDisabled) {
        ButtonGroupScope(
            groupVariant = variant,
            groupColor = color,
            groupSize = size,
            groupRadius = radius,
            groupDisabled = isDisabled
        )
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy((-1).dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        scope.content()
    }
}
