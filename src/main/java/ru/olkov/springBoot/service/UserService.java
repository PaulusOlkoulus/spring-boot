package ru.olkov.springBoot.service;


import ru.olkov.springBoot.models.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getUserDetail(int id);
    void addUser(User user);

    void update(int id, User user);

    void deleteUser(User user);
}
