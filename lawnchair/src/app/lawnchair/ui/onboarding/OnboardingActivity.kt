// OnboardingActivity.kt
package app.lawnchair.ui.onboarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

class OnboardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                var showDefaultScreen by remember { mutableStateOf(false) }
                var showIntro by remember { mutableStateOf(false) }
                var showDialog by remember { mutableStateOf(false) }
                val context = LocalContext.current
                OnboardingScreen(
                    onStartClicked = {
                        showIntro = true
                    },
                )



                if (showDialog) {
                    DefaultHomeAppDialog(
                        selectedLauncher = "New Launcher Plus",
                        onSelectLauncher = { launcherName ->
                            promptSetDefaultLauncher(context)
                            showDialog = false
                        },
                        onDismissRequest = { showDialog = false },
                    )
                }

                if (showIntro) {
                    AppTracerOnboarding(
                        onSkipToGame = {
                            showDefaultScreen = true
                        },
                        onContinue = {
                            // Handle Continue button click
                        },
                        onSettings = {
                            // Handle Settings click
                        },
                    )
                }

                if (showDefaultScreen) {
                    DefaultLauncherScreen(
                        onSetDefaultClicked = {
                            showDialog = true
                        },
                    )
                }
            }
        }
    }

    fun promptSetDefaultLauncher(context: Context) {
        try {
            val intent = Intent(Settings.ACTION_HOME_SETTINGS)
            context.startActivity(intent)
        } catch (e: Exception) {
            val intent = Intent(Intent.ACTION_MAIN).apply {
                addCategory(Intent.CATEGORY_HOME)
            }
            context.startActivity(intent)
        }
    }
}
