class Duolingo(val roundSize: Int, val language: String = "Engels") {
    var words = mutableSetOf<Word>(
        Word("une cantine", "een kantine", "Frans"),
        Word("de l'or", "goud", "Frans"),
        Word("de l'acier", "staal", "Frans"),
        Word("du zinc", "zink", "Frans"),
        Word("du coton", "katoen", "Frans"),
        Word("de la laine", "wol", "Frans"),
        Word("de l'argile", "klei", "Frans"),
        Word("de gaz", "gas", "Frans"),
        Word("de la boue", "modder", "Frans"),
        Word("du sable", "zand", "Frans"),
        Word("a cafeteria", "een kantine", "Engels"),
        Word("gold", "goud", "Engels"),
        Word("steel", "staal", "Engels"),
        Word("zinc", "zink", "Engels"),
        Word("coton", "katoen", "Engels"),
        Word("wool", "wol", "Engels"),
        Word("clay", "klei", "Engels"),
        Word("gas", "gas", "Engels"),
        Word("mud", "modder", "Engels"),
        Word("sand", "zand", "Engels")
    )

    var wordSet = mutableSetOf<Word>()

    init {
        wordSet = words.filter { it.language == language }.toMutableSet()
    }

    fun play() {
        val selectedWords = selectRandomWords(wordSet)
        var i = selectedWords.size
        for (word in selectedWords) {
            println("Vertaal ${word.original} van het ${word.language} naar het Nederlands!")
            println("Nog ${i} woorden te gaan!")
            val userInput = readLine()
            if (userInput == word.translated) {
                println("Correct!")
            } else {
                println("Fout!")
            }
            i--
        }
    }
    fun selectRandomWords(wordSet: MutableSet<Word>): MutableSet<Word> {
        return wordSet.shuffled().take(roundSize).toMutableSet()
    }
}