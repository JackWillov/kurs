package com.example.kurs.entity;

import java.util.Date;

public class Remind {

    String value;
    String name;
    Date date;


    public Remind(String value, String name, Date date) {

        this.value = value;
        this.name = name;
        this.date = date;
    }
    public Remind() {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
