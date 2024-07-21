import java.util.Scanner

class MenuHandler {
    private val scanner = Scanner(System.`in`)

    fun readInput(): String {
        return scanner.nextLine()
    }

    fun readInt(): Int? {
        return try {
            scanner.nextLine().toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }

    fun <T> displayMenu(options: List<Pair<String, () -> T>>) {
        while (true) {
            options.forEachIndexed { index, option ->
                println("$index. ${option.first}")
            }

            val input = readInt()
            if (input != null && input in options.indices) {
                options[input].second.invoke()
                break
            } else {
                println("Неверный ввод, попробуйте снова.")
            }
        }
    }
}