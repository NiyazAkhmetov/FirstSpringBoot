package net.proselyte.springbootdemo.controller;

import org.springframework.ui.Model; // Правильный импорт
import net.proselyte.springbootdemo.service.UserService;
import net.proselyte.springbootdemo.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }
    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}
