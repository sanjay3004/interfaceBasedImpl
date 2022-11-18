package com.example.interfacebasedimpl.services;

import com.example.interfacebasedimpl.collections.User;
import com.example.interfacebasedimpl.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

     boolean add(User user);

    Optional<User> get(String name);

    List<User> getAll();

    List<UserDto> getAllDto();

}
