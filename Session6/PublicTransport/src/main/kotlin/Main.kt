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

    val search = "IC"
    val statement = connection.prepareStatement("SELECT * FROM pt_trains WHERE type = ?")
    // Replace the var without allowing full queries to be entered
    statement.setString(1, search)
    val result = statement.executeQuery()
    while(result.next()) {
        println(result.getString("capacity"))
    }
}