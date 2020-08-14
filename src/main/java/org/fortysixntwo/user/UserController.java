package org.fortysixntwo.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('user:read')")
    public List<User> GetUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{_id}")
    @PreAuthorize("hasAuthority('user:read')")
    public User GetUser(@PathVariable Integer _id) {
        return userRepository
            .findById(_id)
            .orElseThrow(() -> new IllegalStateException("Invalid Credentials"));
    }
    
    @PostMapping("/")
    @PreAuthorize("hasAuthority('user:write')")
    public User PostUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping(path = "/{_id}")
    @PreAuthorize("hasAuthority('user:write')")
    public User PutUser(@PathVariable Integer _id, @RequestBody User user) {
        User updateUser = userRepository
                .findById(_id)
                .orElseThrow(() -> new IllegalStateException("Invalid Credentials"));
        
        updateUser.setUser_name(user.getUser_name());
        updateUser.setUser_email(user.getUser_email());
        updateUser.setUser_pass(user.getUser_pass());
        return userRepository.save(updateUser);
    }

    @DeleteMapping(path = "/{_id}")
    @PreAuthorize("hasAuthority('user:write')")
    public Integer DeleteUser(@PathVariable Integer _id) {
        userRepository.deleteById(_id);
        return _id;
    }
}