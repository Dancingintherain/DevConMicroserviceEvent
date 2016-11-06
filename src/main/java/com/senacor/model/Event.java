package com.senacor.model;

import org.joda.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by saba on 21.10.16.
 */
@Document
public class Event implements Comparable<Event> {

    @Id
    private String id;

    private String name;

    private String place;

    private LocalDate date;



    public Event() {

    }

    //Date myDate = new Date();

    public Event(String name) {
        this.name = name;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {

        return place;
    }

    public String getName() {
        return name;
    }

    public String getId() {

        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Override
    public int compareTo(Event o) {
        return getDate().compareTo(o.getDate());
    }
}
