package org.launchcode.attendtrac.Models;

import com.sun.org.glassfish.gmbal.NameValue;

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
    @Size(min = 1, max = 15, message = "Meeting title must not be empty")
    private String title;

    @NotNull
    @Size(min = 1, max = 10, message = "Date must not be empty")
    private Date date;

    public Meeting(int id, String title, Date date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public Meeting(){}

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}


