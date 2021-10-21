fun main() {
    val persons = arrayOf<Person>(Student("Benoit"), Teacher("Maaike"), Comedian("Mike"))
    val chatPartner = persons.random()
    chatPartner.introduce()
    chatPartner.talk()
}