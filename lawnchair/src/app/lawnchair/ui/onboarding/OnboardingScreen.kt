// MainOnboardingScreen.kt
package app.lawnchair.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.*
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
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onStartClicked: () -> Unit = {}
) {
    // Purple gradient background similar to the design
    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF7C4DFF), Color(0xFF3A0DA6))
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush = backgroundGradient)
            .padding(horizontal = 20.dp)
    ) {
        // Top phone image floating & rotated
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(420.dp) // keep area for phone image
        ) {
            // adjust offsets to match the reference image
            Image(
                painter = painterResource(id = com.android.launcher3.R.drawable.phonemock1), // add your image to drawable
                contentDescription = "phone mock",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth(0.78f)
                    .rotate(-12f) // tilt to match design
            )
        }

        // Main content below the phone
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(top = 220.dp), // move content down so phone overlaps nicely
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "STYLE IT YOUR WAY!",
                fontSize = 34.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Make your phone unique with this launcher",
                fontSize = 16.sp,
                color = Color(0xFFDEDDF0),
                modifier = Modifier.padding(horizontal = 16.dp),
            )

            Spacer(modifier = Modifier.height(28.dp))

            // Four circular feature icons with labels
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FeatureItem(icon = Icons.Default.Apps, title = "Customize your\nhome screen")
                FeatureItem(icon = Icons.Default.Tune, title = "Change icon\nshapes")
                FeatureItem(icon = Icons.Default.Lightbulb, title = "Enjoy exclusive\ngame tips")
                FeatureItem(icon = Icons.Default.PieChart, title = "Daily usage\ninfo")
            }

            Spacer(modifier = Modifier.height(36.dp))

            // Big green CTA button
            Button(
                onClick = onStartClicked,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF19A316)),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .height(72.dp)
                    .fillMaxWidth(0.75f),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp)
            ) {
                Text(
                    text = "START NOW",
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "you can revert your choice anytime via your\nphone settings",
                fontSize = 12.sp,
                color = Color(0xFFD9D9F2),
                lineHeight = 16.sp,
                modifier = Modifier.padding(horizontal = 8.dp),
                )
        }
    }
}

@Composable
private fun FeatureItem(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(72.dp)
    ) {
        // Blue circular background
        Box(
            modifier = Modifier
                .size(68.dp)
                .clip(CircleShape)
                .background(
                    Brush.verticalGradient(listOf(Color(0xFF5DB2FF), Color(0xFF2A8BFF)))
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = title,
            fontSize = 12.sp,
            color = Color(0xFFEBEEFF),
            fontWeight = FontWeight.Medium,
            lineHeight = 14.sp,
        )
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun OnboardingPreview() {
    MaterialTheme {
        OnboardingScreen {}
    }
}
