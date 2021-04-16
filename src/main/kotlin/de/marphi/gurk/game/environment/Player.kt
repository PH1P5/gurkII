package de.marphi.gurk.game.environment


data class Player(var currentLocation: Location) {

    fun move(nextLocation: Location): String {
        if (currentLocation.neighboringLocations.map { it.neighboringLocation }.contains(nextLocation)) {
            currentLocation = nextLocation
            return this.toString()
        }
        return "... hier geht's nicht lang"
    }

    override fun toString(): String {
        return currentLocation.toString()
    }
}