package com.example.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class MyCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val rect = Rect()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var squareColor = 0
    private var padding = 0

    init {
        attrs?.let {
            val typedArray = getContext().obtainStyledAttributes(it, R.styleable.MyCustomView)
            squareColor = typedArray.getColor(R.styleable.MyCustomView_square_color, Color.GREEN)
            paint.color = squareColor
            typedArray.recycle()
        }
    }

    fun swapColor() {
        paint.color = if (paint.color == squareColor) Color.RED else squareColor
        postInvalidate()
    }

    fun customPaddingUp(value: Int) {
        padding += value
        postInvalidate()
    }

    fun customPaddingDown(value: Int) {
        padding -= value
        postInvalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.apply {
            rect.left = 0
            rect.right = width - padding
            rect.top = 0
            rect.bottom = height - padding
            canvas?.drawRect(rect, this)
        }
    }

}