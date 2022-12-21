package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    public Connection Connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sessia1";
            String username = "root";
            String password = "Yfcnzmasha1*";

            Connection con = DriverManager.getConnection(url, username, password);
            return con;

        } catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

