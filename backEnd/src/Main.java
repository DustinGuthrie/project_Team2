import java.sql.*;

/**
 * Created by Agronis on 11/5/15.
 */
public class Main {

    public static void createTables(Connection con) throws SQLException {
        Statement stm = con.createStatement();
        stm.execute("CREATE TABLE IF NOT EXISTS entries (id IDENTITY, state VARCHAR, year INT, population INT," +
                "crime_total INT, murder INT, manslaughter INT, rape INT, robbery INT, assault INT)");
    }

    public static void insertCrime(Connection con, Crime c) throws SQLException {

        PreparedStatement stm = con.prepareStatement("INSERT INTO entries VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stm.setString(1, c.state);
        stm.setInt(2, c.year);
        stm.setInt(3, c.population);
        stm.setInt(4, c.crimeTotal);
        stm.setInt(5, c.murder);
        stm.setInt(6, c.manslaughter);
        stm.setInt(7, c.rape);
        stm.setInt(8, c.robbery);
        stm.setInt(9, c.assault);
        stm.execute();

    }


    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:h2:./main");
        createTables(con);
    }
}
