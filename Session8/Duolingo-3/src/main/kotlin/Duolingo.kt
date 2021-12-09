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
    }

    fun play() {
        var words: WordDeck = WordDeck()
        words.filterByLanguage(language)
        val selectedWords = selectRandomWords(words.filteredWords)
        var i = selectedWords.size
        for (word in selectedWords) {
            Thread.sleep(400)
            println("Vertaal ${word.original} van het ${word.language} naar het Nederlands! Moeilijkheid: ${word.difficulty}")
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
            word.difficulty -= 1
        } else if (userInput == "HINT") {
            println("The first letter is ${word.translated.first()}")
            validateResponse(word)
        }
        else {
            println("Thinking...")
            Thread.sleep(100)
            println("Fout!")
            word.difficulty += 2
            println(word.difficulty)
        }
    }
}