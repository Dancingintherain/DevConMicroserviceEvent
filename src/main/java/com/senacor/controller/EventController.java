package com.senacor.controller;

import com.senacor.model.Event;
import com.senacor.model.Speech;
import com.senacor.model.User;
import com.senacor.service.EventService;
import com.senacor.service.UserService;
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

    @Autowired
    public EventController(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    private final UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Event> listAllEvents() {
        return eventService.listAllEvents();
    }

    //kommt in den User-Microservice
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "password", required=false) String password){
        System.out.println(username + password);
        User user = userService.authenticateUser(new User(username, password));
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(user, HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value="/currentEvent", method = RequestMethod.GET)
    //@ResponseStatus(HttpStatus.OK)
    public Event getCurrentEvent(){
        return eventService.getCurrentEvent();
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
