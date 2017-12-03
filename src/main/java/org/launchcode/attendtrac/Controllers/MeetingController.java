package org.launchcode.attendtrac.Controllers;
import org.launchcode.attendtrac.Models.Attendee;
import org.launchcode.attendtrac.Models.Meeting;
import org.launchcode.attendtrac.Models.data.AttendeeDao;
import org.launchcode.attendtrac.Models.data.MeetingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingDao meetingDao;

    @Autowired
    private AttendeeDao attendeeDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Board Meetings");
        model.addAttribute("meetings", meetingDao.findAll());

        return "meeting/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddMeetingForm(Model model) {
        model.addAttribute("title", "Enter Meeting Attendance Record");
        model.addAttribute(new Meeting());

        model.addAttribute("attendees", attendeeDao.findAll());

        return "meeting/add";

    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddMeetingForm(@ModelAttribute @Valid Meeting newMeeting,
                                        Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Meeting");
            return "meeting/add";
        }

        meetingDao.save(newMeeting);
        return "redirect/view/";

        }


}

