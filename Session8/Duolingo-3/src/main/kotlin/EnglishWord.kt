class EnglishWord(
    override val original: String,
    override val translated: String,
    override var difficulty: Int = 1): Word(original, translated, "engels", difficulty) {

}