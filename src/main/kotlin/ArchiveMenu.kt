import kotlin.system.exitProcess

class ArchiveMenu (private val menuHandler: MenuHandler, private val archives: MutableList<Archive>) {
    fun show() {
        val options = archives.map { archive ->
            archive.name to { showArchive(archive) }
        }.toMutableList()

        options.add(0, "Создать архив" to { createArchive() })
        options.add("Выход" to { exitProcess(0) })

        menuHandler.displayMenu(options)
    }

    private fun createArchive() {
        println("Введите имя нового архива:")
        val name = menuHandler.readInput().trim()
        if (name.isNotEmpty()) {
            archives.add(Archive(name))
            println("Архив \"$name\" создан.")
        } else {
            println("Имя архива не может быть пустым.")
        }
        show()
    }

    private fun showArchive(archive: Archive) {
        NoteMenu(menuHandler, archive).show()
    }
}