package com.blueyonder.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/bydb";
    public static Connection getConnection()
    {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(URL,"postgres","postgres");


        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
