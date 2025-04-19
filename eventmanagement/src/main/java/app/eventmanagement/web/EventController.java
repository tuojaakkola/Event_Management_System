package app.eventmanagement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import app.eventmanagement.domain.EventRepository;
import app.eventmanagement.service.EventService;
import app.eventmanagement.domain.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


// This class will contain methods to handle HTTP requests related to events
@Controller
public class EventController {

    // Autowiring the repositories to handle database operations
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventService eventService;

    // This methodd will display the home page
    @GetMapping("/")
    public String showHomepage() {
        return "index"; 
    }

    // This method will display the list of events
    @GetMapping("/events")
    public String showEvents(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "eventlist";
    }

    // This method will display the form to add a new event
    @GetMapping("/events/add")
    public String addEvent(Model model) {
        model.addAttribute("event", new Event());
        return "addevent";
    }

    // This method handles the form submission for adding a new event
    @PostMapping("/events")
    public String saveEvent(@ModelAttribute Event event) {
        eventRepository.save(event); 
        return "redirect:/events"; 
    }

    // This method will display the form to edit an existing event
    @GetMapping("/events/{id}")
    public String showEventDetails(@PathVariable Long id, Model model) {
        Event event = eventRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid event ID: " + id));
        model.addAttribute("event", event);
        return "eventdetails";
    }

    // This method handles the form submission for updating an existing event
    @PostMapping("/events/{id}")
    public String updateEvent(@PathVariable Long id, @ModelAttribute Event event) {
        Event existingEvent = eventRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid event ID: " + id));
        existingEvent.setName(event.getName());
        existingEvent.setDescription(event.getDescription());
        existingEvent.setLocation(event.getLocation());
        existingEvent.setDate(event.getDate());
        existingEvent.setTime(event.getTime());
        eventRepository.save(existingEvent);
        return "redirect:/events";
    }
    
}
