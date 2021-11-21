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
    public String helloWorld(){
        return "hello World";
    }

    @Override
    public List<User> fetchAllUsers(){
        return ((List<com.spt.entity.User>) usersRepository.findAll()).stream()
                .map(com.spt.entity.User::toAtom)
                .collect(Collectors.toList());
    }
}
