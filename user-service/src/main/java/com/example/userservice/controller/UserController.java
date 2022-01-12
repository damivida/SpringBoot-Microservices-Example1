package com.example.userservice.controller;

import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {


    @Autowired
    private UserService userService;

   @PostMapping("/")
    public User saveUser(@RequestBody User user) {
       return userService.saveUser(user);
   }

   @GetMapping("/")
   public List<User> getUsers() {
       return userService.getUsers();
   }

   @GetMapping("/{id}")
   public User getUser(@PathVariable("id") Long userId) {
       return userService.getUser(userId);
   }

    @GetMapping("/name/{name}")
    public User getUserByName(@PathVariable("name") String name) {
        return userService.getUserByName(name);
    }


   @GetMapping("/{id}/department")
   public ResponseTemplateVO getUserWitDepartment(@PathVariable("id") Long userId) {
       return userService.getUserWithDepartment(userId);
   }

}
