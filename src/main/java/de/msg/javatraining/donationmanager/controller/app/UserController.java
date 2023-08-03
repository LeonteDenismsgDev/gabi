package de.msg.javatraining.donationmanager.controller.app;

import de.msg.javatraining.donationmanager.persistence.model.User;
import de.msg.javatraining.donationmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/users")
    public boolean saveUser(@RequestBody User user){
        return service.addUser(user);
    }

    @GetMapping("/users")
    public List<User> fetchUsers(){
        return service.getAll();
    }

    @GetMapping("/users/{id}")
    public User fetchUserById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @DeleteMapping("/users/{id}")
    public String removeUser(@PathVariable("id") Long id){
        service.removeUser(id);
        return "User removed";
    }

    @PutMapping("/users/{id}")
    public String updateUser(@RequestBody User user,
                             @PathVariable("id") Long id){
       if (service.modifyUser(id,user))
       {
           return "Modified";
       }
       return "Not modified";
    }
}
