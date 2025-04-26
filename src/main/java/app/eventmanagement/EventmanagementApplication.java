package app.eventmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import app.eventmanagement.domain.Person;
import app.eventmanagement.domain.PersonRepository;
import java.util.Set;

@SpringBootApplication
public class EventmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}

    // This method loads user "moderator" into the database when the application starts
	@Bean
    public CommandLineRunner loadTestData(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            personRepository.save(new Person("moderator", passwordEncoder.encode("mod123"), Set.of("MODERATOR")));  
        };
    }

}
