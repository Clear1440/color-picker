package com.spt.service.impl;

import com.spt.atom.UserAtom;
import com.spt.atom.UsersAppThemeProjection;
import com.spt.repository.UsersRepository;
import com.spt.service.UsersService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService{
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository){ this.usersRepository = usersRepository; }

    @Override
    public List<UserAtom> fetchAllUsers(){
        return usersRepository.findAllUsers().stream()
                .map(com.spt.entity.User::toAtom)
                .collect(Collectors.toList());
    }

    @Override
    public UserAtom fetchUserById(int id) {
        return usersRepository.findById(id).toAtom();
    }

    @Override
    public List<UserAtom> fetchUsersByActiveStatus(boolean status) {
        return usersRepository.fetchUsersByActiveStatus(status).stream()
                .map(com.spt.entity.User::toAtom)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAtom> fetchUserByUsernameDomain(String domain) {
        return usersRepository.fetchUsersByUsernameDomain("%@"+domain).stream()
                .map(com.spt.entity.User::toAtom)
                .collect(Collectors.toList());
    }

    @Override
    public UsersAppThemeProjection fetchColorPaletteById(int id){
        return usersRepository.fetchColorPaletteById(id);
    }
}
