package com.example.interfacebasedimpl.service;


import com.example.interfacebasedimpl.collections.User;
import com.example.interfacebasedimpl.exception.NotFoundException;
import com.example.interfacebasedimpl.exception.UserAlreadyFound;
import com.example.interfacebasedimpl.repositories.UserRepo;
import com.example.interfacebasedimpl.repositories.service.UserRepoService;
import com.example.interfacebasedimpl.services.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {


    @Mock
    UserRepoService userRepoService;
    @Mock
    UserRepo userRepo;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    User user;

    @Before
    public void setUp() throws Exception {
        user=new User("Sanjay","sankar");
    }

    @Test
    public void serviceAddMethodSuccess(){
        when(userRepoService.findByName(anyString())).thenReturn(Optional.ofNullable(null));
        userServiceImpl.add(user);
        verify(userRepo,times(1)).save(any(User.class));

    }

    @Test
    public void serviceAddMethodFailed(){
        when(userRepoService.findByName(anyString())).thenReturn(Optional.ofNullable(user));
       // userServiceImpl.add(user);
//        verify(userRepo,times(1)).save(any(User.class));
       assertThat(userServiceImpl.add(user)).isFalse();
    }

    @Test
    public void serviceGetMethod(){
        when(userRepoService.findByName(anyString())).thenReturn(Optional.ofNullable(user));
        assertEquals(user,userServiceImpl.get(anyString()).get());
    }

    @Test
    public void ServiceGetAllMethod(){
        when(userRepo.findAll()).thenReturn(List.of(user));
        assertEquals(1,userServiceImpl.getAll().size());
    }

    @Test
    public void ServiceGetAllException(){
        when(userRepo.findAll()).thenReturn(List.of());
        assertThatThrownBy(()->userServiceImpl.getAll()).isInstanceOf(NotFoundException.class).hasMessageContaining("no user found");
    }
}
