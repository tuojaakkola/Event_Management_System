package app.eventmanagement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import app.eventmanagement.service.EventService;
import app.eventmanagement.domain.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


// This class will contain methods to handle HTTP requests related to events
@Controller
public class EventController {

    // Autowiring the service class to access event-related operations
    @Autowired
    private EventService eventService;

    // This method will display the login page of the application
    @GetMapping("/login")
    public String showLogin() {
        return "login"; // login.html tiedosto templates-kansiossa
    }

    // This method will display the list of events
    @GetMapping("/events")
    public String showEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
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
        eventService.saveEvent(event); 
        return "redirect:/events"; 
    }

    // This method will display the form to edit an existing event
    @GetMapping("/events/{id}")
    public String showEventDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("event", eventService.getEventById(id));
        return "eventdetails";
    }

    // This method handles the form submission for updating an existing event
    @PostMapping("/events/{id}")
    public String updateEvent(@PathVariable("id") Long id, @ModelAttribute Event event) {
        eventService.updateEvent(id, event);
        return "redirect:/events";
    }

    // This method will handle the deletion of an event
    @PostMapping("/events/{id}/delete")
    public String deleteEvent(@PathVariable("id") Long id) {
        eventService.deleteEvent(id);
        return "redirect:/events";
    }

    // This method will display the search form for events 
    @GetMapping("/events/search")
    public String searchEvents(@RequestParam("query") String query, Model model) {
        model.addAttribute("events", eventService.searchEvents(query));
        return "eventlist";
    }

}
