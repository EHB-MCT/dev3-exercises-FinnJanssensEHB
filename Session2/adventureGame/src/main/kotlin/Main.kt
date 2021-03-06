import kotlin.random.Random
import kotlin.system.exitProcess

var playerEnergy = 6

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
    val answer = readLine()
    if (answer != null) {
        if (answer.toInt() == correctedIndex) {
            println("Correct! $selectedCountry ranks at $correctedIndex")
            winEnergy()
        } else {
            println("False! $selectedCountry ranks at $correctedIndex")
            loseEnergy()
        }
    }
    challengeTwo()
}

fun challengeTwo() {
    println("Name one of the top 3 biggest islands in the world.")
    val biggestIslands = setOf<String>("Greenland", "New Guinea", "Borneo")
    val answer = readLine()
    if (biggestIslands.contains(answer)) {
        winEnergy()
    } else {
        loseEnergy()
    }
    challengeThree()
}

fun challengeThree() {
    println("A wild tiger is standing right in front of you, what do you do?")
    println("Type the number of the action you want to perform.")
    val actions = setOf<String>("1: flee", "2: take sharp stick", "3: take rock")
    actions.forEach(::println)
    val answer = readLine()
    if (answer != null) {
        when (answer.toInt()) {
            1 -> {
                println("You ran away and lost some energy, go back to challenge 1!")
                loseEnergy()
                challengeOne()
            }
            2 -> {
                println("You use the sharp stick to poke the tiger and make it go away!")
                println("While doing this, you lost some energy.")
                loseEnergy()
            }
            3 -> {
                println("The rock is slippery and you drop it on your toe. The tiger eats you.")
                println("GAME OVER")
                println("Ended with $playerEnergy energy.")
                exitProcess(0)
            }
            else -> {
                println("Invalid input, game over.")
            }
        }
    }
    challengeFour()
}

fun challengeFour() {
    println("Now you have to guess the amount of trees on the island.")
    println("It's a value between 0 and 100.")
    val randomNumber = (0..10).random()
    do {
        val answer = readLine()?.toInt()
    } while (answer != randomNumber)
    println("Correct!")
    endBoss()
}

fun endBoss() {
    var tries = 3
    println("You have reached the end boss. Pick an anagram that you would like to solve by typing 1, 2 or 3! You have 3 tries.")
    val anagrams = setOf<String>("abuse eh och", "amino nuts", "corene co tut")
    val solutions = setOf<String>("beachhouse", "mountains", "coconuttree")
    do {
        anagrams.forEach(::println)
        val chosenAnagram = readLine()?.toInt()
        val chosenAnagramCorrected = chosenAnagram?.minus(1)
        if (chosenAnagramCorrected != null) {
            println("You chose ${anagrams.elementAt(chosenAnagramCorrected.toInt())}")
        }
        println("Please give your answer:")
        val answer = readLine()
        tries -= 1
        if (tries == 0) {
            println("Game Over!")
            exitProcess(0)
        }
    } while (tries != 0 && chosenAnagramCorrected != null && answer != solutions.elementAt(chosenAnagramCorrected.toInt()))
    println("Success!!")
}

fun winEnergy() {
    playerEnergy += 2
    println("Won some energy! Current energy is: $playerEnergy")
}

fun loseEnergy() {
    playerEnergy -= 2
    if (playerEnergy <= 0) {
        println("No energy left! GAME OVER!")
        exitProcess(0)
    }
    println("Lost some energy! Current energy is: $playerEnergy")

}