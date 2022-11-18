package com.example.interfacebasedimpl.api;

import com.example.interfacebasedimpl.collections.User;
import com.example.interfacebasedimpl.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserApi {
    @PostMapping("/add")
     ResponseEntity<?> add(@RequestBody User user);

    @GetMapping("/get/{name}")
    ResponseEntity<?> get(@PathVariable String name);

    @GetMapping("/get")
    ResponseEntity<List<User>> getList();

    @GetMapping("/getAsDto")
    ResponseEntity<List<UserDto>> getListasDto();

}
