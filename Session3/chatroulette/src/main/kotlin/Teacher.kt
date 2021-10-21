class Teacher(override val name: String): Person(name), Chatpartner {
    override fun talk() {
        funFact()
    }
    fun funFact() {
        println("Kotlin was named after an island")
    }
}