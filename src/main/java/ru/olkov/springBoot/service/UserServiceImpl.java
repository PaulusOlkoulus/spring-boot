package ru.olkov.springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.olkov.springBoot.models.User;
import ru.olkov.springBoot.repositories.UserRepository;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUserDetail(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void update(int id, User user) {
        user.setId(id);
        userRepository.save(user);
//        userRepository;
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }


}
