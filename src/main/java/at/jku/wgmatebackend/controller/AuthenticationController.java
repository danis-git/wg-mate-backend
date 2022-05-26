package at.jku.wgmatebackend.controller;

import at.jku.wgmatebackend.model.entity.User;
import at.jku.wgmatebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

class Login {
    public String email;
    public String password;
}

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public User login(@RequestBody Login login) {
        // todo: if password correct
        return userRepository.findByEmail(login.email);
    }
}
