package org.launchcode.attendtrac.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("")
@Controller
public class MainContoller {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Model model, String error, String logout) {
        model.addAttribute("title", "Login");
    }
    @RequestMapping(method = RequestMethod.GET)
    public String submit(Model model, @ModelAttribute ("user"){

            if (error != null)
                model.addAttribute("error", "Your username and password is invalid.");

            if (logout != null)
                model.addAttribute("message", "You have been logged out successfully.");

            return "login";
    }
}