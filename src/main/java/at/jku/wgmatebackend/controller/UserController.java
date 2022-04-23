package at.jku.wgmatebackend.controller;

import at.jku.wgmatebackend.model.entity.User;
import at.jku.wgmatebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userTest")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

//    @GetMapping("/user")
//    public User getUserById( @RequestBody Integer userId) {
//        return userRepository.findById(userId).orElseThrow();
//    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable(value = "id") Integer userId, @RequestBody User userDetails) {

        User user = userRepository.findById(userId).orElseThrow();

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        return userRepository.save(user);
    }


    @DeleteMapping("/user")
    public ResponseEntity<?> deleteUser(@RequestBody Integer userId) {
        User user = userRepository.findById(userId).orElseThrow();

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }


}
