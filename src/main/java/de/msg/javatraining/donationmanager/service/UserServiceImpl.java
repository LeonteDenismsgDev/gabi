package de.msg.javatraining.donationmanager.service;

import de.msg.javatraining.donationmanager.persistence.model.User;
import de.msg.javatraining.donationmanager.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    public List<User> getAll(){
        return userRepository.findAll();
    }

    public boolean addUser(User user){
        if(userRepository.findAll().stream().filter(u->u.getId()==user.getId()).collect(Collectors.toList()).size()==0){
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public void removeUser(long id){
        userRepository.deleteById(id);
    }

    public User getById(long id){
        return userRepository.findById(id).get();
    }

    public boolean modifyUser(long id, User newUser){
        Optional<User> user_ = userRepository.findById(id);
        if(user_.isPresent()) {
            User user = user_.get();
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setRoles(newUser.getRoles());
            user.setUsername(newUser.getUsername());
//            user.setId(newUser.getId());
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
