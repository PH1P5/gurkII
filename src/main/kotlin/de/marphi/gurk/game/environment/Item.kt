package de.marphi.gurk.game.environment

// A item, which can potrable or fix. Portable items may  be put into a players pocket fixed items cannot be moved
data class Item(val name: String, val description: String, val portable: Boolean){

    companion object {
        val UNKNOWN_ITEM = Item("", "", false)
    }

    override fun toString(): String {
        return name
    }
}