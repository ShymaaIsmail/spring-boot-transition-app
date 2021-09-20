package training.demo.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("welcome")
@CrossOrigin(origins = "*")
public class WelcomeController {

    @GetMapping()
    public String findAll() {
        return "Welcome  to our training application";
    }

    @GetMapping("/{name}")
    public String findAll(@PathVariable String name) {
        return String.format("Welcome %s to our training application", name);
    }

}