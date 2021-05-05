package de.marphi.gurk.game.environment

// this can be everything: a room, a beach, a concert hall, a ...
data class Location(val description: String,
                    val neighboringLocations: MutableList<LocationRelation> = mutableListOf(),
                    val locationItems: MutableList<Item> = mutableListOf()) {

    companion object {
        val UNKNOWN_LOCATION = Location("")
    }

    fun addNeighboringLocation(locationRelation: LocationRelation) {
        neighboringLocations.add(locationRelation)
    }

    fun addLocationItem(locationItem: Item) {
        locationItems.add(locationItem)
    }

    fun removeLocationItem(locationItem: Item) {
        locationItems.remove(locationItem)
    }

    override fun toString(): String {
        return description +
                "\n\n" +
                if (neighboringLocations.isEmpty()) {
                    "... du bist verloren, hier gibt es kein Weiterkommen ... aaaaaaaahhhhhhhh ..."
                } else {
                    "Du kannst diesen Ort über folgende Möglichkeiten verlassen:\n\n" +
                            neighboringLocations.joinToString("\n") +"\n\n" +
                    "Du blickst dich um und siehst folgende Dinge:\n\n" +
                            locationItems.joinToString("\n")
                } +
                "\n\n"
    }

}