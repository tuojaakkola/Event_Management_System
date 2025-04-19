package app.eventmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import app.eventmanagement.domain.Event;
import app.eventmanagement.domain.EventRepository;

@SpringBootApplication
public class EventmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}

	@Bean
    public CommandLineRunner loadData(EventRepository eventRepository) {
        return (args) -> {
            // Add 5 sample events
            eventRepository.save(new Event("Concert", "Live music event", "Helsinki", "2025-05-01", "18:00"));
            eventRepository.save(new Event("Conference", "Tech conference", "Espoo", "2025-06-15", "09:00"));
            eventRepository.save(new Event("Workshop", "Programming workshop", "Tampere", "2025-07-10", "10:00"));
            eventRepository.save(new Event("Festival", "Summer festival", "Turku", "2025-08-20", "12:00"));
            eventRepository.save(new Event("Meetup", "Developer meetup", "Oulu", "2025-09-05", "17:00"));
        };
    }

}
