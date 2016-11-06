package com.senacor.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;


public class Speech implements Comparable<Speech>{

    @Id
    private String id;
    private String speechTitle;
    private LocalTime startTime;
    private LocalTime endTime;
    private String speechRoom;
    private String speaker;
    private String speakerInfo;
    private String speechSummary;


    /*
    Objekte werden dann von Werten wie folgt gebildet:LocalDate.of(2012, Month.DECEMBER, 12); // from values
     */


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

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
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


    @Override
    public int compareTo(Speech o) {
        return getStartTime().compareTo(o.getStartTime());
    }
}
