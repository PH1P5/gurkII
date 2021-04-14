package de.marphi.gurk.game

import de.marphi.gurk.game.environment.Location
import de.marphi.gurk.game.environment.LocationRelation
import de.marphi.gurk.game.environment.Player
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test


class GameTest {

    private lateinit var roomB: Location
    private lateinit var roomA: Location
    private lateinit var startLocation: Location
    private lateinit var game: Game


    @BeforeEach
    private fun initGame() {
        roomB = Location("Raum B")
        roomA = Location("Raum A")
        startLocation = Location("Start")

        startLocation.addNeighboringLocation(LocationRelation("Tür", "Eine Tür die in Raum A führt", roomA))
        startLocation.addNeighboringLocation(LocationRelation("Tür", "Eine rote Tür die in Raum B führt", roomB, "rote"))

        val startRelation = LocationRelation("Tür", "zum Raum A", startLocation)
        roomA.addNeighboringLocation(startRelation)
        roomB.addNeighboringLocation(startRelation)
        val player = Player(startLocation)
        game = Game(player, CommandParser())
    }


    @Disabled("make this run using adjective in CommandParser")
    @Test
    fun `move command with adjective hits the one without adjective`() {
        game.handleInput("gehe durch die rote tür")

        assertThat(game.player.currentLocation).isEqualTo(roomB)
    }

    @Test
    fun `can move without adjective`() {
        game.handleInput("gehe zur tür")

        assertThat(game.player.currentLocation).isEqualTo(roomA)
    }

    @Test
    fun `can move to room and back to start`() {
        game.handleInput("gehe durch die tür")
        game.handleInput("gehe zurück durch die tür")

        assertThat(game.player.currentLocation).isEqualTo(startLocation)
    }

    @Test
    fun `can request help`() {
        assertThat(game.handleInput("hilfe")).startsWith("Folgende Befehle")
    }

}