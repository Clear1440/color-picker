package com.spt.controller;

import com.spt.atom.UserAtom;
import com.spt.atom.UsersAppThemeProjection;
import com.spt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/users")
@CrossOrigin(origins ="*", maxAge = 3600)
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService){ this.usersService = usersService;
    }

    @GetMapping(value= "")
    public ResponseEntity<List<UserAtom>> getUsers(){
        return new ResponseEntity<>(usersService.fetchAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value="/get-user/{id}")
    public ResponseEntity<UserAtom> getUserById(@ModelAttribute("id") com.spt.entity.User user){
        return new ResponseEntity<>(user.toAtom(), HttpStatus.OK);
    }

    @GetMapping(value="/get-users-by-active-status/{active}")
    ResponseEntity<List<UserAtom>> getUsersByActiveStatus(@PathVariable("active") boolean status){
        return new ResponseEntity<>(usersService.fetchUsersByActiveStatus(status), HttpStatus.OK);
    }

    @GetMapping(value="/get-users-by-email-domain/{domain}")
    ResponseEntity<List<UserAtom>> getUsersByUsernameDomain(@PathVariable("domain") String domain){
        return new ResponseEntity<>(usersService.fetchUserByUsernameDomain(domain), HttpStatus.OK);
    }

    @GetMapping(value="/get-color-palette/{id}")
    ResponseEntity<UsersAppThemeProjection> getColorPaletteByUserid(@PathVariable("id") int id){
        return new ResponseEntity<>(usersService.fetchColorPaletteById(id), HttpStatus.OK);
    }
}