package com.senacor;

import com.senacor.model.Event;
import com.senacor.model.Speech;
import com.senacor.service.EventService;
import org.joda.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class DevConMicroserviceEventApplication implements CommandLineRunner{

    @Autowired
    EventService eventService;

	public static void main(String[] args) {

		SpringApplication.run(DevConMicroserviceEventApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {

        eventService.deleteAllEvents();

        for (int i = 1; i <= 5; i++){
            Event event = new Event();
            event.setName("Conference No." + i);
            event.setPlace("Example Street No. " + i);
            event.setDate(new LocalDate(2016, 9, i));
            eventService.createEvent(event);

            for (int j = 1; j <4; j++) {
                Speech speech = new Speech(event.getId());
                speech.setSpeaker("Speaker" + j);
                speech.setStartTime(LocalTime.of(j, 00));
             //   speech.setDuration(Duration.ofMinutes(90));
                speech.setSpeechRoom("room: " + j);
                eventService.createSpeech(speech);
            }


        }

        for (Event event : eventService.listAllEvents()) {
            System.out.println(event.getName());
            System.out.println(event.getDate());
            System.out.println(event.getPlace());
            System.out.println(event.getId());


          /* for (Speech speech : eventService.getSpeechesForEvent(event.getId())) {
                System.out.println(speech.getSpeaker());
                System.out.println(speech.getStartTime());
              /*//* System.out.println(speech.getDuration()); *//**//*
                System.out.println(speech.getSpeechRoom());
            }*/
        }

    }
}
