package de.marphi.gurk.game.environment

// this can be everything connecting a locations
// in a simple implementation it might be a door, but it can be a ladder, a wormhole, a ...
data class LocationRelation(val name: String,
                            val adjective: String,
                            val description: String,
                            val neighboringLocation: Location) {

    override fun toString(): String {
        return description
    }
}