package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.model.User;

@RestController
public class UserController {
@Autowired
UserService us;
@PostMapping("/checkLogin")
public String validateUser(@RequestBody User u)
{
	System.out.println(u.getUsername());
	return us.validateUser(u.getUsername(),u.getPassword());
}
@PostMapping("/adduser")
 public User saveInfo(@RequestBody User ui)
 {
	return us.saveUser(ui);
	}

}
