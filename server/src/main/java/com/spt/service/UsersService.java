package com.spt.service;

import com.spt.entity.User;

import java.util.List;

public interface UsersService {
    String helloWorld();
    List<User> fetchAllUsers();
}
