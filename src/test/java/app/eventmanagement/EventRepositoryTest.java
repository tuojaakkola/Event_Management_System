/* package app.eventmanagement;

import app.eventmanagement.domain.Event;
import app.eventmanagement.domain.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    public void testSaveAndFindEvent() {
        // Save a new event
        Event event = new Event("Test Event", "Description", "Location", "2025-05-01", "10:00");
        eventRepository.save(event);

        // Find all events
        List<Event> events = eventRepository.findAll();

        // Verify the event was saved and retrieved correctly
        assertThat(events).isNotEmpty();
        assertThat(events.get(0).getName()).isEqualTo("Test Event");
    }
}
 */