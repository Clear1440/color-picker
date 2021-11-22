package com.spt.service;

import com.spt.atom.User;
import com.spt.atom.UsersAppThemeProjection;

import java.util.List;

public interface UsersService {
    List<User> fetchAllUsers();

    User fetchUserById(int id);

    List<User> fetchUsersByActiveStatus(boolean status);

    List<User> fetchUserByUsernameDomain(String domain);

    UsersAppThemeProjection fetchColorPaletteById(int id);
}
