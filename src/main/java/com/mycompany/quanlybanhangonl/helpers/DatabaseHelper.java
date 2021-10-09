
package com.mycompany.quanlybanhangonl.helpers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {
    public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost;database=T2Shop;";
        String dbusername = "sa";
        String password = "123456789";
        Connection con = DriverManager.getConnection(connectionUrl, dbusername, password);
        return con;
    }
}
