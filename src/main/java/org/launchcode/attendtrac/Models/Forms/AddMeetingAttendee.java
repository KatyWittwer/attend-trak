package org.launchcode.attendtrac.Models.Forms;

import org.launchcode.attendtrac.Models.Attendee;
import org.launchcode.attendtrac.Models.Meeting;

import javax.validation.constraints.NotNull;

public class AddMeetingAttendee {
    @NotNull
    private int meetingId;

    @NotNull
    private int meetingDate;

    @NotNull
    private int attendeeId;

    @NotNull
    private int attendeeName;

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

    public Iterable<Attendee> getAttendees() {
        return attendees;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public int getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(int meetingDate) {
        this.meetingDate = meetingDate;
    }

    public int getAttendeeName() {
        return attendeeName;
    }

    public void setAttendeeName(int attendeeName) {
        this.attendeeName = attendeeName;
    }
}