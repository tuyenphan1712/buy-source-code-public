package org.example.buysourcecode.service;

import org.example.buysourcecode.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User findUserByUsername(String username);
    User findUserById(String id);
    public void createUser(User user);
    public void updateUser(User user);

}
