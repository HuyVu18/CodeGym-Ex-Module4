package com.egg_gacha.controller;

import com.egg_gacha.dto.UserDTO;
import com.egg_gacha.model.User;
import com.egg_gacha.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping({"/", "users"})
@SessionAttributes("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registerFrom(ModelMap modelMap) {
        modelMap.addAttribute("userDto", new UserDTO());
        return "register";
    }

    @PostMapping
    public String register(@ModelAttribute UserDTO userDTO) {
        userService.save(userDTO);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login(ModelMap modelMap) {
        modelMap.addAttribute("userDto", new UserDTO());
        return "login";
    }
    @GetMapping("/logout")
    public String logout(ModelMap modelMap, HttpSession session) {
        modelMap.remove("user");
        session.removeAttribute("user");
        modelMap.addAttribute("userDto", new UserDTO());
        return "redirect:/users";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDTO userDTO, HttpSession session) {
        User savedUser = userService.findByUsernameAndPassword(userDTO);
        if (savedUser != null) {
            session.setAttribute("user", savedUser);
            return "egg-gacha";
        } else {
            return "redirect:/users/login";
        }

    }
}
