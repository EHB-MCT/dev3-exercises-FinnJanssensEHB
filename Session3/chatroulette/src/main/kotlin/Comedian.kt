class Comedian(override val name: String): Person(name) {
    fun talk() {
        tellJoke()
    }
    fun tellJoke() {
        println("What is green and goes down the hill? A Skiwi")
    }
}