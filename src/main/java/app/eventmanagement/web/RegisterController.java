package app.eventmanagement.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import app.eventmanagement.domain.Person;
import app.eventmanagement.domain.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//This class handles user registration in the application.
@Controller
public class RegisterController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // This method will display the registration form 
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("person", new Person());
        return "register";
    }
    
    // This method handles the form submission for user registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute Person person) {
       
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRoles(Set.of("PARTICIPANT"));
        personRepository.save(person);
        
        return "redirect:/login?registered";    
    }
}