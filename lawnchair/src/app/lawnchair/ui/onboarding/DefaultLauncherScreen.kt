// DefaultLauncherScreen.kt
package app.lawnchair.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.lawnchair.compatlib.R

@Composable
fun DefaultLauncherScreen(
    modifier: Modifier = Modifier,
    onSetDefaultClicked: () -> Unit = {}
) {
    // purple gradient background similar to the design
    val bg = Brush.verticalGradient(
        listOf(Color(0xFF6F2CFF), Color(0xFF32138C))
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush = bg)
            .padding(horizontal = 20.dp)
    ) {
        // Top large phone image area (rotated)


        // Content below the phone
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth() // space for phone
                    .height(500.dp)
            ) {
                Image(
                    painter = painterResource(id = com.android.launcher3.R.drawable.phonemock2), // add your image to drawable
                    contentDescription = "phone preview",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .fillMaxWidth(1.0f)
                        .rotate(-12f)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Set as your default Launcher",
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "and enjoy your new home screen",
                fontSize = 16.sp,
                color = Color(0xFFDCD7F7)
            )

            Spacer(modifier = Modifier.height(36.dp))

            // Big green CTA "SET DEFAULT"
            Button(
                onClick = onSetDefaultClicked,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1FA61F)),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .height(72.dp)
                    .fillMaxWidth(0.78f),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp)
            ) {
                Text(
                    text = "SET DEFAULT",
                    fontSize = 26.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "you can revert your choice anytime via your\nphone settings",
                fontSize = 12.sp,
                color = Color(0xFFD9D9F2),
                modifier = Modifier.padding(horizontal = 12.dp),
                lineHeight = 16.sp
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun DefaultLauncherPreview() {
    MaterialTheme {
        DefaultLauncherScreen {}
    }
}
