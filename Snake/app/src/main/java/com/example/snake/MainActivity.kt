package com.example.snake

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import androidx.appcompat.app.AlertDialog
import com.example.snake.databinding.ActivityMainBinding
import com.example.snake.model.Move
import com.example.snake.model.Point
import com.example.snake.model.Snake
import com.example.snake.others.Constants
import java.util.*

class MainActivity : AppCompatActivity(), SurfaceHolder.Callback {

    lateinit var binding: ActivityMainBinding
    lateinit var surfaceHolder: SurfaceHolder

    private val snake = Snake()
    private var score = 0
    private val randomPoint = Point(0, 0)


    private var canvas: Canvas? = null
    private var pointColor: Paint? = null

    private var timer: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.surfaceView.holder.addCallback(this)

        binding.btnUp.setOnClickListener {
            if (snake.currentMove::class != Move.DOWN::class) {
                snake.currentMove = Move.UP()
            }
        }

        binding.btnRight.setOnClickListener {
            if (snake.currentMove::class != Move.LEFT::class) {
                snake.currentMove = Move.RIGHT()
            }
        }

        binding.btnDown.setOnClickListener {
            if (snake.currentMove::class != Move.UP::class) {
                snake.currentMove = Move.DOWN()
            }
        }

        binding.btnLeft.setOnClickListener {
            if (snake.currentMove::class != Move.RIGHT::class) {
                snake.currentMove = Move.LEFT()
            }
        }
    }

    private fun reset() {
        binding.txtScore.text = "0"
        snake.points.clear()
        var x = Constants.DEFAULT_SNAKE_SIZE * Constants.POINT_SIZE
        val y = Constants.POINT_SIZE
        snake.currentMove = Move.RIGHT()
        score = 0
        for (i in 1..3) {
            snake.points.add(Point(x - (Constants.POINT_SIZE * 2), y))
            x -= Constants.POINT_SIZE * 2
        }
        addRandomPoint()
        moveSnake()
    }

    private fun addRandomPoint() {
        val surfaceWidth = binding.surfaceView.width - (Constants.POINT_SIZE * 2)
        val surfaceHeight = binding.surfaceView.height - (Constants.POINT_SIZE * 2)
        var randomXPosition = (0..surfaceWidth / Constants.POINT_SIZE).random()
        var randomYPosition = (0..surfaceHeight / Constants.POINT_SIZE).random()
        if (randomXPosition % 2 != 0) {
            randomXPosition++
        }
        if (randomYPosition % 2 != 0) {
            randomYPosition++
        }
        randomPoint.x = (Constants.POINT_SIZE * randomXPosition) + Constants.POINT_SIZE
        randomPoint.y = (Constants.POINT_SIZE * randomYPosition) + Constants.POINT_SIZE
    }

    private fun moveSnake() {
        timer = Timer()
        timer?.let {
            it.scheduleAtFixedRate(object : TimerTask() {
                override fun run() {
                    val headSnake = snake.points.first()
                    var x = headSnake.x
                    var y = headSnake.y
                    if (x == randomPoint.x && y == randomPoint.y) {
                        growSnake()
                        addRandomPoint()
                    }
                    when (snake.currentMove::class) {
                        Move.RIGHT::class -> {
                            snake.points.first().x = x + (Constants.POINT_SIZE * 2)
                            snake.points.first().y = y
                        }
                        Move.LEFT::class -> {
                            snake.points.first().x = x - (Constants.POINT_SIZE * 2)
                            snake.points.first().y = y
                        }
                        Move.UP::class -> {
                            snake.points.first().x = x
                            snake.points.first().y = y - (Constants.POINT_SIZE * 2)
                        }
                        Move.DOWN::class -> {
                            snake.points.first().x = x
                            snake.points.first().y = y + (Constants.POINT_SIZE * 2)
                        }
                    }
                    if (checkGameOver(x, y)) {
                        it.purge()
                        it.cancel()
                        runOnUiThread {
                            displayGameOverDialog().show()
                        }
                    } else {
                        canvas = surfaceHolder.lockCanvas()
                        canvas?.let {
                            it.drawColor(Color.WHITE, PorterDuff.Mode.CLEAR)
                            it.drawCircle(
                                snake.points.first().x.toFloat(),
                                snake.points.first().y.toFloat(),
                                Constants.POINT_SIZE.toFloat(),
                                createPointColor()
                            )
                            it.drawCircle(
                                randomPoint.x.toFloat(),
                                randomPoint.y.toFloat(),
                                Constants.POINT_SIZE.toFloat(),
                                createPointColor()
                            )
                            for (i in 1 until snake.points.size) {
                                val tempX = snake.points[i].x
                                val tempY = snake.points[i].y
                                snake.points[i].x = x
                                snake.points[i].y = y
                                it.drawCircle(
                                    snake.points[i].x.toFloat(),
                                    snake.points[i].y.toFloat(),
                                    Constants.POINT_SIZE.toFloat(),
                                    createPointColor()
                                )
                                x = tempX
                                y = tempY
                            }
                        }
                        surfaceHolder.unlockCanvasAndPost(canvas)
                    }
                }
            }, 1000 - Constants.SNAKE_SPEED, 1000 - Constants.SNAKE_SPEED)
        }
    }

    private fun createPointColor(): Paint {
        if (pointColor == null) {
            pointColor = Paint().apply {
                color = Constants.SNAKE_COLOR
                style = Paint.Style.FILL
                isAntiAlias = true
            }
        }
        return pointColor!!
    }

    private fun growSnake() {
        val newPoint = Point(0, 0)
        snake.points.add(newPoint)
        score++
        runOnUiThread {
            binding.txtScore.text = score.toString()
        }
    }

    private fun displayGameOverDialog() = AlertDialog.Builder(this).apply {
        setMessage("Your score = $score")
        setTitle("Game Over")
        setCancelable(false)
        setPositiveButton(
            "Start Again"
        ) { _, _ -> reset() }
    }

    private fun checkGameOver(headPositionX: Int, headPositionY: Int): Boolean {
        if (headPositionX < 0 || headPositionY < 0 ||
            headPositionX >= binding.surfaceView.width ||
            headPositionY >= binding.surfaceView.height
        ) {
            return true
        }
        for (i in 1 until snake.points.size) {
            val currX = snake.points[i].x
            val currY = snake.points[i].y
            if (headPositionX == currX && headPositionY == currY) {
                return true
            }
        }
        return false
    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        this.surfaceHolder = surfaceHolder
        reset()
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder, p1: Int, p2: Int, p3: Int) {
    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
    }
}