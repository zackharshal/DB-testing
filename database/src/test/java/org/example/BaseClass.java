package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Unit test for simple App.
 */
public class BaseClass {

    public static Connection con;

    public Connection setUp() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/dbtesting";
            String userName = "root";
            String password = "Harshal*25";
            con = DriverManager.getConnection(url, userName, password);
        }
        catch (SQLException e){
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}
