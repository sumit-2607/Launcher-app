package app.lawnchair.ui.onboarding

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import app.lawnchair.compatlib.R

@Composable
fun DefaultHomeAppDialog(
    selectedLauncher: String,
    onSelectLauncher: (String) -> Unit,
    onDismissRequest: () -> Unit
) {
//    val context = LocalContext.current

    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            modifier = Modifier
                .padding(24.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color.White)
        ) {
            Column(
                Modifier.padding(vertical = 24.dp, horizontal = 20.dp)
            ) {
                Text(
                    text = "Default Home App",
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 20.dp)
                )

                // System Launcher Option
                LauncherOptionRow(
                    icon = painterResource(id = com.android.launcher3.R.drawable.launcher_icon),
                    text = "System Launcher",
                    selected = selectedLauncher == "System Launcher",
                    onClick = { onSelectLauncher("System Launcher") }
                )

                Spacer(Modifier.height(12.dp))

                // New Launcher Plus Option
                LauncherOptionRow(
                    icon = painterResource(id = com.android.launcher3.R.drawable.home_icon),
                    text = "New Launcher Plus",
                    selected = selectedLauncher == "New Launcher Plus",
                    onClick = { onSelectLauncher("New Launcher Plus") },
                    isActive = true // This row is shown as selected/glowing in your image
                )
            }
        }
    }
}

@Composable
fun LauncherOptionRow(
    icon: Painter,
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    isActive: Boolean = false
) {
    val bgColor = if (isActive) Color(0xFF167942) else Color(0xFFF7F8FA)
    val boxShadow = if (isActive) {
        Modifier.shadow(8.dp, RoundedCornerShape(14.dp), ambientColor = Color(0x88167942))
    } else Modifier

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(boxShadow)
            .clip(RoundedCornerShape(14.dp))
            .background(bgColor)
            .clickable { onClick() }
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.body1.copy(
                color = if (isActive) Color.White else Color.Black,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}
