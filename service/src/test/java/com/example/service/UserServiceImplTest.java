package com.example.service;

import com.example.api.User;
import com.example.api.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    public void testSaveAndGetUser() {
        User user = new User("1", "John Doe", "john@example.com");
        userService.saveUser(user);
        
        User retrieved = userService.getUserById("1");
        assertNotNull(retrieved);
        assertEquals("John Doe", retrieved.getName());
    }

    @Test
    public void testGetAllUsers() {
        userService.saveUser(new User("1", "User 1", "user1@example.com"));
        userService.saveUser(new User("2", "User 2", "user2@example.com"));
        
        List<User> users = userService.getAllUsers();
        assertEquals(2, users.size());
    }

    @Test
    public void testDeleteUser() {
        User user = new User("1", "John Doe", "john@example.com");
        userService.saveUser(user);
        userService.deleteUser("1");
        
        User retrieved = userService.getUserById("1");
        assertNull(retrieved);
    }
}
