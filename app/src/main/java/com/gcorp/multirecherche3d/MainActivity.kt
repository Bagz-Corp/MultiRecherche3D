package com.gcorp.multirecherche3d

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.gcorp.multirecherche3d.ui.MainApp
import com.gcorp.multirecherche3d.ui.theme.GregTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            GregTheme {
                MainApp()
            }
        }
    }
}