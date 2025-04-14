package app.eventmanagement.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// Attendee class represents an attendee of an event
@Entity
public class Attendee {

    // Unique identifier for each attendee created by the database
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String name;
    public String email;

    //One attendee can attend one event
    @ManyToOne
    private Event event;

    // Constructor to create an Attendee with attributes
    public Attendee(String name, String email, Event event) {
        this.name = name;
        this.email = email;
        this.event = event;
    }

    //Empty constructor for JPA
    public Attendee() {
    }

    // Getters and Setters 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
