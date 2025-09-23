package app.lawnchair.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import app.lawnchair.compatlib.R

@Composable
fun AppTracerOnboarding(
    onSkipToGame: () -> Unit,
    onContinue: () -> Unit,
    onSettings: () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(Brush.verticalGradient(listOf(Color(0xFF5228C2), Color(0xFF422884))))
            .fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
        ) {
            // Pagination dots (static)
            Row(Modifier.padding(top = 8.dp, bottom = 24.dp)) {
                repeat(5) { i ->
                    Box(
                        Modifier
                            .size(if (i == 1) 10.dp else 8.dp)
                            .background(
                                if (i == 1) Color.White else Color(0xFFE2DFFF),
                                shape = CircleShape,
                            ),
                    )
                    if (i < 4) Spacer(Modifier.width(8.dp))
                }
            }
            // App Tracer header chip
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(40.dp))
                    .background(Color(0xFF299CFF))
                    .padding(horizontal = 36.dp, vertical = 12.dp),
            ) {
                Text(
                    "App Tracer",
                    color = Color.White,
                    style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold),
                )
            }
            Spacer(Modifier.height(20.dp))
            Text(
                "Stay informed with detailed app activity and usage stats",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 8.dp),
            )
            Spacer(Modifier.height(20.dp))
            // App screenshot placeholder (replace with real Image in prod)
            Box(
                Modifier
                    .fillMaxWidth(0.75f)
                    .aspectRatio(0.6f)
                    .clip(RoundedCornerShape(28.dp))
                    .background(Color.White)
                    .shadow(8.dp, RoundedCornerShape(28.dp)),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(id = com.android.launcher3.R.drawable.img_1), // replace your_screenshot_image with your actual drawable resource
                    contentDescription = "App Preview",
                    modifier = Modifier.fillMaxWidth().height(400.dp),
                    contentScale = ContentScale.Crop,
                )
            }
            Spacer(Modifier.height(24.dp))
            Text(
                "Settings",
                style = MaterialTheme.typography.body1.copy(
                    color = Color(0xFF5CBEFA),
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.SemiBold,
                ),
                modifier = Modifier.clickable { onSettings() },
            )
            Spacer(Modifier.weight(1f))
            // Skip to the Game button
            Button(
                onClick = onSkipToGame,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF19A316)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(32.dp),
            ) {
                Icon(
                    painter = painterResource(id = com.android.launcher3.R.drawable.home_icon), // your icon resource
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(22.dp),
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    "SKIP TO THE GAME",
                    color = Color.White,
                    style = MaterialTheme.typography.subtitle1,
                )
            }
            Spacer(Modifier.height(12.dp))
            // Continue button
            Button(
                onClick = onContinue,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(32.dp),
                colors = ButtonDefaults.buttonColors(contentColor = Color.White),
            ) {
                Text("CONTINUE", color = Color.Black, style = MaterialTheme.typography.subtitle1)
            }
        }
    }
}
