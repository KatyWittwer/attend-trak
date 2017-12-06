package org.launchcode.attendtrac.Controllers;

import org.launchcode.attendtrac.Models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("")
@Controller
public class MainController {

    @Autowired UserDao userDao;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("title", "Login");
       /* model.addAttribute("users", userDao.findAll());*/

        return "login";

    /*@RequestMapping(method = RequestMethod.GET)
    public String submit(Model model) {

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}*/
    }}