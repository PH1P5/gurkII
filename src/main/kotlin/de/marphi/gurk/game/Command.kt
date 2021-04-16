package de.marphi.gurk.game

sealed class Command(val name: String, val description: String) {

    object Move : Command("gehe", "tippe `gehe durch die rote Tür`")
    object Help : Command("hilfe", "listet alle Befehle und Informationen zum Spiel auf")
    object Look : Command("umsehen", "zeigt Informationen zur Umgebung")
    object Unknown : Command("", "")

    override fun toString(): String {
        return "`$name` - $description"
    }
}