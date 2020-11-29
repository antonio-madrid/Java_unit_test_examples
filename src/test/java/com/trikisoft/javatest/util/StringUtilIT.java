package com.trikisoft.javatest.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilIT {

    @Test
    public void should_repeat_string_once() {
        assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void should_repeat_string_multiple_times() {
        assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void should_repeat_string_zero_times() {
        assertEquals("", StringUtil.repeat("hola", 0));
    }

    // It checks if a function throws an exception in JUnit 4
    @Test(expected = IllegalArgumentException.class)
    public void should_repeat_string_negative_times() {
        assertEquals("hola", StringUtil.repeat("hola", -1));
    }

    @Test
    public void should_return_false_when_isEmpty_receives_string_not_empty() {
        assertFalse(StringUtil.isEmpty("Hello World!"));
    }

    @Test
    public void should_return_true_when_isEmpty_receives_empty_string() {
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void should_return_true_when_isEmpty_receives_null() {
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void should_return_true_when_isEmpty_only_receives_white_spaces() {
        assertTrue(StringUtil.isEmpty(" "));
    }
}
