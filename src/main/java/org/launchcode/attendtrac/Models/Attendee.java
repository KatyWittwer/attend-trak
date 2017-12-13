package org.launchcode.attendtrac.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Attendee {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1, max = 30)
    private String name;

    private boolean present;

    private boolean absent;

    private boolean excused;

    private boolean viaphone;


    @NotNull
    @Size(min = 1, max = 20)
    private String role;

    //other side of many to many relationship with meetings
    @ManyToMany(mappedBy = "attendees")
    private List<Meeting> meetings;

    public Attendee(String name) {
        this.name = name;
    }

    public Attendee() {
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public boolean isAbsent() {
        return absent;
    }

    public void setAbsent(boolean absent) {
        this.absent = absent;
    }
    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public boolean isExcused() {
        return excused;
    }

    public void setExcused(boolean excused) {
        this.excused = excused;
    }

    public boolean isViaphone() {
        return viaphone;
    }

    public void setViaphone(boolean viaphone) {
        this.viaphone = viaphone;
    }
}