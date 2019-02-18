package com.example.spacetrader.entity

class Player constructor(val _name: String){

    val pilotSkill = Skill("Pilot", 0)
    val fighterSkill = Skill("Fighter", 0)
    val traderSkill = Skill("Trader", 0)
    val engineerSkill = Skill("Engineer", 0)

    init {
        val name = _name
    }
}