package com.example.kurs.stage;

import com.example.kurs.Reminder;
import com.example.kurs.ReminderCreateController;
import com.example.kurs.entity.Remind;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;

public class Stages {
    public void openReminder(Button button, List<Remind> us) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();

        Stage prmStage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("reminder.fxml"));

        Reminder reminderController = new Reminder(us);
        loader.setController(reminderController);

        Parent root = loader.load();
        prmStage.initStyle(StageStyle.UNDECORATED);
        prmStage.setScene(new Scene(root, 831, 607));
        prmStage.show();

    }
    public void openReminderCreate(Button button, List<Remind> us) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        Stage prmStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("reminder_create.fxml"));
        ReminderCreateController reminderCreateController = new ReminderCreateController(us);
        loader.setController(reminderCreateController);
        Parent root = loader.load();
        prmStage.initStyle(StageStyle.UNDECORATED);
        prmStage.setScene(new Scene(root, 468, 334));
        prmStage.show();

    }
    public void closeStage(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();

    }
}
