package com.example.kurs;

import com.example.kurs.entity.Remind;
import com.example.kurs.stage.Stages;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reminder {
    private static ObservableList<Remind> obReminder = FXCollections.observableArrayList();
    public List<Remind> reminderList = new ArrayList<Remind>();
    public LocalDate localDate;
    public Remind remind;
    public List<Remind> tempList;
    Stages stages = new Stages();
    @FXML
    private Button addRemind;
    @FXML
    private Button allDates;
    @FXML
    private TableColumn<Remind, Date> date;
    @FXML
    private Label dateLabel;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button delete;
    @FXML
    private Button exitButton;
    @FXML
    private Button home;
    @FXML
    private TableColumn<Remind, String> name;
    @FXML
    private Button pickDate;
    @FXML
    private TableView<Remind> reminder_table;
    @FXML
    private TableColumn<Remind, String> value;

    public Reminder(List<Remind> reminderList) {
        this.reminderList = reminderList;
    }

    public Reminder(Remind remind) {
        this.remind = remind;
    }

    @FXML
    void addRemindButton(ActionEvent event) throws IOException {
        stages.openReminderCreate(addRemind, reminderList);
        stages.closeStage(addRemind);
    }


    @FXML
    void deleteButton(ActionEvent event) throws IOException {
        TableView.TableViewSelectionModel<Remind> selectionModel = reminder_table.getSelectionModel();
        if (!selectionModel.isEmpty()) {
            reminderList.remove(selectionModel.getFocusedIndex());
            stages.openReminder(delete, reminderList);

        }
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    public void initialize() {
        this.localDate = localDate.now();
        reminder_table.getItems().removeAll(obReminder);
        obReminder.removeAll(obReminder);
        initColumns();
        obReminder.addAll(reminderList);
        reminder_table.getItems().addAll(obReminder);
        tempList = new ArrayList<>();
    }

    public void initColumns() {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        value.setCellValueFactory(new PropertyValueFactory<>("value"));


    }
}

