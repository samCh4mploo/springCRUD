package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUser(Model model) {
        model.addAttribute("user", userService.readAllUser());
        return "users";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "userForm";
        }
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String updateUser(@RequestParam(value = "id", required = false) long id, Model model) {
        model.addAttribute("user", userService.readUserById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUserById(@RequestParam(value = "id", required = false) Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/find")
    public String findUserById(@RequestParam(value = "id", required = false) long id, Model model) {
        model.addAttribute("user", userService.readUserById(id));
        return "user";
    }

}
