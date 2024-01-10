package com.example.kurs;

import com.example.kurs.entity.Remind;
import com.example.kurs.stage.Stages;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HelloController {
    public LocalDate localDate;
    List<Remind> remind = new ArrayList<>();
    Stages stages = new Stages();
    @FXML
    private Label welcomeText;

    @FXML
    private Button hellobut;
    @FXML
    protected void onHelloButtonClick() throws IOException {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        this.localDate = localDate.now();
        remind.add(new Remind("example value","example name",  Date.from(localDate.atStartOfDay(defaultZoneId).toInstant())));
        stages.openReminder(hellobut, remind);
    }
}