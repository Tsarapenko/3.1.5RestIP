package com.example.spring_security.service;
import com.example.spring_security.models.User;
import java.util.List;
import java.util.Optional;

public interface UserService{

    User findUserById(int id);
    void add(User user);
    List<User> listUsers();

    Optional<User> show(int id);

    void update (User user, int id);

    void delete(int id);

}

