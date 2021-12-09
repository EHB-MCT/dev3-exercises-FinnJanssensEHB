class WordDeck {
    var wordSet: MutableSet<Word> = mutableSetOf(
        FrenchWord("une cantine", "een kantine"),
        FrenchWord("de l'or", "goud"),
        FrenchWord("de l'acier", "staal", 2),
        FrenchWord("du zinc", "zink"),
        FrenchWord("du coton", "katoen"),
        FrenchWord("de la laine", "wol", 2),
        FrenchWord("de l'argile", "klei", 2),
        FrenchWord("de gaz", "gas"),
        FrenchWord("de la boue", "modder", 2),
        FrenchWord("du sable", "zand"),
        EnglishWord("a cafeteria", "een kantine"),
        EnglishWord("gold", "goud"),
        EnglishWord("steel", "staal"),
        EnglishWord("zinc", "zink"),
        EnglishWord("coton", "katoen", 2),
        EnglishWord("wool", "wol"),
        EnglishWord("clay", "klei", 2),
        EnglishWord("gas", "gas"),
        EnglishWord("mud", "modder"),
        EnglishWord("sand", "zand")
    )
    var filteredWords: MutableSet<Word> = mutableSetOf()
    fun filterByLanguage(words: MutableSet<Word>,language: String) {
        filteredWords = words.filter { it.language == language}.toMutableSet()
    }
    fun filterByDifficulty(words: MutableSet<Word>, difficulty: Int) {
        filteredWords = words.filter { it.difficulty == difficulty}.toMutableSet()
    }
    fun reset() {
        filteredWords = wordSet
    }
}