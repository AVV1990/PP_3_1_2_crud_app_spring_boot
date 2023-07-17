package com.kata_academy.pp_3_1_2_crud_app_spring_boot.controller;
import com.kata_academy.pp_3_1_2_crud_app_spring_boot.model.User;
import com.kata_academy.pp_3_1_2_crud_app_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/getUsers")
    public String getUsers(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping(value = "/show_formToAdd")
    public String showPageToAddUser() {
        return "formToAdd";
    }

    @GetMapping(value = "/show_formToFindUserById")
    public String showPageToFindUserById() {
        return "formToFindUserById";
    }

    @GetMapping(value = "/user_add")
    public String addUser(User user) {
        userService.addUser(user);
        return "users";
    }


    @GetMapping(value = "/user_getUserById")
    public String getUserById(ModelMap model, @RequestParam Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "findUserById";
    }


    @GetMapping(value = "/user_deleteUserById")
    public String deleteUserById(@RequestParam Long id) {
        userService.deleteUserById(id);
        return "users";
    }

    @GetMapping(value = "/user_updateUser")
    public String updateUserById(@RequestParam Long id, User user) {
        userService.updateUser(id, user);
        return "users";
    }
}
