package org.launchcode.attendtrac.Models;
import org.springframework.format.annotation.DateTimeFormat;
import sun.security.x509.AttributeNameEnumeration;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Entity
public class Meeting {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private String date;

    @NotNull
    private String type;

    @ManyToMany
    private List<Attendee> attendees;

    public Meeting(){}

    public Meeting(int id, String date, String type) {
        this.id = id;
        this.date = date;
        this.type = type;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void addAttendee(Attendee theAttendee) {
        attendees.add(theAttendee);}

    }