package com.example.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void testFormatMessage() {
        String result = Util.formatMessage("Hello");
        assertEquals("[Hello]", result);
    }

    @Test
    public void testIsValid() {
        assertTrue(Util.isValid("test"));
        assertFalse(Util.isValid(""));
        assertFalse(Util.isValid(null));
    }
}
