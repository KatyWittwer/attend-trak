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
import java.util.Iterator;

//this is the controller for the index page localhost:8080/meeting/
@Controller
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingDao meetingDao;

    @Autowired
    private AttendeeDao attendeeDao;

    //displays all meetings in the database at /meeting
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Board Meetings");
        //retrieves all records from the database
        model.addAttribute("meetings", meetingDao.findAll());

        return "meeting/index"; }

    //add a new meeting entry display page (calls the thymeleaf template)
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddMeetingForm(Model model) {
        model.addAttribute("title", "Enter New Meeting:");
        model.addAttribute(new Meeting());
        return "meeting/add";
    }

    //this is the post request for the new meeting date and type entered
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String AddMeetingForm(Model model, @ModelAttribute @Valid Meeting meeting,
                                 Errors errors) {

        //if there is no entry or an error with entry, it refreshes pages
        if (errors.hasErrors()) {
            model.addAttribute("title", "Enter New Meeting");
            return "meeting/add";
        }

        //save the meeting record with unique Id to the database if successful
        meetingDao.save(meeting);
        //directs to the page where you add attendance to the unique meeting Id
        return "redirect:add-attendance/" + meeting.getId();
    }

    //load the page with meeting with unique Id to enter attendees
    @RequestMapping(value = "add-attendance/{meetingId}", method = RequestMethod.GET)
    public String addMeetingAttendee(Model model, @PathVariable int meetingId) {

        //recall the meeting by Id from the database and assign it a variable
        Meeting meeting = meetingDao.findOne(meetingId);
        //
        model.addAttribute("title", meeting.getDate());
        model.addAttribute("attendees", meeting.getAttendees());
        model.addAttribute("meetingId", meeting.getId());

        //
        AddMeetingAttendee form = new AddMeetingAttendee(
                attendeeDao.findAll(), meeting);
        //
        model.addAttribute("title", meeting.getDate());
        model.addAttribute("type", meeting.getType());
        model.addAttribute("form", form);

        return "meeting/add-attendance";
    }

    //load the page with meeting with unique Id to enter attendees and save to the database
    @RequestMapping(value = "add-attendance", method = RequestMethod.POST)
    public String addAttendee(Model model, @ModelAttribute @Valid AddMeetingAttendee form, Errors errors) {

        //if there are errors with the enter, reload page
        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "meeting/add-attendance";
        }

        //save the attendee to the meeting (many to many)
        Attendee theAttendee = attendeeDao.findOne(form.getAttendeeId());
        Meeting theMeeting = meetingDao.findOne(form.getMeetingId());
        theMeeting.addAttendee(theAttendee);

        meetingDao.save(theMeeting);

        return "redirect:/meeting/add-attendance/" + theMeeting.getId();
    }
}