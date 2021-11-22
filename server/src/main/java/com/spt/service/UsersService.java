package com.spt.service;

import com.spt.atom.User;

import java.util.List;

public interface UsersService {
    List<User> fetchAllUsers();

    User fetchUserById(int id);

    List<User> fetchUsersByActiveStatus(boolean status);

    List<User> fetchUserByUsernameDomain(String domain);
}
