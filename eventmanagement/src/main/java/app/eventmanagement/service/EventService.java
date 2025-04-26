package app.eventmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.eventmanagement.domain.EventRepository;
import app.eventmanagement.domain.Event;

// This class handles the business logic related to events in the application
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid event ID: " + id));
    }

    public void saveEvent(Event event) {
        eventRepository.save(event);
    }

    public void updateEvent(Long id, Event updatedEvent) {
        Event existingEvent = getEventById(id);
        existingEvent.setName(updatedEvent.getName());
        existingEvent.setDescription(updatedEvent.getDescription());
        existingEvent.setLocation(updatedEvent.getLocation());
        existingEvent.setDate(updatedEvent.getDate());
        existingEvent.setTime(updatedEvent.getTime());
        eventRepository.save(existingEvent);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> searchEvents(String query) {
        return eventRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrLocationContainingIgnoreCase(query, query, query);
    }
    
    public String likeEvent(Long id, String username) {
        Event event = eventRepository.findById(id)
                .orElseThrow();

        if (event.getLikedBy().contains(username)) {
            return "You have already liked this event.";
        }

        event.getLikedBy().add(username);
        eventRepository.save(event);
        return "Event liked successfully!";
    }
    
}
