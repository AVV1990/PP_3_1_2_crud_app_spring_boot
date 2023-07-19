package com.kata_academy.pp_3_1_2_crud_app_spring_boot.service;

import com.kata_academy.pp_3_1_2_crud_app_spring_boot.model.User;
import com.kata_academy.pp_3_1_2_crud_app_spring_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        if (id == null) {
            throw new RuntimeException("ID can not be null");
        } else {
            return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User isn't found"));
        }
    }

    @Override
    public void updateUser(Long id, User user) {

        User userAfterUpdate = getUserById(id);
        if (userAfterUpdate != null) {
            userAfterUpdate.setAge(user.getAge());
            userAfterUpdate.setFirstName(user.getFirstName());
            userAfterUpdate.setLastName(user.getLastName());
            userRepository.save(userAfterUpdate);
        } else {
            throw new RuntimeException("User isn't found");
        }

    }


    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


}
