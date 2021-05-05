package de.marphi.gurk.game

import de.marphi.gurk.game.environment.Location
import de.marphi.gurk.game.environment.LocationRelation
import de.marphi.gurk.game.environment.Player
import de.marphi.gurk.game.environment.Item


fun initializeTestGame(): Game {
    val fog = Location("Du gehst weiter und weiter in den Nebel und stellst fest, dass du feststeckst. Ein Sumpf!")
    val boat = Location("Du stehst auf einem Segelboot, ein Dreimaster ... nichts besonderes gibt es hier nur ein paar betrunkene Ratten und nagende Piraten ... oder andersrum?!?")
    val landingStage = Location("Du stehst auf einem Steg, die raue See schlägt dir mit voller Wucht ins Gesicht, es ist nebelig ...", mutableListOf(
        LocationRelation("Nebel", "Dichter Nebel zieht sich entlang der Küste", fog, "dichten"),
        LocationRelation("Boot", "Ein Boot aus Holz liegt am Steg an", boat, "hölzerne")
    ))

    landingStage.addLocationItem(Item("Pfosten", "Da kann man wohl Boote festmachen...", false))
    boat.addLocationItem(Item("Stock", "Ein Stock. Nicht schön, aber Stöcker sind in solchen Spielen doch immer nützlich...", true))

    val startLocation = landingStage

    boat.addNeighboringLocation(LocationRelation("Steg","Ein Steg an dem das Boot anliegt.", startLocation))

    val player = Player(startLocation)

    return  Game(player, CommandParser())
}

fun main(args: Array<String>) {
    val game = initializeTestGame()
    println(game.introText())

    while (true) {
        val stringInput = readLine()!!
        println(game.handleInput(stringInput))
    }
}