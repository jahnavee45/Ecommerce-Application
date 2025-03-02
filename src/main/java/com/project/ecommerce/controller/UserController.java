package com.project.ecommerce.controller;

import com.project.ecommerce.entity.User;
import com.project.ecommerce.services.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "/register";
    }

    @GetMapping("/login")
    public String getLoginForm(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid email or password");
        }
        User user = new User();
        model.addAttribute("user", user);
        return "/login";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user){
        // encrypting the password
        String hashPw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));

        // saving the user with encrypted password
        user.setPassword(hashPw);

        // saving the user to the database
        userService.save(user);
        return "products-category";
    }

    @PostMapping("/signin")
    public String authenticateUser(@ModelAttribute("user") User user){
        boolean isAuthenticated = userService.authenticate(user.getEmail(), user.getPassword());
        if(!isAuthenticated){
            return "redirect:/login?error=true";
        }
        return "redirect:/products-category";
    }
}
