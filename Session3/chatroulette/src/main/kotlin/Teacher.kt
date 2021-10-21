class Teacher(override val name: String): Person(name) {
    fun talk() {
        funFact()
    }
    fun funFact() {
        println("Kotlin was named after an island")
    }
}