fun main() {
    val persons = arrayOf<Person>(Person("Benoit"), Person("Ilyes"))
    val chatPartner = persons.random()
    chatPartner.introduce()
}