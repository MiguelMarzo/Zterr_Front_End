package org.zterr.frontend.android;

/**
 * Created by Miguel on 13/10/2016.
 */
public class Event {

    private Integer id;
    private String name;
    private String description;
    private String event_date;
    private Integer latitude;
    private Integer longitude;

    public Event(Integer id) {
        this.id = id;
    }

    public Event(){

    }

    public Event(Integer id, String name, String description, String event_date, Integer latitude, Integer longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.event_date = event_date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }



}
