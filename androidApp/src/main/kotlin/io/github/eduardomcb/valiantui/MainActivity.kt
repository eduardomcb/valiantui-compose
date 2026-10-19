package io.github.eduardomcb.valiantui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.eduardomcb.valiantui.catalog.CatalogApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            CatalogApp()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    CatalogApp()
}