package com.gnq.datasource.controller;

import com.gnq.datasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list/local")
    public Object listUsersFromLocal(){
        return userService.listFromLocal();
    }

    @GetMapping("/list/remote")
    public Object listUsersFromRemote(){
        return userService.listFromRemote();
    }
}
