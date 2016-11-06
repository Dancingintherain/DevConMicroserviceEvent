package com.senacor.controller;


import com.senacor.model.Speech;
import com.senacor.repository.EventRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;
import java.util.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by Marynasuprun on 31.10.2016.
 */
public class EventControllerTest0 {

    @InjectMocks
    EventController createEventControllerMock;

    @Mock
    EventRepository eventRepository;

  //  @Mock
 //   SpeechRepository speechRepositoryMock;

    @Mock
    View mockView;

    MockMvc mockMvc;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(createEventControllerMock)
                .setSingleView(mockView)
                .build();


    }
    @Test
    public void getEvent() throws Exception {

        mockMvc.perform(get("/event"))
        .andExpect(status().isOk());

    }

    @Test
    public void getEventSpeeches() throws Exception {
        ArrayList<Speech> list = new ArrayList<>();
 //       list.add(new Speech("ID"));
 //       list.add(new Speech("ID"));
 //       when(createEventControllerMock.getEventSpeeches("eventID")).thenReturn(list);
        mockMvc.perform(get("/event/ID"))
                .andExpect(status().isOk());
                //.andExpect(model().attribute("ID", list));
                //.andExpect(view().name("event/ID"));
}








}
