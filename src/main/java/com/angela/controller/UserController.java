package com.angela.controller;

import com.angela.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    //导出大于18岁的user
    public void exportUserOlderThen18(){
        userService.exportUserOlderThen18Async();
    }
}
