import java.sql.*
import java.util.*

fun main() {
    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance()

    // Prepare credentials
    val credentials = Credentials()
    val connectionProps = Properties()
    connectionProps["user"] = credentials.databaseUser
    connectionProps["password"] = credentials.databasePassword

    // Create the connection: this will allow us to run queries on it later
    val connection =  DriverManager.getConnection(
        "jdbc:" + "mysql" + "://" +
                "dt5.ehb.be" +
                ":" + "3306" + "/" +
                credentials.databaseName,
        connectionProps)
    /*println("Where do you want to go?")
    val search = readLine()
    val statement = connection.prepareStatement(
        "SELECT * \n" +
            "FROM pt_rides\n" +
            "LEFT JOIN pt_trains\n" +
            "ON pt_rides.train_id = pt_trains.id\n" +
            "WHERE arrivalCity = ? LIMIT 3")
    // Replace the var without allowing full queries to be entered
    statement.setString(1, search)
    val result = statement.executeQuery()
    while(result.next()) {
        val type = result.getString("type")
        val id = result.getString("id")
        val departureCity = result.getString("departureCity")
        val arrivalCity = result.getString("arrivalCity")
        val departureTime = result.getString("departureTime")
        val arrivalTime = result.getString("arrivalTime")
        println("$id $type: $departureCity@$departureTime -> $arrivalCity@$arrivalTime")
    }*/
    println("What platform do you want to check?")
    val search = readLine()
    val statement = connection.prepareStatement(
        "SELECT * \n" +
                "FROM pt_rides\n" +
                "LEFT JOIN pt_trains\n" +
                "ON pt_rides.train_id = pt_trains.id\n" +
                "WHERE departurePlatform = ? LIMIT 3")
    // Replace the var without allowing full queries to be entered
    statement.setString(1, search)
    val result = statement.executeQuery()
    while(result.next()) {
        val type = result.getString("type")
        val id = result.getString("id")
        val departureCity = result.getString("departureCity")
        val arrivalCity = result.getString("arrivalCity")
        val departureTime = result.getString("departureTime")
        val arrivalTime = result.getString("arrivalTime")
        println("$id $type: $departureCity@$departureTime -> $arrivalCity@$arrivalTime")
    }

}