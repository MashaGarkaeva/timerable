package sample;


import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection()                                                    //метод подключения к базе данных (записывать В
            throws ClassNotFoundException, SQLException {                                  // нее, что-то считывать С нее)
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }
    public ResultSet getUser(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_LOGIN + "=? AND " + Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            prst.setString(1, user.getEmail());
            prst.setString(2, user.getPassword());

            resSet = prst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

}
