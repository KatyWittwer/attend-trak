package org.launchcode.attendtrac.Models;

import javafx.util.converter.LocalDateStringConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Meeting {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String date;

    @ManyToMany
    private List<Attendee> attendees;

    public Meeting(int id, String date) {
        this.id = id;
        this.date = date;
    }

    public Meeting(){}

    public void addName(Attendee name) {attendees.add(name);}

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}


