package com.example.spacetrader.model

class Game constructor(val _player: Player, val _difficulty: Difficulty){

    init {
        val difficulty = _difficulty
        val player = _player
    }

}