package com.example.interfacebasedimpl.repositories.service;

import com.example.interfacebasedimpl.collections.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface UserRepoService {
    Optional<User> findByName(String name);
}
