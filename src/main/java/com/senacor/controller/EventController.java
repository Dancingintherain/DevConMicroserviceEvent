package com.senacor.controller;

import com.senacor.model.Event;
import com.senacor.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by saba on 21.10.16.
 */

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;


    @RequestMapping(value="/currentEvent", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Event> getCurrentEvent (){
        return new ResponseEntity<>(eventService.getCurrentEvent(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Event> getEvent(@PathVariable("id") UUID id){
        return new ResponseEntity<>(eventService.getEvent(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Event> listAllEvents() {
        return eventService.listAllEvents();
    }


    //Create Event Object with parameters with http-POST Request
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {

        Event createdEvent = new Event();
        createdEvent.setName(event.getName());
        createdEvent.setPlace(event.getPlace());
        createdEvent.setDate(event.getDate());
        return new ResponseEntity<Event>(eventService.createEvent(createdEvent), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Event> updateEvent(@PathVariable("id") UUID id, @RequestBody Event event) {
        Event existingEvent = eventService.getEvent(id);
        existingEvent.setName(event.getName());
        existingEvent.setPlace(event.getPlace());
        existingEvent.setDate(event.getDate());
        return new ResponseEntity<Event>(eventService.createEvent(existingEvent), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE) //headers = "Accept=application/json"
    public void deleteEvent(@PathVariable("id") UUID id) {
        eventService.deleteEvent(id);
    }

}
