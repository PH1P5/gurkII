package de.marphi.gurk.game

sealed class Command(val name: String, val description: String) {

    object Move : Command("gehe", "... `gehe durch die rote Tür` ")
    object Help : Command("hilfe", "... `hilfe` - listet alle Befehle ")
    object Unknown : Command("", "")

    override fun toString(): String {
        return "$name - $description"
    }
}