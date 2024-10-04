package net.proselyte.springbootdemo.controller;

import org.springframework.ui.Model;
import net.proselyte.springbootdemo.service.UserService;
import net.proselyte.springbootdemo.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List; // чем ахуенен springboot , тут нет такой хуйни, как подключения сервера вручную, этим занимается сам фрейм,
// такая хуйня, как конфиг файл не всралась тоже, потому что у него есть автоконфигурация, типа он опираясь на то, что есть в проекте, типа БД, сам все настраивает
// он дает норм такие значения по умолчанию и настройки, которые без ебанины и запары дадут начать разработку, ручками заебываться не надо
// у спрингбут используются аннотации, которые включают в себя несколько аннотаций
// типа блч есть аннотация @SpringBootApplication , а она так-то включает в себя аннотации @Configuration, @EnableAutoConfiguration и @ComponentScan
// нехуйственно да? а в спринге ты хуй такое получишь епт
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(ModelMap model) {
        List<User> users = userService.findAll(); //проверка findAll, проверить не вызывает ли исключение метод userService.findAll
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) { // так тут короче хуйня по имени PathVariable вытаскивает из URL адреса переменную
        userService.deleteById(id); // в данном случае id
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) { // та ж хуйня
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update") // вот эта пиздюлина PostMapping, она короче с помощью метода Post,
    public String updateUser(User user) { //который нужен для отправки данных на сервер, аннотация короче говорит че с данными делать
        userService.saveUser(user); // как тут например апдейтнуть пользователя
        return "redirect:/users";
    }
}
