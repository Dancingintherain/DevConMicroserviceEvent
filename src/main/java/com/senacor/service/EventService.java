package com.senacor.service;

import com.senacor.model.Event;
import com.senacor.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Created by saba on 06.11.16.
 */
@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public Event getEvent(UUID uuid) {
        return eventRepository.findOne(uuid);
    }

    public Event getCurrentEvent() {
        List<Event> events = eventRepository.findAll();
        Collections.sort(events);
        return events.get(0);
    }


    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }


    public void deleteEvent(UUID id) {
        eventRepository.delete(id);
    }

    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }

    public Iterable<Event> listAllEvents() {
        return eventRepository.findAll();
    }

}
