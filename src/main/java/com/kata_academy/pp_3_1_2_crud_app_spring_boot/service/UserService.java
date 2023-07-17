package com.kata_academy.pp_3_1_2_crud_app_spring_boot.service;

import com.kata_academy.pp_3_1_2_crud_app_spring_boot.model.User;
import java.util.List;

public interface UserService {

    List<User> getUsers();

    void addUser(User user);

    User getUserById(Long id);

    void updateUser(Long id, User user);


    void deleteUserById(Long id);
}
