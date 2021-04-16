package de.marphi.gurk.game

import de.marphi.gurk.game.environment.Location
import de.marphi.gurk.game.environment.Player

class CommandParser {

    fun parseCommand(commandLineInput: String) : Command {
        val knownCommands = knownCommands()

        val words = commandLineInput.split(" ").map { it.toLowerCase() }

        return knownCommands.find { words.contains(it.name) }
            ?: Command.Unknown
    }

    fun parseLocationRelation(commandLineInput: String, player: Player): Location {
        val words = commandLineInput.split(" ").map { it.toLowerCase() }

        val moreSpecificLocationRelation = player.currentLocation.neighboringLocations
            .find { words.contains(it.adjective.toLowerCase()) && words.contains(it.name.toLowerCase()) }
            ?.neighboringLocation

        val simpleLocationRelation = player.currentLocation.neighboringLocations
            .find { words.contains(it.name.toLowerCase()) }
            ?.neighboringLocation

        return moreSpecificLocationRelation
            ?: simpleLocationRelation
            ?: Location.UNKNOWN_LOCATION
    }

}

fun knownCommands() : List<Command> = Command::class.nestedClasses.map { it.objectInstance as Command }