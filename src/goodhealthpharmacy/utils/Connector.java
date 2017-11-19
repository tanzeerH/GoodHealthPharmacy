/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodhealthpharmacy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tanzeer
 */
public class Connector {

    private static Connection connection = null;

    public static Connection getInstance() {
        if (connection == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");

                connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tanzeer20082010155");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
