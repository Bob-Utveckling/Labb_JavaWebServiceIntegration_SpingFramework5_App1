//this Java file written by help of Martin's code
// that were in 2 packages to separate db and customer models
// see https://github.com/kappsegla/DIExample for the original code
package se.iths.course.webinteg.bob.labb2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//public class SqLiteStorage implements Storage {
public class SqLiteStorage {
    static String path = "jdbc:sqlite:Anmalan.db";

    public static void SqLiteStorage() {
        try {
            Connection sqliteConnection = DriverManager.getConnection(path);

            //Skapa tabell för Anmalan om den inte finns
            String sql_create_tabel = "CREATE TABLE IF NOT EXISTS Anmalan(" +
                    "ID integer PRIMARY KEY," +
                    "Name TEXT, " +
                    "Fardighet1 TEXT, " +
                    "Fardighet2 TEXT, " +
                    "Fardighet3 TEXT, " +
                    "Fardighet4 TEXT, " +
                    "Fardighet5 TEXT, " +
                    "Forslag TEXT" +
                    ");";

            Statement stmt = sqliteConnection.createStatement();
            stmt.execute(sql_create_tabel);
            stmt.close();
            sqliteConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addAnmalan(Anmalan anmalan) {
        try {
            Connection sqliteConnection = DriverManager.getConnection(path);

            //Lägg till en kund i tabellen Customers
            String sql_insert_anmalan = "INSERT INTO Anmalan(name, fardighet1, fardighet2, " +
                                            "fardighet3, fardighet4, fardighet5, forslag)" +
                    " VALUES('"+ anmalan.getName() + "' ," +
                        "'" + anmalan.getFardighet1() + "', " +
                        "'" + anmalan.getFardighet2() + "', " +
                        "'" + anmalan.getFardighet3() + "', " +
                        "'" + anmalan.getFardighet4() + "', " +
                        "'" + anmalan.getFardighet5() + "', " +
                        "'" + anmalan.getForslag() + "'" +
                    ");";

            System.out.println(sql_insert_anmalan);

            Statement stmt = sqliteConnection.createStatement();
            stmt.execute(sql_insert_anmalan);
            stmt.close();
            sqliteConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){

    }

    public static List<Anmalan> getAll() {
        List<Anmalan> allaAnmalan = new CopyOnWriteArrayList<>();

        try {
            Connection sqliteConnection = DriverManager.getConnection(path);

            String sql_select_anmalan = "SELECT * FROM Anmalan";

            Statement stmt = sqliteConnection.createStatement();

            ResultSet rs = stmt.executeQuery(sql_select_anmalan);


            while (rs.next()) {
                allaAnmalan.add( new Anmalan(
                                    rs.getString("name"),
                                    rs.getString("fardighet1"),
                                    rs.getString("fardighet2"),
                                    rs.getString("fardighet3"),
                                    rs.getString("fardighet4"),
                                    rs.getString("fardighet5"),
                                    rs.getString("forslag")
                                )
                        );
            }
            rs.close();
            stmt.close();
            sqliteConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allaAnmalan;
    }

}