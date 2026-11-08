package io.github.eduardomcb.valiantui.catalog.icons

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import valiantui_compose.catalog.generated.resources.Res
import valiantui_compose.catalog.generated.resources.ic_apple
import valiantui_compose.catalog.generated.resources.ic_ellipsis
import valiantui_compose.catalog.generated.resources.ic_envelope
import valiantui_compose.catalog.generated.resources.ic_gear
import valiantui_compose.catalog.generated.resources.ic_github
import valiantui_compose.catalog.generated.resources.ic_globe
import valiantui_compose.catalog.generated.resources.ic_google
import valiantui_compose.catalog.generated.resources.ic_paperclip
import valiantui_compose.catalog.generated.resources.ic_plus
import valiantui_compose.catalog.generated.resources.ic_trash_bin

@Composable
fun GlobeIcon(
    modifier: Modifier = Modifier.size(16.dp),
    tint: Color = LocalContentColor.current
) {
    Icon(
        painter = painterResource(Res.drawable.ic_globe),
        contentDescription = "Globe",
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun PlusIcon(
    modifier: Modifier = Modifier.size(16.dp),
    tint: Color = LocalContentColor.current
) {
    Icon(
        painter = painterResource(Res.drawable.ic_plus),
        contentDescription = "Plus",
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun EnvelopeIcon(
    modifier: Modifier = Modifier.size(16.dp),
    tint: Color = LocalContentColor.current
) {
    Icon(
        painter = painterResource(Res.drawable.ic_envelope),
        contentDescription = "Envelope",
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun TrashBinIcon(
    modifier: Modifier = Modifier.size(16.dp),
    tint: Color = LocalContentColor.current
) {
    Icon(
        painter = painterResource(Res.drawable.ic_trash_bin),
        contentDescription = "Trash",
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun EllipsisIcon(
    modifier: Modifier = Modifier.size(16.dp),
    tint: Color = LocalContentColor.current
) {
    Icon(
        painter = painterResource(Res.drawable.ic_ellipsis),
        contentDescription = "More",
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun GearIcon(
    modifier: Modifier = Modifier.size(16.dp),
    tint: Color = LocalContentColor.current
) {
    Icon(
        painter = painterResource(Res.drawable.ic_gear),
        contentDescription = "Settings",
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun PaperclipIcon(
    modifier: Modifier = Modifier.size(16.dp),
    tint: Color = LocalContentColor.current
) {
    Icon(
        painter = painterResource(Res.drawable.ic_paperclip),
        contentDescription = "Attachment",
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun GoogleIcon(
    modifier: Modifier = Modifier.size(16.dp)
) {
    Icon(
        painter = painterResource(Res.drawable.ic_google),
        contentDescription = "Google",
        modifier = modifier,
        tint = Color.Unspecified
    )
}

@Composable
fun GithubIcon(
    modifier: Modifier = Modifier.size(16.dp),
    tint: Color = LocalContentColor.current
) {
    Icon(
        painter = painterResource(Res.drawable.ic_github),
        contentDescription = "GitHub",
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun AppleIcon(
    modifier: Modifier = Modifier.size(16.dp),
    tint: Color = LocalContentColor.current
) {
    Icon(
        painter = painterResource(Res.drawable.ic_apple),
        contentDescription = "Apple",
        modifier = modifier,
        tint = tint
    )
}
