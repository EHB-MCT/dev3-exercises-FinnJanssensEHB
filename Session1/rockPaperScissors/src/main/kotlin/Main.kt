fun main() {
    getWinner(getUserInput(), getComputerChoice())
}

fun getUserInput(): String? {
    println("Type rock, paper or scissors")
    val choice = readLine()
    return choice
}

fun getWinner(userInput: String?, computerInput: String?) {
    if (userInput == computerInput) {
        println("Tie!")
    } else if (userInput == "rock") {
        if (computerInput == "paper") {
            println("You lose!")
        } else {
            println("You win!")
        }
    } else if (userInput == "paper") {
        if (computerInput == "scissors") {
            println("You lose!")
        } else {
            println("You win!")
        }
    } else if (userInput == "scissors") {
        if (computerInput == "paper") {
            println("You lose!")
        } else {
            println("You win!")
        }
    }
}

fun getComputerChoice(): String? {
    val options = arrayOf("rock", "paper", "scissors")
    val computerChoice = options.random()
    println("Computer chose $computerChoice")
    return computerChoice
}