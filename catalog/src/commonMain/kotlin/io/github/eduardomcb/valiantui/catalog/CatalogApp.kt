package io.github.eduardomcb.valiantui.catalog

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.eduardomcb.valiantui.components.button.Button
import io.github.eduardomcb.valiantui.components.button.ButtonGroup
import io.github.eduardomcb.valiantui.components.button.ButtonGroupPosition
import io.github.eduardomcb.valiantui.components.button.ButtonSize
import io.github.eduardomcb.valiantui.components.button.ButtonVariant
import io.github.eduardomcb.valiantui.components.separator.Separator
import io.github.eduardomcb.valiantui.components.separator.SeparatorOrientation
import io.github.eduardomcb.valiantui.components.separator.SeparatorVariant
import io.github.eduardomcb.valiantui.theme.ValiantColorRole
import io.github.eduardomcb.valiantui.theme.ValiantRadius
import io.github.eduardomcb.valiantui.theme.ValiantTheme
import io.github.eduardomcb.valiantui.theme.darkValiantColors
import io.github.eduardomcb.valiantui.theme.lightValiantColors

@Composable
fun App() {
    CatalogApp()
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CatalogApp() {
    var isDark by remember { mutableStateOf(false) }
    var selectedInteractiveVariant by remember { mutableStateOf(ButtonVariant.Solid) }
    var isLoadingDemo by remember { mutableStateOf(false) }

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
                    .padding(bottom = 24.dp),
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
                        text = "Modern design system for Kotlin Multiplatform",
                        style = ValiantTheme.typography.small,
                        color = animatedFg.copy(alpha = 0.65f)
                    )
                }

                Button(
                    onClick = { isDark = !isDark },
                    variant = ButtonVariant.Flat,
                    color = ValiantColorRole.Default,
                    size = ButtonSize.Sm,
                    radius = ValiantRadius.Full
                ) {
                    Text(if (isDark) "Light Mode" else "Dark Mode")
                }
            }

            CatalogSection(title = "Button Variants") {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ButtonVariant.entries.forEach { variant ->
                        Button(
                            onClick = {},
                            variant = variant,
                            color = ValiantColorRole.Primary
                        ) {
                            Text(variant.name)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            CatalogSection(title = "Button Colors") {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        ButtonVariant.entries.forEach { variant ->
                            Button(
                                onClick = { selectedInteractiveVariant = variant },
                                variant = if (selectedInteractiveVariant == variant) ButtonVariant.Solid else ButtonVariant.Light,
                                color = if (selectedInteractiveVariant == variant) ValiantColorRole.Primary else ValiantColorRole.Default,
                                size = ButtonSize.Sm
                            ) {
                                Text(variant.name)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        ValiantColorRole.entries.forEach { role ->
                            Button(
                                onClick = {},
                                variant = selectedInteractiveVariant,
                                color = role
                            ) {
                                Text(role.name)
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            CatalogSection(title = "Sizes & Radius") {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text(
                        text = "Sizes (Sm: 32dp, Md: 40dp, Lg: 48dp)",
                        style = ValiantTheme.typography.small.copy(fontWeight = FontWeight.SemiBold),
                        color = animatedFg
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ButtonSize.entries.forEach { size ->
                            Button(
                                onClick = {},
                                size = size,
                                color = ValiantColorRole.Primary
                            ) {
                                Text(size.name)
                            }
                        }
                    }

                    Text(
                        text = "Radius tokens (None, Sm, Md, Lg, Full)",
                        style = ValiantTheme.typography.small.copy(fontWeight = FontWeight.SemiBold),
                        color = animatedFg
                    )
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        ValiantRadius.entries.forEach { radius ->
                            Button(
                                onClick = {},
                                radius = radius,
                                variant = ButtonVariant.Flat,
                                color = ValiantColorRole.Secondary
                            ) {
                                Text(radius.name)
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            CatalogSection(title = "States & Micro-interactions (Press Scaling, Loading, Disabled)") {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(
                        text = "Try clicking any button to feel the signature 0.97 spring press scale",
                        style = ValiantTheme.typography.tiny,
                        color = animatedFg.copy(alpha = 0.6f)
                    )

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Button(
                            onClick = { isLoadingDemo = !isLoadingDemo },
                            variant = ButtonVariant.Flat,
                            color = ValiantColorRole.Success
                        ) {
                            Text(if (isLoadingDemo) "Stop Loading" else "Toggle Loading")
                        }

                        Button(
                            onClick = {},
                            isLoading = isLoadingDemo,
                            color = ValiantColorRole.Primary
                        ) {
                            Text("Loading State")
                        }

                        Button(
                            onClick = {},
                            isDisabled = true,
                            color = ValiantColorRole.Danger
                        ) {
                            Text("Disabled")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            CatalogSection(title = "Slots & Icons") {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = {},
                        color = ValiantColorRole.Success,
                        startContent = {
                            Text("✓", fontWeight = FontWeight.Bold)
                        }
                    ) {
                        Text("Success Action")
                    }

                    Button(
                        onClick = {},
                        variant = ButtonVariant.Bordered,
                        color = ValiantColorRole.Warning,
                        endContent = {
                            Text("→", fontWeight = FontWeight.Bold)
                        }
                    ) {
                        Text("Next Step")
                    }

                    Button(
                        onClick = {},
                        isIconOnly = true,
                        radius = ValiantRadius.Full,
                        color = ValiantColorRole.Secondary
                    ) {
                        Text("+", fontSize = 16.sp)
                    }

                    Button(
                        onClick = {},
                        isIconOnly = true,
                        variant = ButtonVariant.Flat,
                        color = ValiantColorRole.Default
                    ) {
                        Text("#", fontSize = 16.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            CatalogSection(title = "Button Group") {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text(
                        text = "Connected buttons with shared styles and collapsed borders:",
                        style = ValiantTheme.typography.tiny,
                        color = animatedFg.copy(alpha = 0.6f)
                    )

                    ButtonGroup(
                        variant = ButtonVariant.Solid,
                        color = ValiantColorRole.Primary,
                        radius = ValiantRadius.Md
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
                        variant = ButtonVariant.Flat,
                        color = ValiantColorRole.Secondary,
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

            Spacer(modifier = Modifier.height(24.dp))

            CatalogSection("Separator") {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
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

                    Text(
                        text = "With Centered Label (e.g. Auth divider):",
                        style = ValiantTheme.typography.tiny,
                        color = animatedFg.copy(alpha = 0.6f)
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(colors.content2)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Button(
                            onClick = {},
                            variant = ButtonVariant.Flat,
                            color = ValiantColorRole.Primary,
                            fullWidth = true
                        ) {
                            Text("Continue with Google")
                        }

                        Separator(text = "OR", variant = SeparatorVariant.Secondary)

                        Button(
                            onClick = {},
                            variant = ButtonVariant.Bordered,
                            color = ValiantColorRole.Default,
                            fullWidth = true
                        ) {
                            Text("Continue with Email")
                        }
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
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(colors.content1)
            .border(1.dp, colors.divider, RoundedCornerShape(16.dp))
            .padding(20.dp)
    ) {
        Text(
            text = title,
            style = ValiantTheme.typography.h3,
            color = colors.foreground,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        content()
    }
}
