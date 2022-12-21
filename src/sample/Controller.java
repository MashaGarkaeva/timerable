package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginbtn;
    @FXML
    private Button exitbtn;
    @FXML
    private Label getError;
    @FXML
    private void initialize() {
        loginbtn.setOnAction(event -> {
            String email = login.getText().trim();
            String userPassword = password.getText().trim();

            if (!email.equals("") && !userPassword.equals("")) {
                loginUser(email, userPassword);
            }else{
                getError.setText("Не все поля заполнены");}

        });
    }
    private void loginUser(String email, String userPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User(email, password);
        user.setEmail(email);
        user.setPassword(userPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter=0;
        try {
            while (result.next()){
                counter++;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        String role = "";
        if(email.equals("j.doe@amonic.com") && (userPassword.equals("123"))){
            role = "Администратор";
        } else {
            role = "Пользователь";
        }
        if ((counter == 1) && (role.equals("Администратор"))) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ghjk.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
        if ((counter>=1) && (role.equals("Пользователь"))) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("fghjk.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
        if (counter==0) {
            getError.setText("Неверные данные, либо такого пользователя нет в системе");
        }
        else {
            getError.setText("Успешно");
        }

    }

}