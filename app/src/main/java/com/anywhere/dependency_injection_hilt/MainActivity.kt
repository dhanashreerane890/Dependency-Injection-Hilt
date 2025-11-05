package com.anywhere.dependency_injection_hilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.anywhere.dependency_injection_hilt.presentation.ui.ProductScreen
import com.anywhere.dependency_injection_hilt.presentation.ui.theme.DependencyInjectionHiltTheme
import dagger.hilt.android.AndroidEntryPoint

//tells Hilt to generates code automatically,injects dependencies before onCreate()
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DependencyInjectionHiltTheme {
                ProductScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DependencyInjectionHiltTheme {
        ProductScreen()
    }
}