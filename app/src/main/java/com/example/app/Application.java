package com.example.app;

import com.example.api.User;
import com.example.api.UserService;
import com.example.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe principale de l'application
 */
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("========== Application démarrée ==========");
        
        UserService userService = new UserServiceImpl();
        
        // Créer et sauvegarder des utilisateurs
        User user1 = new User("1", "Alice", "alice@example.com");
        User user2 = new User("2", "Bob", "bob@example.com");
        User user3 = new User("3", "Charlie", "charlie@example.com");
        
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        
        logger.info("Tous les utilisateurs:");
        userService.getAllUsers().forEach(user -> logger.info("  {}", user));
        
        logger.info("Récupération utilisateur avec ID 2: {}", userService.getUserById("2"));
        
        userService.deleteUser("2");
        logger.info("Après suppression d'Alice:");
        userService.getAllUsers().forEach(user -> logger.info("  {}", user));
        
        logger.info("========== Application terminée ==========");
    }
}
