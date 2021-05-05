package de.marphi.gurk.game

sealed class Command(val name: String, val description: String) {

    object Move : Command("gehe", "tippe `gehe durch die rote Tür`")
    object Help : Command("hilfe", "listet alle Befehle und Informationen zum Spiel auf")
    object Look : Command("umsehen", "zeigt Informationen zur Umgebung")
    object Take : Command("nimm", "tippe 'nimm das ding alter'")
    object Pocket : Command("tasche", "listet alle Dinge in deiner Tasche auf")
    object Examine : Command("untersuche", "Untersuche Dinge")
    object Unknown : Command("", "")

    override fun toString(): String {
        return "`$name` - $description"
    }
}