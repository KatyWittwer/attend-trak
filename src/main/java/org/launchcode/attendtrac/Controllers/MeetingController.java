package org.launchcode.attendtrac.Controllers;
import org.launchcode.attendtrac.Models.data.MeetingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingDao meetingDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("meetings", meetingDao.findAll());
        model.addAttribute("title", "All Meetings");

        return "meeting/index";

    }
}

