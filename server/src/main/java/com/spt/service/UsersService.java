package com.spt.service;

import com.spt.atom.User;

import java.util.List;

public interface UsersService {
    String helloWorld();
    List<User> fetchAllUsers();
}
