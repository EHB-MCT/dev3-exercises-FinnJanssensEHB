open abstract class Word (
    open val original: String,
    open val translated: String,
    open val language: String,
    difficulty: Int
) {
    open var difficulty = difficulty
        set(value) {
            if (value < 1) field = 1
        }

}