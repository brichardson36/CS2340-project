package com.example.spacetrader.viewModel

import com.example.spacetrader.model.Difficulty
import com.example.spacetrader.model.Player
import com.example.spacetrader.model.Skill

class ConfigViewModel {

    val totalPointsAvailable: Int = 16
    var remainingPoints: Int = 0

    var name: String? = null
    val pilotSkill = Skill("Pilot", 0)
    val fighterSkill = Skill("Fighter", 0)
    val traderSkill = Skill("Trader", 0)
    val engineerSkill = Skill("Engineer", 0)

    var difficulty: Difficulty = Difficulty.BEGINNER

    fun updateSkill(skill: Skill, to: Int) {
        val skills = listOf(pilotSkill, fighterSkill, traderSkill, engineerSkill)

        skill._points = to

        var currentPoints = 0
        skills.forEach {
            currentPoints += it?._points ?: 0
        }

        remainingPoints = totalPointsAvailable - currentPoints

        var overflow = Math.min(0, totalPointsAvailable - currentPoints)
        skills
                .filter { it != skill }
                .forEach {
                    val progress = it?._points ?: 0
                    val delta = Math.max(-1 * progress, overflow)

                    it?._points = progress + delta
                    overflow -= delta
                }
    }

}
