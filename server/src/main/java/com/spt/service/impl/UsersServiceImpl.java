package com.spt.service.impl;

import com.spt.entity.User;
import com.spt.repository.UsersRepository;
import com.spt.service.UsersService;

import org.springframework.stereotype.Service;

import java.util.List;

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
        return usersRepository.findAllUsers();
    }
}
