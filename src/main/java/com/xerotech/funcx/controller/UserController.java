package com.xerotech.funcx.controller;

import com.xerotech.funcx.annotation.Login;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/login")
    public ResponseEntity<String> login(){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Login
    @GetMapping("/userInfo")
    public ResponseEntity<String> userInfo(){
        return new ResponseEntity<>("userInfo",HttpStatus.ACCEPTED);
    }
}
