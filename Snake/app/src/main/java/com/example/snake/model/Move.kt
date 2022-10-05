package com.example.snake.model

sealed class Move(val x: Int, val y: Int) {
    class UP(x: Int = 0, y: Int = 1) : Move(x, y)
    class RIGHT(x: Int = 1, y: Int = 0) : Move(x, y)
    class DOWN(x: Int = 0, y: Int = -1) : Move(x, y)
    class LEFT(x: Int = -1, y: Int = 0) : Move(x, y)
}