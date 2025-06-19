package com.example.usuario.controller;

import com.example.usuario.model.User;
import com.example.usuario.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    private UserService userService;
    private UserController userController;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        userController = new UserController(userService);
    }

    @Test
    void testGetAllUsers() {
        List<User> mockUsers = Arrays.asList(
                new User(1L, "Alice", "alice@example.com"),
                new User(2L, "Bob", "bob@example.com")
        );

        when(userService.findAllUsers()).thenReturn(mockUsers);

        ResponseEntity<List<User>> response = userController.getAllUsers();

        assertEquals(2, response.getBody().size());
        assertEquals("Alice", response.getBody().get(0).getName());
    }

    @Test
    void testCreateUser() {
        User user = new User(null, "Charlie", "charlie@example.com");
        User savedUser = new User(3L, "Charlie", "charlie@example.com");

        when(userService.createUser(user)).thenReturn(savedUser);

        ResponseEntity<User> response = userController.createUser(user);

        assertNotNull(response.getBody().getId());
        assertEquals("Charlie", response.getBody().getName());
    }
}
