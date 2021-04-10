package de.marphi.gurk.game

class CommandParser {

    fun parse(commandLineInput: String) : Command {
        // this only works with 'object' as sealed nested class, not for data classes
        val knownCommands = Command::class.nestedClasses.map { it.objectInstance as Command }

        val words = commandLineInput.split(" ").map { it.toLowerCase() }

        return knownCommands.find { words.contains(it.name) }
            ?: Command.Unknown
    }

}