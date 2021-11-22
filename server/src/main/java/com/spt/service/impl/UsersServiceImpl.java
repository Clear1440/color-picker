package com.spt.service.impl;

import com.spt.atom.User;
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
    public List<User> fetchAllUsers(){
        return usersRepository.findAllUsers().stream()
                .map(com.spt.entity.User::toAtom)
                .collect(Collectors.toList());
    }

    @Override
    public User fetchUserById(int id) {
        return usersRepository.findById(id).toAtom();
    }

    @Override
    public List<User> fetchUsersByActiveStatus(boolean status) {
        return usersRepository.fetchUsersByActiveStatus(status).stream()
                .map(com.spt.entity.User::toAtom)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> fetchUserByUsernameDomain(String domain) {
        return usersRepository.fetchUsersByUsernameDomain("%@"+domain).stream()
                .map(com.spt.entity.User::toAtom)
                .collect(Collectors.toList());
    }
}
