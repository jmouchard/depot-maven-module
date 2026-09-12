package com.example.service;

import com.example.api.User;
import com.example.api.UserService;
import com.example.core.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implémentation du service utilisateur
 */
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final Map<String, User> userDatabase = new HashMap<>();

    @Override
    public User getUserById(String id) {
        if (!Util.isValid(id)) {
            logger.warn("Invalid user ID");
            return null;
        }
        logger.info("Getting user with ID: {}", id);
        return userDatabase.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        logger.info("Fetching all users, count: {}", userDatabase.size());
        return new ArrayList<>(userDatabase.values());
    }

    @Override
    public void saveUser(User user) {
        if (user == null || !Util.isValid(user.getId())) {
            logger.error("Cannot save invalid user");
            return;
        }
        logger.info("Saving user: {}", Util.formatMessage(user.getName()));
        userDatabase.put(user.getId(), user);
    }

    @Override
    public void deleteUser(String id) {
        if (!Util.isValid(id)) {
            logger.warn("Cannot delete user with invalid ID");
            return;
        }
        logger.info("Deleting user with ID: {}", id);
        userDatabase.remove(id);
    }
}
