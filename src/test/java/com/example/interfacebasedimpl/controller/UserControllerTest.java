package com.example.interfacebasedimpl.controller;

import com.example.interfacebasedimpl.collections.User;
import com.example.interfacebasedimpl.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    MockMvc mockMvc;

    @InjectMocks
    UserController userController;

    ObjectMapper objectMapper;

    @Mock
    UserService userService;

    User user;

    @Before
    public void setUp() throws Exception {
        mockMvc= MockMvcBuilders.standaloneSetup(userController).build();
        user=new User("Alpha","Beta");
        objectMapper=new ObjectMapper();
    }

    @Test
    public void addMethodSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());

    }


    @Test
    public void getMethodSuccess() throws Exception {
        when(userService.get(anyString())).thenReturn(Optional.ofNullable(user));
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get/"+"ram")).andExpect(status().isOk());
    }

    @Test
    public void getMethodFailure() throws Exception {
        when(userService.get(anyString())).thenReturn(Optional.ofNullable(null));
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get/"+"name")).andExpect(status().isNotFound());
    }

    @Test
    public void getListMethodIfFound() throws Exception {
        when(userService.getAll()).thenReturn(List.of(user));
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get")).andExpect(content().json("[{}]"))
                .andExpect(status().isOk()).andExpect(jsonPath("$[*].name").value(user.getName()));
    }

}
