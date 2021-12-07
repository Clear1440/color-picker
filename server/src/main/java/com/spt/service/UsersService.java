package com.spt.service;

import com.spt.atom.UserAtom;
import com.spt.atom.UsersAppThemeProjection;

import java.util.List;

public interface UsersService {
    List<UserAtom> fetchAllUsers();

    UserAtom fetchUserById(int id);

    List<UserAtom> fetchUsersByActiveStatus(boolean status);

    List<UserAtom> fetchUserByUsernameDomain(String domain);

    UsersAppThemeProjection fetchColorPaletteById(int id);
}
