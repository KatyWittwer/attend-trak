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

    @NotNull
    @Size(min = 1, max = 20)
    private String role;

    //other side of many to many relationship with meetings
    @ManyToMany(mappedBy = "attendees")
    private List<Meeting> meetings;

    public Attendee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Attendee() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

