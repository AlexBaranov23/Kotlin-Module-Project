data class Note(val title: String, val content: String)

data class Archive(val name: String) {
    val notes = mutableListOf<Note>()
}

fun main() {
    val menuHandler = MenuHandler()
    val archives = mutableListOf<Archive>()

    while (true) {
        ArchiveMenu(menuHandler, archives).show()
    }
}
