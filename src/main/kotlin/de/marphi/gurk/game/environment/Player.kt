package de.marphi.gurk.game.environment


data class Player(var currentLocation: Location, val pocket: MutableList<Item> = mutableListOf()) {

    fun move(nextLocation: Location): String {
        if (currentLocation.neighboringLocations.map { it.neighboringLocation }.contains(nextLocation)) {
            currentLocation = nextLocation
            return currentLocation.toString()
        }
        return "... hier geht's nicht lang"
    }

    fun take(itemToTake: Item): String {
        if (currentLocation.locationItems.contains(itemToTake)) {
            if (itemToTake.portable) {
                pocket.add(itemToTake)
                currentLocation.removeLocationItem(itemToTake)
                return "Geil, dieses Ding namens $itemToTake will ich haben, auch wenn ich noch nicht weiß warum..."
            } else {
                return "Puh, das kann ich irgendwie nicht mitnehmen"
            }
        }
        return "Das gibt es hier nicht"
    }

    fun examine(itemToExamine: Item): String {
        if (currentLocation.locationItems.contains(itemToExamine) || pocket.contains(itemToExamine)) {
            return itemToExamine.description
        }
        return "Ich weiß nicht was das sein soll"
    }

    override fun toString(): String {
        return currentLocation.toString()
    }
}