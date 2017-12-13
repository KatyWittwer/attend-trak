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
    @DateTimeFormat(pattern = "mm/DD/yyy")
    private String date;

    @ManyToMany
    private List<Attendee> attendees;

    public Meeting(int id, String date) {
        this.id = id;
        this.date = date;
    }

    public Meeting(){}

    public void addAttendance(Attendee attendance) {
        attendees.add(attendance);
    }

    public void addAttendees(Iterable<Attendee> attendees) {
        for (Iterator<Attendee> i = attendees.iterator(); i.hasNext();) {
            Attendee attendee = i.next();
            addAttendance(attendee);
        }
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }
}


