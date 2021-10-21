class Comedian(override val name: String): Person(name) {
    override fun talk() {
        tellJoke()
    }
    fun tellJoke() {
        println("What is green and goes down the hill? A Skiwi")
    }
}