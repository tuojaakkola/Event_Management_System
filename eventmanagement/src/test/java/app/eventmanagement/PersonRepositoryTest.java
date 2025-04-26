package app.eventmanagement;

import app.eventmanagement.domain.Person;
import app.eventmanagement.domain.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    public void testSaveAndFindPerson() {
        // Save a new person
        Person person = new Person("testuser", "password123", Set.of("ROLE_USER"));
        personRepository.save(person);

        // Find the person by username
        Person foundPerson = personRepository.findByUsername("testuser");

        // Verify the person was saved and retrieved correctly
        assertThat(foundPerson).isNotNull();
        assertThat(foundPerson.getUsername()).isEqualTo("testuser");
        assertThat(foundPerson.getRoles()).contains("ROLE_USER");
    }
}
