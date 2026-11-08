package io.github.eduardomcb.valiantui.catalog

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.catalog.icons.AppleIcon
import io.github.eduardomcb.valiantui.catalog.icons.EllipsisIcon
import io.github.eduardomcb.valiantui.catalog.icons.EnvelopeIcon
import io.github.eduardomcb.valiantui.catalog.icons.GearIcon
import io.github.eduardomcb.valiantui.catalog.icons.GithubIcon
import io.github.eduardomcb.valiantui.catalog.icons.GlobeIcon
import io.github.eduardomcb.valiantui.catalog.icons.GoogleIcon
import io.github.eduardomcb.valiantui.catalog.icons.PaperclipIcon
import io.github.eduardomcb.valiantui.catalog.icons.PlusIcon
import io.github.eduardomcb.valiantui.catalog.icons.TrashBinIcon
import io.github.eduardomcb.valiantui.components.button.Button
import io.github.eduardomcb.valiantui.components.button.ButtonGroup
import io.github.eduardomcb.valiantui.components.button.ButtonGroupPosition
import io.github.eduardomcb.valiantui.components.button.ButtonSize
import io.github.eduardomcb.valiantui.components.button.ButtonVariant
import io.github.eduardomcb.valiantui.components.feedback.Spinner
import io.github.eduardomcb.valiantui.components.feedback.SpinnerColor
import io.github.eduardomcb.valiantui.components.feedback.SpinnerSize
import io.github.eduardomcb.valiantui.components.separator.Separator
import io.github.eduardomcb.valiantui.components.separator.SeparatorOrientation
import io.github.eduardomcb.valiantui.components.separator.SeparatorVariant
import io.github.eduardomcb.valiantui.theme.ValiantRadius
import io.github.eduardomcb.valiantui.theme.ValiantTheme
import io.github.eduardomcb.valiantui.theme.darkValiantColors
import io.github.eduardomcb.valiantui.theme.lightValiantColors
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun App() {
    CatalogApp()
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CatalogApp() {
    var isDark by remember { mutableStateOf(true) }

    val colors = if (isDark) darkValiantColors() else lightValiantColors()

    ValiantTheme(
        darkTheme = isDark,
        colors = colors
    ) {
        val scrollState = rememberScrollState()

        val animatedBg by animateColorAsState(colors.background, label = "catalogBg")
        val animatedFg by animateColorAsState(colors.foreground, label = "catalogFg")

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(animatedBg)
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 28.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "ValiantUI Compose",
                        style = ValiantTheme.typography.h1.copy(fontWeight = FontWeight.ExtraBold),
                        color = animatedFg
                    )
                    Text(
                        text = "Modern design system for Kotlin Multiplatform matching HeroUI",
                        style = ValiantTheme.typography.small,
                        color = animatedFg.copy(alpha = 0.65f)
                    )
                }

                Button(
                    onClick = { isDark = !isDark },
                    variant = ButtonVariant.Secondary,
                    size = ButtonSize.Sm
                ) {
                    Text(if (isDark) "Light Mode" else "Dark Mode")
                }
            }

            // 1. Button básico
            CatalogSection(title = "Button básico") {
                Button(
                    onClick = { println("Button pressed") }
                ) {
                    Text("Click me")
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // 2. Variants
            CatalogSection(title = "Variants") {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(onClick = {}) {
                        Text("Primary")
                    }
                    Button(onClick = {}, variant = ButtonVariant.Secondary) {
                        Text("Secondary")
                    }
                    Button(onClick = {}, variant = ButtonVariant.Tertiary) {
                        Text("Tertiary")
                    }
                    Button(onClick = {}, variant = ButtonVariant.Outline) {
                        Text("Outline")
                    }
                    Button(onClick = {}, variant = ButtonVariant.Ghost) {
                        Text("Ghost")
                    }
                    Button(onClick = {}, variant = ButtonVariant.Danger) {
                        Text("Danger")
                    }
                    Button(onClick = {}, variant = ButtonVariant.DangerSoft) {
                        Text("Danger Soft")
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // 3. Sizes
            CatalogSection(title = "Sizes") {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = {}, size = ButtonSize.Sm) {
                        Text("Small")
                    }
                    Button(onClick = {}, size = ButtonSize.Md) {
                        Text("Medium")
                    }
                    Button(onClick = {}, size = ButtonSize.Lg) {
                        Text("Large")
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // 4. With Icons
            CatalogSection(title = "With Icons") {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(onClick = {}) {
                        GlobeIcon()
                        Text("Search")
                    }
                    Button(onClick = {}, variant = ButtonVariant.Secondary) {
                        PlusIcon()
                        Text("Add Member")
                    }
                    Button(onClick = {}, variant = ButtonVariant.Tertiary) {
                        EnvelopeIcon()
                        Text("Email")
                    }
                    Button(onClick = {}, variant = ButtonVariant.Danger) {
                        TrashBinIcon()
                        Text("Delete")
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // 5. Icon Only
            CatalogSection(title = "Icon Only") {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {},
                        isIconOnly = true,
                        variant = ButtonVariant.Tertiary
                    ) {
                        EllipsisIcon()
                    }
                    Button(
                        onClick = {},
                        isIconOnly = true,
                        variant = ButtonVariant.Secondary
                    ) {
                        GearIcon()
                    }
                    Button(
                        onClick = {},
                        isIconOnly = true,
                        variant = ButtonVariant.Danger
                    ) {
                        TrashBinIcon()
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // 6. Loading
            CatalogSection(title = "Loading") {
                Button(
                    onClick = {},
                    isPending = true,
                    showDefaultSpinner = false
                ) {
                    Spinner(color = SpinnerColor.Current, size = SpinnerSize.Sm)
                    Text("Uploading...")
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // 7. Loading State
            CatalogSection(title = "Loading State") {
                var isLoading by remember { mutableStateOf(false) }
                val coroutineScope = rememberCoroutineScope()

                Button(
                    onClick = {
                        if (!isLoading) {
                            isLoading = true
                            coroutineScope.launch {
                                delay(2000)
                                isLoading = false
                            }
                        }
                    },
                    isPending = isLoading,
                    showDefaultSpinner = false
                ) {
                    if (isLoading) {
                        Spinner(color = SpinnerColor.Current, size = SpinnerSize.Sm)
                        Text("Uploading...")
                    } else {
                        PaperclipIcon()
                        Text("Upload File")
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // 8. Full Width
            CatalogSection(title = "Full Width") {
                Column(
                    modifier = Modifier.width(400.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = {},
                        fullWidth = true
                    ) {
                        Text("Primary Button")
                    }
                    Button(
                        onClick = {},
                        fullWidth = true
                    ) {
                        PlusIcon()
                        Text("With Icon")
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // 9. Disabled State
            CatalogSection(title = "Disabled State") {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(onClick = {}, isDisabled = true) {
                        Text("Primary")
                    }
                    Button(onClick = {}, isDisabled = true, variant = ButtonVariant.Secondary) {
                        Text("Secondary")
                    }
                    Button(onClick = {}, isDisabled = true, variant = ButtonVariant.Tertiary) {
                        Text("Tertiary")
                    }
                    Button(onClick = {}, isDisabled = true, variant = ButtonVariant.Outline) {
                        Text("Outline")
                    }
                    Button(onClick = {}, isDisabled = true, variant = ButtonVariant.Ghost) {
                        Text("Ghost")
                    }
                    Button(onClick = {}, isDisabled = true, variant = ButtonVariant.Danger) {
                        Text("Danger")
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // 10. Social Buttons
            CatalogSection(title = "Social Buttons") {
                Column(
                    modifier = Modifier.width(320.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = {},
                        fullWidth = true,
                        variant = ButtonVariant.Tertiary
                    ) {
                        GoogleIcon()
                        Text("Sign in with Google")
                    }
                    Button(
                        onClick = {},
                        fullWidth = true,
                        variant = ButtonVariant.Tertiary
                    ) {
                        GithubIcon()
                        Text("Sign in with GitHub")
                    }
                    Button(
                        onClick = {},
                        fullWidth = true,
                        variant = ButtonVariant.Tertiary
                    ) {
                        AppleIcon()
                        Text("Sign in with Apple")
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // 11. Spinner
            CatalogSection(title = "Spinner") {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(
                        text = "Colors (Current, Accent, Success, Warning, Danger):",
                        style = ValiantTheme.typography.tiny,
                        color = animatedFg.copy(alpha = 0.6f)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Spinner(color = SpinnerColor.Accent)
                            Text("Accent", style = ValiantTheme.typography.tiny, color = colors.muted)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Spinner(color = SpinnerColor.Success)
                            Text("Success", style = ValiantTheme.typography.tiny, color = colors.muted)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Spinner(color = SpinnerColor.Warning)
                            Text("Warning", style = ValiantTheme.typography.tiny, color = colors.muted)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Spinner(color = SpinnerColor.Danger)
                            Text("Danger", style = ValiantTheme.typography.tiny, color = colors.muted)
                        }
                    }

                    Text(
                        text = "Sizes (Sm: 16dp, Md: 24dp, Lg: 32dp, Xl: 40dp):",
                        style = ValiantTheme.typography.tiny,
                        color = animatedFg.copy(alpha = 0.6f)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Spinner(size = SpinnerSize.Sm)
                            Text("Small", style = ValiantTheme.typography.tiny, color = colors.muted)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Spinner(size = SpinnerSize.Md)
                            Text("Medium", style = ValiantTheme.typography.tiny, color = colors.muted)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Spinner(size = SpinnerSize.Lg)
                            Text("Large", style = ValiantTheme.typography.tiny, color = colors.muted)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Spinner(size = SpinnerSize.Xl)
                            Text("Extra Large", style = ValiantTheme.typography.tiny, color = colors.muted)
                        }
                    }

                    Text(
                        text = "Speed (Slow: 1.5s, Default: 0.8s, Fast: 0.4s):",
                        style = ValiantTheme.typography.tiny,
                        color = animatedFg.copy(alpha = 0.6f)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Spinner(durationMillis = 1500)
                            Text("Slow", style = ValiantTheme.typography.tiny, color = colors.muted)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Spinner(durationMillis = 800)
                            Text("Default", style = ValiantTheme.typography.tiny, color = colors.muted)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Spinner(durationMillis = 400)
                            Text("Fast", style = ValiantTheme.typography.tiny, color = colors.muted)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // 12. Button Group
            CatalogSection(title = "Button Group") {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ButtonGroup(
                        variant = ButtonVariant.Primary,
                        radius = ValiantRadius.Full
                    ) {
                        Button(onClick = {}, position = ButtonGroupPosition.First) {
                            Text("Years")
                        }
                        Button(onClick = {}, position = ButtonGroupPosition.Middle) {
                            Text("Months")
                        }
                        Button(onClick = {}, position = ButtonGroupPosition.Last) {
                            Text("Days")
                        }
                    }

                    ButtonGroup(
                        variant = ButtonVariant.Secondary,
                        radius = ValiantRadius.Full
                    ) {
                        Button(onClick = {}, position = ButtonGroupPosition.First) {
                            Text("Left")
                        }
                        Button(onClick = {}, position = ButtonGroupPosition.Middle) {
                            Text("Center")
                        }
                        Button(onClick = {}, position = ButtonGroupPosition.Last) {
                            Text("Right")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // 13. Separator
            CatalogSection(title = "Separator") {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Horizontal Variants (Default, Secondary, Tertiary):",
                        style = ValiantTheme.typography.tiny,
                        color = animatedFg.copy(alpha = 0.6f)
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(colors.content2)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text("Default Variant (subtle contrast)", style = ValiantTheme.typography.small)
                        Separator(variant = SeparatorVariant.Default)

                        Text("Secondary Variant (medium contrast)", style = ValiantTheme.typography.small)
                        Separator(variant = SeparatorVariant.Secondary)

                        Text("Tertiary Variant (strongest contrast)", style = ValiantTheme.typography.small)
                        Separator(variant = SeparatorVariant.Tertiary)
                    }

                    Text(
                        text = "Vertical Orientation (Toolbar / Links):",
                        style = ValiantTheme.typography.tiny,
                        color = animatedFg.copy(alpha = 0.6f)
                    )

                    Row(
                        modifier = Modifier
                            .height(24.dp)
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Blog", style = ValiantTheme.typography.small)
                        Separator(orientation = SeparatorOrientation.Vertical)
                        Text("Docs", style = ValiantTheme.typography.small)
                        Separator(orientation = SeparatorOrientation.Vertical)
                        Text("Source", style = ValiantTheme.typography.small)
                        Separator(orientation = SeparatorOrientation.Vertical)
                        Text("GitHub", style = ValiantTheme.typography.small)
                    }
                }
            }
        }
    }
}

@Composable
private fun CatalogSection(
    title: String,
    content: @Composable () -> Unit
) {
    val colors = ValiantTheme.colors

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = title,
            style = ValiantTheme.typography.h3.copy(fontWeight = FontWeight.SemiBold),
            color = colors.foreground
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(if (colors.isDark) Color(0xFF060607) else colors.surface)
                .border(1.dp, colors.border, RoundedCornerShape(16.dp))
                .padding(horizontal = 24.dp, vertical = 36.dp),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}
