package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("firstMenu.fxml"));
        primaryStage.setTitle("Timetable");
        primaryStage.setScene(new Scene(root, 650, 400));
        primaryStage.show();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        launch(args);

//соединение с бд
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/timetable";
        String nameUser = "root";
        String passwordUser = "Yfcnzmasha1*";

        Connection connection = DriverManager.getConnection(url, nameUser, passwordUser);
        if (connection != null){
            System.out.println("The database is connected");
        }
        else {
            System.out.println("The database is not connected");
        }
    }
}
