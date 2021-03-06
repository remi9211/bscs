package com.library.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private static Connection con;

    public static Connection getConnectionDB() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcURL = "jdbc:mysql://" + DBSettings.ip + ":" + DBSettings.port + "/" + DBSettings.db;
            con = DriverManager.getConnection(jdbcURL, DBSettings.userName, DBSettings.password);
            if(con != null){
                System.out.println(DBSettings.db+" Connection Successfull");
            }

        } catch (Exception ex) {
            System.out.println("Message:" + ex.getMessage());
        }
        return con;

    }

    public static void closeConnection(Connection con){
        try{
            con.close();
        }catch(Exception ex)  {
            ex.printStackTrace();
        }
    }
}
