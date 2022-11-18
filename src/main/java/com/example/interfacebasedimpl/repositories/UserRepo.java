package com.example.interfacebasedimpl.repositories;

import com.example.interfacebasedimpl.collections.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends MongoRepository<User,String> {

     Optional<User> getUserByName(String name);

     Optional<User> findByNameAndLastName(String name,String lastName);

}
