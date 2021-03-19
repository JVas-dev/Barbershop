package org.example.controller;

import org.example.domain.User;
import org.example.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @PostMapping("/registration")
    public String addUser (User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getPhone());
        if (userFromDb != null) {
            return "false";
        } else {
            user.setActive(true);
            userRepo.save(user);
        return "true";
        }

    }
}
