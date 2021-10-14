import kotlin.random.Random

var playerEnergy = 10

fun main() {

    println("Welcome! You are on a deserted island. Your goal is to survive as long as possible on this island.")
    println("Challenges will make you gain or lose energy.")
    println("Your current energy is $playerEnergy")
    println("When your energy is at 0, the game is over.")
    println("Good luck.")

    challengeOne()
}

fun challengeOne() {
    println("Challenge 1:")
    println("A country from the top 5 countries with most islands will be named. You have to answer the ranking place of that country")
    val topCountriesWithMostIslands = listOf<String>("Sweden", "Finland", "Norway", "Canada", "Indonesia")
    val randomIndex = Random.nextInt(topCountriesWithMostIslands.size)
    val correctedIndex = randomIndex + 1
    val selectedCountry = topCountriesWithMostIslands[randomIndex]
    println("At what place does $selectedCountry rank?")
    val userGuess = readLine()
    if (userGuess != null) {
        if (userGuess.toInt() == correctedIndex) {
            println("Correct! $selectedCountry ranks at $correctedIndex")
            winEnergy()
        } else {
            println("False! $selectedCountry ranks at $correctedIndex")
            loseEnergy()
        }
    }
}

fun winEnergy() {
    playerEnergy += 2
    println("Won some energy! Current energy is: $playerEnergy")
}

fun loseEnergy() {
    playerEnergy -= 2
    println("Lost some energy! Current energy is: $playerEnergy")

}