package org.launchcode.attendtrac.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Meeting {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1, max = 10, message = "Date must not be empty")
    private Date date;

    @NotNull
    @Size(min = 1, max = 15, message = "Meeting type must not be empty")
    private String type;

    public Meeting(int id, String type, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}


