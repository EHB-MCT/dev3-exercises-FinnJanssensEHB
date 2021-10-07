fun main() {
    var scoreUser = 0
    while (true) {
        scoreUser += getWinner(getUserInput(), getComputerChoice())
        println("SCORE: $scoreUser")
    }
}

fun getUserInput(): String? {
    println("Type rock, paper, scissors, spock or lizard")
    val choice = readLine()
    if (choice == "rock" || choice == "paper" || choice == "scissors" || choice == "spock" || choice == "lizard") {
        return choice
    } else {
        println("Input not allowed")
        return null
    }
}

fun getWinner(userInput: String?, computerInput: String?): Int {
    if (userInput == computerInput) {
        println("Tie!")
        return 0
    } else if (userInput == "rock") {
        if (computerInput == "paper" || computerInput == "spock") {
            println("You lose!")
            return 0
        } else {
            println("You win!")
            return 1
        }
    } else if (userInput == "paper") {
        if (computerInput == "scissors"  || computerInput == "lizard") {
            println("You lose!")
            return 0
        } else {
            println("You win!")
            return 1
        }
    } else if (userInput == "scissors") {
        if (computerInput == "rock" || computerInput == "spock") {
            println("You lose!")
            return 0
        } else {
            println("You win!")
            return 1
        }
    } else if (userInput == "spock") {
        if (computerInput == "paper" || computerInput == "lizard") {
            println("You lose!")
            return 0
        } else {
            println("You win!")
            return 1
        }
    } else if (userInput == "lizard") {
        if (computerInput == "scissors"  || computerInput == "rock") {
            println("You lose!")
            return 0
        } else {
            println("You win!")
            return 1
        }
    } else {
        return 0
    }
}

fun getComputerChoice(): String? {
    val options = arrayOf("rock", "paper", "scissors", "spock", "lizard")
    val computerChoice = options.random()
    println("Computer chose $computerChoice")
    return computerChoice
}