package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewingForDirector {
    @FXML
    public Button exit;
    @FXML
    public void initialize(){
        exit.setOnAction(event -> {
            exit.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("firstMenu.fxml"));

            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}
