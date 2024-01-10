package com.example.kurs;

import com.example.kurs.entity.Remind;
import com.example.kurs.stage.Stages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class ReminderCreateController {
    public LocalDate localDate;
    Stages pages = new Stages();
    public List<Remind> reminderList;
    Remind remind;

    @FXML
    private TextField GetValue;
    @FXML
    private Label errorMessage;
    @FXML
    private Button cancel;
    @FXML
    private Button exitButton;
    @FXML
    private DatePicker getDate;
    @FXML
    private TextField getName;
    @FXML
    private Button save;

    public ReminderCreateController(List<Remind> remind) {
        this.reminderList = remind;

    }

    public ReminderCreateController(Remind remind) {
        this.remind = remind;

    }

    @FXML
    void cancelBut(ActionEvent event) {
        pages.closeStage(cancel);
    }

    @FXML
    void exit(ActionEvent event) {
        pages.closeStage(cancel);
    }

    @FXML
    void saveBut(ActionEvent event) throws IOException {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        String value = GetValue.getText();
        String name = getName.getText();
        localDate = getDate.getValue();
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        if (getName.getText().isBlank() == true || GetValue.getText().isBlank() == true) {
            errorMessage.setText("Хибні данні");
        } else {
            reminderList.add(new Remind(value , name, date));
          }
        pages.openReminder(save,reminderList);
        pages.closeStage(save);
    }

    @FXML
    public void initialize() {
        localDate = localDate.now();
    }
}

