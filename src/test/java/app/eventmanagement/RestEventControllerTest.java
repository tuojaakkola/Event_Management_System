package app.eventmanagement;

import app.eventmanagement.domain.Event;
import app.eventmanagement.service.EventService;
import app.eventmanagement.web.RestEventController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RestEventControllerTest {

    @Autowired
    private RestEventController restEventController;

    @MockBean
    private EventService eventService;

    @Test
    public void testGetAllEvents() {
        // Mock the service
        Mockito.when(eventService.getAllEvents()).thenReturn(Arrays.asList(
                new Event("Event 1", "Description 1", "Location 1", "2025-05-01", "10:00"),
                new Event("Event 2", "Description 2", "Location 2", "2025-06-01", "12:00")
        ));

        // Call the controller
        List<Event> events = restEventController.getAllEvents();

        // Verify the results
        assertThat(events).hasSize(2);
        assertThat(events.get(0).getName()).isEqualTo("Event 1");
    }
}
