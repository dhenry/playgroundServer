package com.hackathon.playground.jaxrs.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Dave on 6/12/2014.
 */
public class PlayDate {
    private String id;
    private String location;
    private String description;
    private String organiser;
    private Date startTime;
    private Date endTime;
    private Double latitude;
    private Double longitude;
    private List<String> attendees;

    public PlayDate() {
        this.id = UUID.randomUUID().toString();
        this.attendees = new ArrayList<String>();
    }

    public PlayDate(String location, String description, String organiser, Date startTime, Date endTime, Double latitude, Double longitude) {
        this.id = UUID.randomUUID().toString();
        this.location = location;
        this.description = description;
        this.organiser = organiser;
        this.startTime = startTime;
        this.endTime = endTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.attendees = new ArrayList<String>();
        this.attendees.add(organiser);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<String> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<String> attendees) {
        this.attendees = attendees;
    }

    public void addAttendee(String attendee) {
        if (getAttendeeIndex(attendee) == -1) {
            this.attendees.add(attendee);
        }
    }

    public void removeAttendee(String attendee) {
        int attendeeIndex = getAttendeeIndex(attendee);
        if (attendeeIndex != -1) {
            this.attendees.remove(attendeeIndex);
        }
    }

    private int getAttendeeIndex(String attendee) {
        int index = -1;
        for (int i = 0; i < this.attendees.size(); i++) {
            if (this.attendees.get(i).equals(attendee)) {
                return i;
            }
        }
        return index;
    }

    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

    @Override
    public String toString() {
        return "PlayDate{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", organiser='" + organiser + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", attendees=" + attendees +
                '}';
    }
}