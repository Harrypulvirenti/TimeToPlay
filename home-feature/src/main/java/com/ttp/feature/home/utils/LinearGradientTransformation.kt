package com.ttp.feature.home.utils

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Shader.TileMode
import androidx.annotation.ColorInt
import androidx.core.graphics.applyCanvas
import coil.bitmappool.BitmapPool
import coil.size.Size
import coil.transform.Transformation
import java.lang.Math.toRadians
import kotlin.math.cos
import kotlin.math.sin

private const val DEFAULT_ANGLE = 90.0

internal class LinearGradientTransformation(
    @ColorInt private val endColor: Int,
    private val angle: Double = DEFAULT_ANGLE
) : Transformation {

    override fun key(): String = "${LinearGradientTransformation::class.java.name}-$endColor,$angle"

    override suspend fun transform(pool: BitmapPool, input: Bitmap, size: Size): Bitmap {
        val width: Int = input.width
        val height: Int = input.height
        val output = pool.get(width, height, input.safeConfig)

        output.applyCanvas {
            drawBitmap(input, 0F, 0F, null)
            val angleInRadians = toRadians(angle)
            val endX = (cos(angleInRadians) * width).toFloat()
            val endY = (sin(angleInRadians) * height).toFloat()

            val paint = Paint().apply {
                shader = LinearGradient(
                    0F,
                    0F,
                    endX,
                    endY,
                    Color.TRANSPARENT,
                    endColor,
                    TileMode.CLAMP
                )
                xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP)
            }

            drawRect(0F, 0F, width.toFloat(), height.toFloat(), paint)
        }
        pool.put(input)
        return output
    }
}

internal val Bitmap.safeConfig: Bitmap.Config
    get() = config ?: Bitmap.Config.ARGB_8888