package org.launchcode.attendtrac.Controllers;
import org.launchcode.attendtrac.Models.Attendee;
import org.launchcode.attendtrac.Models.Forms.AddMeetingAttendee;
import org.launchcode.attendtrac.Models.Meeting;
import org.launchcode.attendtrac.Models.data.AttendeeDao;
import org.launchcode.attendtrac.Models.data.MeetingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingDao meetingDao;

    @Autowired
    private AttendeeDao attendeeDao;

    @RequestMapping(value = "index")
    public String index(Model model) {
        model.addAttribute("title", "Board Meetings");
        model.addAttribute("meetings", meetingDao.findAll());

        return "meeting/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddMeetingForm(Model model) {
        model.addAttribute("title", "Enter New Meeting:");
        model.addAttribute(new Meeting());
        return "meeting/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddMeetingForm(Model model, @ModelAttribute @Valid Meeting meeting,
                                        Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Meeting");
            return "meeting/add";
        }

        meetingDao.save(meeting);
        return "redirect:attendance/" + meeting.getId();

    }

    @RequestMapping(value = "attendance/{meetingId}", method = RequestMethod.GET)
    public String addMeetingAttendee(Model model, @PathVariable int meetingId) {

        Meeting meeting = meetingDao.findOne(meetingId);

        AddMeetingAttendee form = new AddMeetingAttendee(
                attendeeDao.findAll(), meeting);

        model.addAttribute("title", "Record Attendees");
        model.addAttribute("form", form);
        return "meeting/attendance";
    }

    @RequestMapping(value = "attendance", method = RequestMethod.POST)
    public String addMeetingAttendee(Model model, @ModelAttribute @Valid AddMeetingAttendee form, Errors errors){

        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "menu/attendance";
        }

        Attendee theAttendee = attendeeDao.findOne(form.getAttendeeId());
        Meeting theMeeting = meetingDao.findOne(form.getMeetingId());
        theMeeting.addMeetingAttendee(theAttendee);

        meetingDao.save(theMeeting);
        return "redirect:/meeting/index";

}
    @RequestMapping(value = "view/{meetingId}", method = RequestMethod.GET)
    public String viewMeeting(Model model, @PathVariable int meetingId) {

        Meeting meeting = meetingDao.findOne(meetingId);
        model.addAttribute("attendees", attendeeDao.findAll());

        model.addAttribute("title", meeting.getDate());
        model.addAttribute("meetingId", meeting.getId());

        return "meeting/{view}";
    }
}