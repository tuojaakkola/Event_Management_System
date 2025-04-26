package app.eventmanagement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import app.eventmanagement.domain.Event;
import app.eventmanagement.service.EventService;

// This class will handle RESTful API requests related to events
@RestController
@RequestMapping("/api/events") 
public class RestEventController {

    @Autowired
    private EventService eventService;

    // GET: Retrieve all events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // GET: Retrieve a specific event by ID
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    // POST: Add a new event
    @PostMapping
    public Event addEvent(@RequestBody Event event) {
        eventService.saveEvent(event);
        return event;
    }

    // PUT: Update an existing event
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        eventService.updateEvent(id, updatedEvent);
        return updatedEvent;
    }

    // DELETE: Delete an event by ID
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "Event with ID " + id + " has been deleted.";
    }

    // POST: Like an event
    @PostMapping("/{id}/like")
    public String likeEvent(@PathVariable("id") Long id, Authentication authentication) {
        String username = authentication.getName();
        return eventService.likeEvent(id, username);
    }
}
