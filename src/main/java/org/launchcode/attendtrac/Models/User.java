package org.launchcode.attendtrac.Models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Owner on 11/25/17
 */
public class User {

    @NotNull
    @Size(min=6, max=10, message = "Username is required")
    private String username;

    @NotNull
    @Size(min=6, message = "Password is required")
    private String password;

    @Email
    private String email;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

