package com.modsen.tasksstepan.UI.Posts

import androidx.compose.runtime.getValue
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
@Composable
fun CustomLoader(
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.Refresh
) {
    val infiniteTransition = rememberInfiniteTransition(label = "rotation")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = "rotation_anim"
    )

    Icon(
        imageVector = icon,
        contentDescription = null,
        modifier = modifier
            .size(48.dp)
            .rotate(rotation)
    )
}