class NoteMenu(private val menuHandler: MenuHandler, private val archive: Archive) {
    fun show() {
        val options = archive.notes.map { note ->
            note.title to { showNoteContent(note) }
        }.toMutableList()

        options.add(0, "Создать заметку" to { createNote() })
        options.add("Назад" to { /* No action, just exit */ })

        menuHandler.displayMenu(options)
    }

    private fun createNote() {
        println("Введите название заметки:")
        val title = menuHandler.readInput().trim()
        if (title.isEmpty()) {
            println("Название заметки не может быть пустым.")
            return
        }

        println("Введите содержание заметки:")
        val content = menuHandler.readInput().trim()
        if (content.isEmpty()) {
            println("Содержание заметки не может быть пустым.")
            return
        }

        archive.notes.add(Note(title, content))
        println("Заметка \"$title\" создана.")
        show()
    }

    private fun showNoteContent(note: Note) {
        println("Название: ${note.title}")
        println("Содержание: ${note.content}")
        println("Нажмите Enter чтобы вернуться назад")
        menuHandler.readInput()
        show()
    }
}