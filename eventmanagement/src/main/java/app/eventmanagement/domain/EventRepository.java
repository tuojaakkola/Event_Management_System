package app.eventmanagement.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    // This interface will automatically provide CRUD operations for Event entities
    
}
