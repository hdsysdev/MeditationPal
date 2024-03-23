package com.hddev.meditationpal.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp

@Composable
fun PartialCircularProgressIndicator(
    progress: Float,
    startAngle: Float = 0f,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    strokeWidth: Dp = ProgressIndicatorDefaults.CircularStrokeWidth,
    circularIndicatorSize: Dp = ProgressIndicatorDefaults.CircularStrokeWidth * 4,
    trackColor: Color = MaterialTheme.colorScheme.surface.copy(alpha = 0.12f)
) {
    val indicatorModifier = modifier.size(circularIndicatorSize)

    Canvas(modifier = indicatorModifier) {
        val sweep = (progress * 360f)
        drawCircularProgressIndicator(
            startAngle = startAngle,
            sweep = sweep,
            color = color,
            trackColor = trackColor,
            strokeWidth = strokeWidth.toPx()
        )
    }
}

private fun DrawScope.drawCircularProgressIndicator(
    startAngle: Float,
    sweep: Float,
    color: Color,
    trackColor: Color,
    strokeWidth: Float
) {
    val gradient = Brush.sweepGradient(
        colors = listOf(
            color.copy(alpha = 0.2f),
            color.copy(alpha = 0.4f),
            color.copy(alpha = 0.7f),
            color,
            color
        )
    )

    drawCircularIndicatorTrack(
        startAngle = startAngle,
        sweep = sweep,
        trackColor = trackColor,
        strokeWidth = strokeWidth
    )

    drawArc(
        brush = gradient,
        startAngle = startAngle,
        sweepAngle = sweep,
        useCenter = false,
        style = Stroke(strokeWidth, cap = StrokeCap.Round)
    )
}

private fun DrawScope.drawCircularIndicatorTrack(
    startAngle: Float,
    sweep: Float,
    trackColor: Color,
    strokeWidth: Float
) {
    drawArc(
        color = trackColor,
        startAngle = startAngle,
        sweepAngle = sweep,
        useCenter = false,
        style = Stroke(strokeWidth, cap = StrokeCap.Round)
    )
}