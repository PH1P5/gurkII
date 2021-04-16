package de.marphi.gurk.game

import de.marphi.gurk.game.environment.Player

class Game(val player: Player, val parser: CommandParser) {

    fun introText(): String = "Das ist ein Spiel - tippe 'hilfe' wenn du nicht weiter kommst! " +
            "\n\n" +
            "$player"

    fun handleInput(commandLineInput: String): String {
        val command = parser.parseCommand(commandLineInput)

        return when(command) {
            Command.Move -> {
                handlePlayerMovement(commandLineInput)
            }
            Command.Look -> "$player\n\n"
            Command.Help -> createHelpText()
            Command.Unknown -> "... ${listOf("Was", "hö","wä","Wie","der Vorname", "Gewitter","Ägypten", "wie meinen").random()}?!?"
        }
    }

    private fun handlePlayerMovement(commandLineInput: String): String {
        val nextLocation = parser.parseLocationRelation(commandLineInput, player)
        return player.move(nextLocation)
    }

    private fun createHelpText(): String {
        return "Folgende Befehle stehen zur Verfügung:" +
                "\n" +
                knownCommands().filterNot { it.name.isBlank() }.joinToString("\n") +
                "\n\n"
    }
}