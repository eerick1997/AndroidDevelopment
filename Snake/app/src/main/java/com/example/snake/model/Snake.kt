package com.example.snake.model

class Snake(
    var currentMove: Move = Move.RIGHT(),
) {
    var points = mutableListOf<Point>()
}