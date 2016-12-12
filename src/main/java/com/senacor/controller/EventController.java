package com.senacor.controller;

import com.senacor.model.Event;
import com.senacor.model.Speech;
import com.senacor.service.EventService;
import com.senacor.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by saba on 21.10.16.
 */

@RestController
@RequestMapping("/event")
public class EventController {


    private final EventService eventService;
    private final AuthenticationService authenticationService;

    @Autowired
    public EventController(EventService eventService, AuthenticationService authenticationService) {
        this.eventService = eventService;
        this.authenticationService = authenticationService;
    }



    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Event> listAllEvents() {
        return eventService.listAllEvents();
    }


    @RequestMapping(value="/currentEvent", method = RequestMethod.GET)
    public ResponseEntity<Event> getCurrentEvent(@RequestHeader ("Authorization") String tokenId) {
        System.out.println("in event controller" + tokenId);
        System.out.println(authenticationService.isAuthenticatedUser(tokenId));
        if (authenticationService.isAuthenticatedUser(tokenId)) {
            Event event = eventService.getCurrentEvent();
            System.out.println(event.getName());
            return new ResponseEntity<>(eventService.getCurrentEvent(), HttpStatus.OK);

        }else{
            return new ResponseEntity<>(eventService.getCurrentEvent(), HttpStatus.UNAUTHORIZED);

        }


    }

    @RequestMapping(value = "/{eventID}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable("eventID") String eventID){
        Event event = eventService.getEvent(eventID);
        System.out.println(event.getEventId());
        return event;
    }

    @RequestMapping(value = "/{eventID}/speeches", method = RequestMethod.GET)
    public List<Speech> getSpeechesForEvent(@PathVariable("eventID") String eventID) {
        return eventService.getAllSpeechesForEvent(eventID);
    }

    @RequestMapping(value = "/{eventID}/speeches/{speechID}", method = RequestMethod.GET)
    public Speech getSpeech(@PathVariable("eventID") String eventID, @PathVariable("speechID")String speechID){
        return eventService.getSpeech(eventID, speechID);
    }

    @RequestMapping(value = "/{eventID}/attendees/{userId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addAttendeeToEvent(@PathVariable("eventID") String eventID, @PathVariable("userId")String userId){
        return eventService.updateAttendeesList(eventID, userId);
    }

    //Speeches anlegen - insertSort beim Post/Put durchführen - comparable Interface bei Speeches wegfallen lassen

/*    //Create Event Object with parameters with http-POST Request
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createEvent(@RequestBody Event event) {
        Event createdEvent = new Event();
        createdEvent.setName(event.getName());#
        createdEvent.setEventId(UUID.randomUUID().toString());
        createdEvent.setPlace(event.getPlace());
        //createdEvent.setDate();
        eventRepository.save(createdEvent);
    }*/
/*    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEvent(@PathVariable("id") String id, @RequestBody Event event) {
        Event existingEvent = eventRepository.findOne(id);
        existingEvent.setName(event.getName());
        existingEvent.setPlace(event.getPlace());
       // existingEvent.setDate(event.getDate());
        eventRepository.save(existingEvent);
    }
    */

    @RequestMapping(value = "/{eventId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable("eventId") String eventId) {
        eventService.deleteEvent(eventId);
    }

}
