package com.rest.client.domain;

import java.time.LocalDateTime;

/**
 *
 * @author Marko Popovic
 */
public class Event {
    private String id;
    private String name;
    private LocalDateTime dateTime;
    private String link;
    private String description;
    private String venueName;
    private String venueStreet;
    private String groupName;

    public Event(String id, String name, LocalDateTime dateTime, String link, String description, String venueName, String venueStreet, String groupName) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.link = link;
        this.description = description;
        this.venueName = venueName;
        this.venueStreet = venueStreet;
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueStreet() {
        return venueStreet;
    }

    public void setVenueStreet(String venueStreet) {
        this.venueStreet = venueStreet;
    }
    
    
}
