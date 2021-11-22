package com.spt.controller;

import com.spt.atom.User;
import com.spt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/users")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService){ this.usersService = usersService;
    }

    @GetMapping(value= "")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(usersService.fetchAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value="/get-user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        return new ResponseEntity<User>(usersService.fetchUserById(id), HttpStatus.OK);
    }

    @GetMapping(value="/get-users-by-active-status/{active}")
    ResponseEntity<List<User>> getUsersByActiveStatus(@PathVariable("active") boolean status){
        return new ResponseEntity<List<User>>(usersService.fetchUsersByActiveStatus(status), HttpStatus.OK);
    }

    @GetMapping(value="/get-users-by-email-domain/{domain}")
    ResponseEntity<List<User>> getUsersByUsernameDomain(@PathVariable("domain") String domain){
        return new ResponseEntity<List<User>>(usersService.fetchUserByUsernameDomain(domain), HttpStatus.OK);
    }
}