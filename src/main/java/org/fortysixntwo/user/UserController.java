package org.fortysixntwo.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> GetUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{_id}")
    public User GetUser(@PathVariable Integer _id) {
        return userRepository
            .findById(_id)
            .orElseThrow(() -> new IllegalStateException("Invalid Credentials"));
    }
    
    @PostMapping("/")
    public User PostUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/")
    public User PutUser(@RequestBody User user) {
        User oldUser = userRepository
                .findById(user.get_id())
                .orElseThrow(() -> new IllegalStateException("Invalid Credentials"));
        
        oldUser.setUser_name(user.getUser_name());
        oldUser.setUser_email(user.getUser_email());
        oldUser.setUser_pass(user.getUser_pass());
        return userRepository.save(oldUser);
    }

    @DeleteMapping("/{_id}")
    public Integer DeleteUser(@PathVariable Integer _id) {
        userRepository.deleteById(_id);
        return _id;
    }
}