package com.example.restapp.controller;

import com.example.restapp.domain.User;
import com.example.restapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users-list")
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "users-list";
    }

    @GetMapping("/new-user")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return "new-user";
    }

    @PostMapping("/new-user")
    public String create(@ModelAttribute User user) {
         userService.createUser(user);
         return "redirect:/users-list";
    }

    @GetMapping("users/{userId}/hastalik-update")
    public String editHastaliklarForm(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "hastalik-update";
    }

    @PostMapping("users/{userId}/hastalik-update")
    public String updateHastaliklar(
            @PathVariable Long userId,
            @RequestParam String newHastalik) {
        userService.updateHastaliklar(userId, newHastalik);
        return "redirect:/users-list";
    }

    @GetMapping("users/{userId}/ilac-update")
    public String editIlaclar(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "ilac-update";
    }

    @PostMapping("users/{userId}/ilac-update")
    public String editIlaclar(
            @PathVariable Long userId,
            @RequestParam String newHastalik) {
        userService.updateIlaclar(userId, newHastalik);
        return "redirect:/users-list";
    }


    @GetMapping("users/{userId}/tahlil-update")
    public String editTahliller(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "tahlil-update";
    }

    @PostMapping("users/{userId}/tahlil-update")
    public String editTahliller(
            @PathVariable Long userId,
            @RequestParam String newHastalik) {
        userService.updateTahliller(userId, newHastalik);
        return "redirect:/users-list";
    }
}
