package com.example.learningcanvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val Xs = 50f
    private val Ys = 50f

    private fun drawCircleStrokeStyle(canvas: Canvas?) {
        canvas?.let {
            paint.color = Color.BLACK
            paint.style = Paint.Style.STROKE
            val radius = 50f
            canvas.drawCircle(Xs, Ys, radius, paint)
        }
    }

    private fun drawCircleFillStyle(canvas: Canvas?) {
        canvas?.let {
            paint.color = Color.RED
            paint.style = Paint.Style.FILL
            val radius = 50f
            canvas.drawCircle(Xs * 4, Ys, radius, paint)
        }
    }

    private fun drawSquareStrokeStyle(canvas: Canvas?) {
        canvas?.let {
            paint.color = Color.BLACK
            paint.style = Paint.Style.STROKE
            canvas.drawRect(0f, Ys * 4, Xs * 2, Ys * 6, paint)
        }
    }

    private fun drawSquareFillStyle(canvas: Canvas?) {
        canvas?.let {
            paint.color = Color.RED
            paint.style = Paint.Style.FILL
            canvas.drawRect(Xs * 4, Ys * 4, Xs * 6, Ys * 6, paint)
        }
    }

    private fun drawRectangleStrokeStyle(canvas: Canvas?) {
        canvas?.let {
            paint.color = Color.BLACK
            paint.style = Paint.Style.STROKE
            canvas.drawRect(0f, Ys * 8, Xs * 5, Ys * 10, paint)
        }
    }

    private fun drawRectangleFillStyle(canvas: Canvas?) {
        canvas?.let {
            paint.color = Color.RED
            paint.style = Paint.Style.FILL
            canvas.drawRect(Xs * 7, Ys * 8, Xs * 12, Ys * 10, paint)
        }
    }

    private fun drawLine(canvas: Canvas?) {
        canvas?.let {
            paint.color = Color.BLACK
            canvas.drawLine(0f, Ys * 12, Xs * 4, Ys * 14, paint)
        }
    }

    private fun drawOvalStrokeStyle(canvas: Canvas?) {
        canvas?.let {
            paint.color = Color.BLACK
            paint.style = Paint.Style.STROKE
            canvas.drawOval(0f, Ys * 16, Xs * 4, Ys * 18, paint)
        }
    }

    private fun drawOvalFillStyle(canvas: Canvas?) {
        canvas?.let {
            paint.color = Color.RED
            paint.style = Paint.Style.FILL
            canvas.drawOval(Xs * 6, Ys * 16, Xs * 10, Ys * 18, paint)
        }
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        drawCircleStrokeStyle(canvas)
        drawCircleFillStyle(canvas)
        drawSquareStrokeStyle(canvas)
        drawSquareFillStyle(canvas)
        drawRectangleStrokeStyle(canvas)
        drawRectangleFillStyle(canvas)
        drawLine(canvas)
        drawOvalStrokeStyle(canvas)
        drawOvalFillStyle(canvas)
    }
}