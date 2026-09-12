package com.example.api;

import java.util.List;

/**
 * Interface du service utilisateur
 */
public interface UserService {

    User getUserById(String id);

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(String id);
}
