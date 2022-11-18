package com.example.interfacebasedimpl.controller;

import com.example.interfacebasedimpl.api.UserApi;
import com.example.interfacebasedimpl.collections.User;
import com.example.interfacebasedimpl.dto.UserDto;
import com.example.interfacebasedimpl.exception.NotFoundException;
import com.example.interfacebasedimpl.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController implements UserApi {



    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<?> add(@RequestBody User user){
        if(userService.add(user)) {
            return ResponseEntity.status(HttpStatus.OK).body("ok");
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body("Already exists");
        }
    }

    public ResponseEntity<?> get(@PathVariable String name){
        Optional<User> user=userService.get(name);
        if(user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(userService.get(name).get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }
    }

    @Override
    public ResponseEntity<List<User>> getList() {
        List<User> all = userService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

    @Override
    public ResponseEntity<List<UserDto>> getListasDto() {
        List<UserDto> allDto = userService.getAllDto();
        return ResponseEntity.status(HttpStatus.OK).body(allDto);
    }


}
