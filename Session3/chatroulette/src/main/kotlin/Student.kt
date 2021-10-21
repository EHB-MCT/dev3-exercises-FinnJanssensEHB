class Student(override val name: String): Person(name), Chatpartner {
    override fun talk() {
        gossip()
    }
    fun gossip() {
        println("Gossip gossip gossip")
    }
}