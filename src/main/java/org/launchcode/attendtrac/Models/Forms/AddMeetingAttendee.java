package org.launchcode.attendtrac.Models.Forms;

import org.launchcode.attendtrac.Models.Attendee;
import org.launchcode.attendtrac.Models.Meeting;

import javax.validation.constraints.NotNull;

public class AddMeetingAttendee {


    @NotNull
    private int meetingId;

    @NotNull
    private int attendeeId;

    private Iterable<Attendee> attendees;

    private Meeting meeting;

    public AddMeetingAttendee() {
    }

    public AddMeetingAttendee(Iterable<Attendee> attendees, Meeting meeting) {
        this.attendees = attendees;
        this.meeting = meeting;

    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public int getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
    }
}