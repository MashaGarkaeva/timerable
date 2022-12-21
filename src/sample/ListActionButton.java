package sample;

import javafx.scene.control.TableColumn;

import java.sql.Date;

public class ListActionButton {
    private String data_event;
    private String event;
    private String place;

    public ListActionButton(String data_event, String event, String place){
        this.data_event = data_event;
        this.event = event;
        this.place = place;
    }

    public ListActionButton(TableColumn<ListActionButton, Date> data_event, TableColumn<ListActionButton, String> event, TableColumn<ListActionButton, String> place) {

    }

    public String getData_event(){
        return data_event;
    }
    public void setData_event(String data_event){
        this.data_event = data_event;
    }
    public String getEvent(){
        return event;
    }
    public void setEvent(String event){
        this.event = event;
    }
    public String getPlace(){
        return place;
    }
    public void setPlace(String place){
        this.place = place;
    }
}
