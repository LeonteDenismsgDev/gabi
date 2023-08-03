package de.msg.javatraining.donationmanager.service;

import de.msg.javatraining.donationmanager.persistence.model.User;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User getById(long id);
    public boolean addUser(User user);
    public void removeUser(long id);
    public boolean modifyUser(long id, User newUser);

}
