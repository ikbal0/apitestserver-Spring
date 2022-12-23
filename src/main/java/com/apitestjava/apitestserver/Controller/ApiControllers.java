package com.apitestjava.apitestserver.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apitestjava.apitestserver.Models.User;
import com.apitestjava.apitestserver.Repo.UserRepo;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUser() {
        return userRepo.findAll();
    }

    @PostMapping(value = "/user")
    public String saveUser(User user) {
        userRepo.save(user);
        return "Saved..";
    }

    @PostMapping(value = "/save")
    public @ResponseBody String addNewUser (
        @RequestParam String firstName,
        @RequestParam String lastName, 
        @RequestParam int age,
        @RequestParam String occupation) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    User n = new User();
    n.setFirstName(firstName);
    n.setLastName(lastName);
    n.setAge(age);
    n.setOccupation(occupation);
    userRepo.save(n);
    return "Saved";
  }
}
