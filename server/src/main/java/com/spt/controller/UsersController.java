package com.spt.controller;

import com.spt.atom.User;
import com.spt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/users")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @RequestMapping(
        method = RequestMethod.GET,
        value = "/hello-world")
        public ResponseEntity<String> helloWorld(){
            return new ResponseEntity<String>(usersService.helloWorld(), HttpStatus.OK);
        }

    @RequestMapping(
        method = RequestMethod.GET,
        value = "")
        public ResponseEntity<List<User>> getUsers(){
            return new ResponseEntity<>(usersService.fetchAllUsers(), HttpStatus.OK);
        }
}


















