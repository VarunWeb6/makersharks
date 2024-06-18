package com.register.Controller;

import com.register.Models.User;
import com.register.Repo.UserRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@SecurityRequirement(name="security")
public class ApiController {

    @Autowired
    private UserRepo userrepo;
    

    @GetMapping("/")
    public String getPage(){
        return "home page";
    }

    @GetMapping("/fetch")
    public List<User> getUsers(){
        return userrepo.findAll();
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        userrepo.save(user);
        return "Data registered successfully...";
    }
}
