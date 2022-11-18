package com.example.interfacebasedimpl.repositories.service.impl;

import com.example.interfacebasedimpl.collections.User;
import com.example.interfacebasedimpl.repositories.UserRepo;
import com.example.interfacebasedimpl.repositories.service.UserRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserRepoServiceImpl implements UserRepoService {
    @Autowired
    UserRepo userRepo;


    @Override
    public Optional<User> findByName(String name) {
        return userRepo.getUserByName(name);
    }


}
