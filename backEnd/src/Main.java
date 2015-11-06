import java.sql.*;

/**
 * Created by Agronis on 11/5/15.
 */
public class Main {

    public static void createTables(Connection con) throws SQLException {
        Statement stm = con.createStatement();
        stm.execute("CREATE TABLE IF NOT EXISTS national_crime(id IDENTITY, year INT, population INT, violent_crime INT, murder INT" +
                "rape INT, robbery INT, assault INT)");
        stm.execute("CREATE TABLE IF NOT EXISTS state_crime (id IDENTITY, state VARCHAR, abbrev VARCHAR, year INT, population INT," +
                "crime_total INT, murder INT, manslaughter INT, rape INT, robbery INT, assault INT)");
    }

    public static void insertNational(Connection con, NationalCrime c) throws SQLException {
        PreparedStatement stm = con.prepareStatement("INSERT INTO national_crime VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)");
        stm.setInt(1, c.year);
        stm.setInt(2, c.population);
        stm.setInt(3, c.violentCrime);
        stm.setInt(4, c.murder);
        stm.setInt(5, c.rape);
        stm.setInt(6, c.robbery);
        stm.setInt(7, c.assault);
    }

    public static void insertCrime(Connection con, StateCrime c) throws SQLException {
        PreparedStatement stm = con.prepareStatement("INSERT INTO state_crime VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stm.setString(1, c.state);
        stm.setString(2, c.abbrev);
        stm.setInt(3, c.year);
        stm.setInt(4, c.population);
        stm.setInt(5, c.crimeTotal);
        stm.setInt(6, c.murder);
        stm.setInt(7, c.manslaughter);
        stm.setInt(8, c.rape);
        stm.setInt(9, c.robbery);
        stm.setInt(10, c.assault);
        stm.execute();

    }
    public static StateCrime selectState(Connection conn, String state) throws SQLException {
        StateCrime stateCrime = null;
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM state_crime WHERE state = ?");
        stm.setString(1, state);
        ResultSet results = stm.executeQuery();
        if(results.next()){
            stateCrime = new StateCrime();
            stateCrime.abbrev = results.getString("abbrev");
            stateCrime.year = results.getInt("year");
            stateCrime.population = results.getInt("population");
            stateCrime.crimeTotal = results.getInt("crime_total");
            stateCrime.murder = results.getInt("murder");
            stateCrime.manslaughter = results.getInt("manslaughter");
            stateCrime.rape = results.getInt("rape");
            stateCrime.robbery = results.getInt("robbery");
            stateCrime.assault = results.getInt("assault");
        }
        return stateCrime;
    }

    public static StateCrime selectAbbrev(Connection conn, String abbrev) throws SQLException {
        StateCrime stateCrime = null;
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM state_crime WHERE abbrev = ?");
        stm.setString(1, abbrev);
        ResultSet results = stm.executeQuery();
        if(results.next()){
            stateCrime = new StateCrime();
            stateCrime.state = results.getString("state");
            stateCrime.year = results.getInt("year");
            stateCrime.population = results.getInt("population");
            stateCrime.crimeTotal = results.getInt("crime_total");
            stateCrime.murder = results.getInt("murder");
            stateCrime.manslaughter = results.getInt("manslaughter");
            stateCrime.rape = results.getInt("rape");
            stateCrime.robbery = results.getInt("robbery");
            stateCrime.assault = results.getInt("assault");
        }
        return stateCrime;
    }

    public static StateCrime selectYear(Connection conn, int year) throws SQLException {
        StateCrime stateCrime = null;
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM state_crime WHERE year = ?");
        stm.setInt(1, year);
        ResultSet results = stm.executeQuery();
        if(results.next()){
            stateCrime = new StateCrime();
            stateCrime.state = results.getString("state");
            stateCrime.abbrev = results.getString("abbrev");
            stateCrime.population = results.getInt("population");
            stateCrime.crimeTotal = results.getInt("crime_total");
            stateCrime.murder = results.getInt("murder");
            stateCrime.manslaughter = results.getInt("manslaughter");
            stateCrime.rape = results.getInt("rape");
            stateCrime.robbery = results.getInt("robbery");
            stateCrime.assault = results.getInt("assault");
        }
        return stateCrime;
    }


    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:h2:./main");
        createTables(con);
    }
}
