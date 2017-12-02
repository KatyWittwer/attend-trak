package org.launchcode.attendtrac.Models;

import javafx.util.converter.LocalDateStringConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Entity
public class Meeting {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1, max = 15, message = "Meeting type must not be empty")
    private String type;

    @NotNull
    private String date;

    @ManyToMany
    private List<Attendee> attendees;

    public Meeting(int id, String type, String date) {
        this.id = id;
        this.type = type;
        this.date = date;
    }

    public Meeting(){}

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}


