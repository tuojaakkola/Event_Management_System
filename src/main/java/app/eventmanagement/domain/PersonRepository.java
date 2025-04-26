package app.eventmanagement.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// This interface extends JpaRepository to provide CRUD operations for the Person entity
public interface PersonRepository extends JpaRepository <Person, Long> {
    Person findByUsername(String username);
}
