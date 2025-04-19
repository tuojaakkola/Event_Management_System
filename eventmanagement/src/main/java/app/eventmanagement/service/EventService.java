package app.eventmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.eventmanagement.domain.EventRepository;
import app.eventmanagement.domain.Event;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

}
