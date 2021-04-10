package de.marphi.gurk.game.environment

// this can be everything: a room, a beach, a concert hall, a ...
class Location(val description: String, val neighboringLocation: List<LocationRelation>) {

    override fun toString(): String {
        return description +
                "Du kannst diesen Ort über folgende Möglichkeiten verlassen: " +
                "${neighboringLocation.map { "  $it \n" }}"
    }

}