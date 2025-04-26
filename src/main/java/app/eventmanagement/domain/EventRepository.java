package app.eventmanagement.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface extends JpaRepository to provide CRUD operations for the Event entity
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrLocationContainingIgnoreCase(String name, String description, String location);
}
