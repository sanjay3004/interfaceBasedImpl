package com.example.interfacebasedimpl.services.impl;

import com.example.interfacebasedimpl.collections.User;
import com.example.interfacebasedimpl.dto.UserDto;
import com.example.interfacebasedimpl.exception.NotFoundException;
import com.example.interfacebasedimpl.repositories.UserRepo;
import com.example.interfacebasedimpl.repositories.service.UserRepoService;
import com.example.interfacebasedimpl.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;

    ModelMapper modelMapper=new ModelMapper();

    UserRepoService userRepoService;

    public UserServiceImpl(UserRepo userRepo, UserRepoService userRepoService) {
        this.userRepo = userRepo;
        this.userRepoService = userRepoService;
    }

    @Override
    public boolean add(User user) {
        Optional<User> currUser=userRepoService.findByName(user.getName());
        if(currUser.isEmpty()) {
             userRepo.save(user);
             return true;
        }
        return false;
    }

    @Override
    public Optional<User> get(String name) {
        return userRepoService.findByName(name);
    }

    @Override
    public List<User> getAll() {
        if(userRepo.findAll().isEmpty()){
            throw new NotFoundException("no user found");
        }

        return userRepo.findAll();
    }

    @Override
    public List<UserDto> getAllDto() {
        return userRepo.findAll().stream().map(user->modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }
}
