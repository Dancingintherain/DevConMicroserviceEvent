package com.senacor.model;

import com.mongodb.util.JSONParseException;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.Duration;
import java.time.LocalTime;



@Document
public class Speech implements Comparable<Speech>{
    @Id
    private String id;
    private String speechTitle;
    private LocalTime startTime;
 //   private Duration duration;
    private String speechRoom;
    private String speaker;
    private String speakerInfo;
    private String speechSummary;
    private String eventId;


    /*
    Objekte werden dann von Werten wie folgt gebildet:LocalDate.of(2012, Month.DECEMBER, 12); // from values
     */
    public Speech(String eventId){
        this.eventId = eventId;
    }

    public Speech() {

    }

/*    public Speech(JsonObject object) {
        try{
            this.id = object.getString("id");
            this.speechTitle = object.getString("speechTitle");
            this.startTime = object.getString("startTime");
            this.duration = object.getString("duration");
            this.speechRoom = object.getString("speechRoom");
            this.speaker = object.getString("speaker");
            this.speechSummary = object.getString("speechSummary");
            this.eventId = object.getString("eventId");
        }catch(JSONParseException e){
            e.printStackTrace();
        }
    }*/

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getSpeechTitle() {
        return speechTitle;
    }

    public void setSpeechTitle(String speechTitle) {
        this.speechTitle = speechTitle;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public String getSpeechRoom() {
        return speechRoom;
    }

    public void setSpeechRoom(String speechRoom) {
        this.speechRoom = speechRoom;

    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getSpeakerInfo() {
        return speakerInfo;
    }

    public void setSpeakerInfo(String speakerInfo) {
        this.speakerInfo = speakerInfo;
    }

    public String getSpeechSummary() {
        return speechSummary;
    }

    public void setSpeechSummary(String speechSummary) {
        this.speechSummary = speechSummary;
    }

/*    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }*/

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Override
    public int compareTo(Speech o) {
        return getStartTime().compareTo(o.getStartTime());
    }
}
