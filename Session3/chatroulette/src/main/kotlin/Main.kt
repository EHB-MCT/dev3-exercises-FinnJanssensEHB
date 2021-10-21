fun main() {
    val persons = arrayOf<Chatpartner>(Student("Benoit"), Teacher("Maaike"), Comedian("Mike"), Chatbot())
    val chatPartner = persons.random()
    chatPartner.introduce()
    chatPartner.talk()
}