package com.example.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe utilitaire du module core
 */
public class Util {

    private static final Logger logger = LoggerFactory.getLogger(Util.class);

    public static String formatMessage(String message) {
        logger.info("Formatting message: {}", message);
        return "[" + message + "]";
    }

    public static boolean isValid(String input) {
        return input != null && !input.trim().isEmpty();
    }
}
