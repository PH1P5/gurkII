package de.marphi.gurk.game

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test


class CommandParserTest {

    @Test
    fun `can parse move command`() {
        val actual = CommandParser().parseCommand("bitte gehe über den Regenbogen")

        assertThat(actual).isEqualTo(Command.Move)
    }

    @Test
    fun `can parse help command ignoring case`() {
        val actual = CommandParser().parseCommand("Zu Hilfe")

        assertThat(actual).isEqualTo(Command.Help)
    }

    @Test
    fun `can handle unknown command`() {
        val actual = CommandParser().parseCommand("was für ein §ch31ss ... ")

        assertThat(actual).isEqualTo(Command.Unknown)
    }
}