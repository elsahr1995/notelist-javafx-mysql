package controllers;

import Bibikov.MyApplication;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.Note;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class AddWindowController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setValue(LocalDate.now());
    }

    @FXML
    Button confirmButton;
    @FXML
    TextField descriptionTextField;
    @FXML
    DatePicker datePicker;


    @FXML
    private void confirmEvent(Event e) {

        String text = descriptionTextField.getText();
        LocalDate value = datePicker.getValue();
        Note note = Note.builder()
                .description(text)
                .date(value)
                .build();

        MyApplication.noteDao.add(note);
        Controller.value.add(note);

        Controller.stage.close();

        HashMap<Long, Long> longToLong = new HashMap<>();
    }


    private void refresh() {
        datePicker.setValue(LocalDate.now());
        descriptionTextField.setText(null);
    }
}
