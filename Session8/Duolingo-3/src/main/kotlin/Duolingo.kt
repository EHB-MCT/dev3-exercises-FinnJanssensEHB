import java.lang.IllegalArgumentException
import kotlin.concurrent.thread

class Duolingo {
    var roundSize: Int = 3
    var language: String = "engels"
    constructor(
        roundSize: Int,
        language: String
    ) {
        this.roundSize = roundSize
        this.language = language
    }
    constructor(
        difficulty: String = "easy"
    ) {
        if (difficulty == "easy") {
            this.roundSize = 3
            this.language = "engels"
        } else if (difficulty == "hard") {
            this.roundSize = 6
            this.language = "frans"
        } else {
            throw IllegalArgumentException("Only easy or hard can be set as difficulty!")
        }
        filterWords()
    }
    var words = mutableSetOf<Word>(
        FrenchWord("une cantine", "een kantine"),
        FrenchWord("de l'or", "goud"),
        FrenchWord("de l'acier", "staal"),
        FrenchWord("du zinc", "zink"),
        FrenchWord("du coton", "katoen"),
        FrenchWord("de la laine", "wol"),
        FrenchWord("de l'argile", "klei"),
        FrenchWord("de gaz", "gas"),
        FrenchWord("de la boue", "modder"),
        FrenchWord("du sable", "zand"),
        EnglishWord("a cafeteria", "een kantine"),
        EnglishWord("gold", "goud"),
        EnglishWord("steel", "staal"),
        EnglishWord("zinc", "zink"),
        EnglishWord("coton", "katoen"),
        EnglishWord("wool", "wol"),
        EnglishWord("clay", "klei"),
        EnglishWord("gas", "gas"),
        EnglishWord("mud", "modder"),
        EnglishWord("sand", "zand")
    )

    var wordSet = mutableSetOf<Word>()

    fun filterWords() {
        wordSet = words.filter { it.language == language }.toMutableSet()
    }

    fun play() {
        val selectedWords = selectRandomWords(wordSet)
        var i = selectedWords.size
        for (word in selectedWords) {
            Thread.sleep(400)
            println("Vertaal ${word.original} van het ${word.language} naar het Nederlands!")
            println("Nog ${i} woorden te gaan!")
            validateResponse(word)
            i--
        }
    }
    fun selectRandomWords(wordSet: MutableSet<Word>): MutableSet<Word> {
        return wordSet.shuffled().take(roundSize).toMutableSet()
    }

    fun validateResponse(word: Word) {
        val userInput = readLine()
        if (userInput == word.translated) {
            println("Thinking...")
            Thread.sleep(100)
            println("Correct!")
        } else if (userInput == "HINT") {
            println("The first letter is ${word.translated.first()}")
            validateResponse(word)
        }
        else {
            println("Thinking...")
            Thread.sleep(100)
            println("Fout!")
        }
    }
}