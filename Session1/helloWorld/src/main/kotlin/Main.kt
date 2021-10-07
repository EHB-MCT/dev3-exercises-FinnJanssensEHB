val students = arrayOf("Freya", "Finn", "Benoit", "Ilyes", "Robbe")

fun main() {
    greetStudents()
}

fun greetStudents() {
    for (student in students) {
        println("Hello $student")
    }
}

