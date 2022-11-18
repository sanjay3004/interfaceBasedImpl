package com.example.interfacebasedimpl.dto;

public class UserDto {
    String name;
    String lastName;

    public UserDto(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public UserDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
