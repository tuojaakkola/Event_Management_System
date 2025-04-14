package app.eventmanagement.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
    // This interface will automatically provide CRUD operations for Attendee entities

}
