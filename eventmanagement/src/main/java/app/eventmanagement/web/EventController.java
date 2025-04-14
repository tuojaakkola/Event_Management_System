package app.eventmanagement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.eventmanagement.domain.AttendeeRepository;
import app.eventmanagement.domain.EventRepository;

// This class will contain methods to handle HTTP requests related to events
@Controller
public class EventController {

    // Autowiring the repositories to handle database operations
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private AttendeeRepository attendeeRepository;


}
