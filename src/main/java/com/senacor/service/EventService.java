package com.senacor.service;

import com.senacor.model.Event;
import com.senacor.model.Speech;
import com.senacor.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

/**
 * Created by saba on 06.11.16.
 */
@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    final String speechUri = "http://localhost:8081/speech/";
    RestTemplate restTemplate = new RestTemplate();

    public Event getEvent(String id) {
        return eventRepository.findOne(id);
    }

    public Event getCurrentEvent() {
        List<Event> events = eventRepository.findAll();
        Collections.sort(events);
        return events.get(0);
    }


    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }


    public void deleteEvent(String id) {
        eventRepository.delete(id);
    }

    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }

    public Iterable<Event> listAllEvents() {
        return eventRepository.findAll();
    }

    public List <Speech> getSpeechesForEvent(String eventId) {
        return restTemplate.getForObject(speechUri + eventId, List.class);
    }

    public Speech createSpeech(Speech speech) {
        return restTemplate.postForObject(speechUri + "newSpeech", speech, Speech.class);
    }

    public List<Speech> getAllSpeeches() {
        return restTemplate.getForObject(speechUri + "list", List.class);
    }
}
