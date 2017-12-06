package org.launchcode.attendtrac.Controllers;

import org.launchcode.attendtrac.Models.Forms.User;
import org.launchcode.attendtrac.Models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title","Register");
        return "user/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String displayAddUserForm(@ModelAttribute @Valid User user, Errors errors,
                                     String verify, Model model) {

        model.addAttribute(new User());
        model.addAttribute("user", user);

        boolean passwordsMatch = true;
        if ((user.getPassword() == null) || verify == null
                || !user.getPassword().equals(verify)) {
            passwordsMatch = false;
            model.addAttribute("verifyError", "Password must match");
        }

        if (passwordsMatch) {
            return "user/index";
        }

        return "user/index";

    }
}
