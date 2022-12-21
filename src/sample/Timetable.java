package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Timetable {
    @FXML
    public Button add;
    @FXML
    public Button edit;
    @FXML
    public Button delete;
    @FXML
    public Button exit;
    @FXML
    public TextField dataWhen;
    @FXML
    public TextArea whatWillBe;
    @FXML
    public TableView<ListActionButton> tableTimeTable;
    @FXML
    public TableColumn<ListActionButton, String> data_event;
    @FXML
    public TableColumn<ListActionButton, String> event;
    @FXML
    public TableColumn<ListActionButton, String> place;

    public final ObservableList<ListActionButton> timetableData = FXCollections.observableArrayList();
    public DbConnection dc;
    @FXML
    public TextField whereWillbe;


    @FXML
    void initialize() throws SQLException {
        data_event.setCellValueFactory(new PropertyValueFactory<>("data_event"));
        event.setCellValueFactory(new PropertyValueFactory<>("event"));
        place.setCellValueFactory(new PropertyValueFactory<>("place"));

        tablereTresh();
        add.setOnAction(event1 -> {
            if((!dataWhen.getText().isEmpty() || whatWillBe.getText().isEmpty() || whereWillbe.getText().isEmpty())){
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                    try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/timetable", "root", "Yfcnzmasha1*")){
                        PreparedStatement statement = connection.prepareStatement("INSERT event(data_event, event, place, idevent) VALUES(?,?,?,?)");
                        ResultSet resultSet = statement.executeQuery("SELECT *  FROM timetable.event;");
                        while (resultSet.next()){
                            /*if (resultSet.getString("data_event").equals(dataWhen.getText())
                                    && resultSet.getInt("idevent") == Controller.idevent) {
                                statement = connection.prepareStatement("UPDATE event SET data_event = ?, event = ?, place = ?, WHERE idevent = ?");
                                break;
                            }*/
                        }
                        statement.setString(1, dataWhen.getText());
                        statement.setString(2, whatWillBe.getText());
                        statement.setString(3, whereWillbe.getText());
                       // statement.setInt(4, Controller.idevent);
                        statement.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    System.out.println("Ошибка добавления");
                }
            }
            tablereTresh();
        });
        delete.setOnAction(event1 -> {
            if(!(dataWhen.getText().isEmpty())){
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                    try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable", "root", "Yfcnzmasha1*")){
                        PreparedStatement statement = connection.prepareStatement("DELETE FROM event WHERE idevent = ? and data_event = ?");
                        //statement.setInt(1, Controller.idevent);
                        statement.setString(2, dataWhen.getText());
                        statement.executeUpdate();
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка удаления");
                }
            }
            tablereTresh();
        });

        exit.setOnAction(event -> {//выход из системы
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
        dc = new DbConnection();
        loadDataFromDataBase();
    }

    private void tablereTresh() {
        timetableData.clear();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/timetable", "root", "Yfcnzmasha1*")){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM timetable.event;");
                while (resultSet.next()){
                    /*if(resultSet.getInt("idevent") == idevent){
                        timetableData.add(new ListActionButton(resultSet.getString("data_event"),
                        resultSet.getString("event"), resultSet.getString("place")));
                    }*/
                }
                if (!timetableData.isEmpty()){
                    tableTimeTable.setItems(timetableData);
                }

            }
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException | SQLException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println("Ошибка");
        }
    }

    private void loadDataFromDataBase() throws SQLException {
        Connection conn = dc.Connection();

        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM timetable.event;");

        while (rs.next()){
            String data = rs.getString(1);
            String events = rs.getString(2);
            String place = rs.getString(3);

            timetableData.add(new ListActionButton(data, events, place));
        }
        tableTimeTable.setItems(timetableData);
    }

    public void showDialog(ActionEvent actionEvent) {
    }
}
