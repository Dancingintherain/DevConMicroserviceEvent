package com.senacor.controller;

import com.senacor.model.Event;
import com.senacor.repository.EventRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import java.util.Optional;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;


/**
 * Created by Berlina on 29.10.16.
 */
public class EventControllerTest2 {

    private EventController createEventService;
    private EventRepository eventRepositoryMock;

    @Before
    public void setUp() {
        eventRepositoryMock = Mockito.mock(EventRepository.class);
        createEventService = new EventController();
    }

    @Test
    public void listAllEvents() throws Exception {

    }

    @Test
    public void getEvent() throws Exception {

    }

    @Test
    public void createEventSuccessfully() throws Exception {
      //  final OngoingStubbing<Event> con1 = when(eventRepositoryMock.findByName(eq("Con1"))).thenReturn(Optional.empty());
      ////  doAnswer(returnsFirstArg()).when(eventRepositoryMock).save(any(Event.class));
        //Event event = createEventService.createEvent("Con1");
     //   assertEquals("Con1", event.getName());
      //  assertNotNull(event.getId());

    }

   // @Test(expected = InvalidEventNameException.class)
/*    public void createEventWithEmptyName() throws Exception {
        Event event = new Event();
        createEventService.createEvent(event);

    }*/

    //@Test(expected = EventNameAlreadyExistsException.class)
/*    public void createClientWithExistingName() throws Exception {
    //    doThrow(new EventNameAlreadyExistsException()).when(eventRepositoryMock).findByName(eq("Con1"));
        Event event = new Event("Con1");
        createEventService.createEvent(event);
    }*/


    @Test
    public void updateEvent() throws Exception {

    }

    @Test
    public void deleteEvent() throws Exception {

    }

}