package controllers;

import Bibikov.MyApplication;
import dao.HibernateNoteDaoImpl;
import dao.NoteDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Note;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        noteList.setItems(value);
    }

    @FXML
    Button addButton;
    @FXML
    ListView<Note> noteList = new ListView<>();

    static ObservableList<Note> value = FXCollections.observableArrayList(MyApplication.noteDao.values());

    public static Stage stage;
    public static Stage mainStage;

    @FXML
    private void addEvent(Event e){
        try {
            Parent sroot = FXMLLoader.load(this.getClass().getClassLoader().getResource("secWindow.fxml"));
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Новая заметка");
            stage.setScene(new Scene(sroot));
            stage.show();
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }

    }

}
