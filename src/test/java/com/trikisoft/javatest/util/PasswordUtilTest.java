package com.trikisoft.javatest.util;

import org.junit.Test;

import static com.trikisoft.javatest.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.assertEquals;

public class PasswordUtilTest {

    @Test
    public void should_be_weak_when_less_than_8_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("1234567"));
        assertEquals(WEAK, PasswordUtil.assessPassword("123aa!"));
    }

    @Test
    public void should_be_weak_when_has_only_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("abcdefgh"));
        assertEquals(WEAK, PasswordUtil.assessPassword("abcdefghfghijklmn"));
    }

    @Test
    public void should_be_weak_when_has_only_letters_and_numbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcd1234"));
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcdefghijk123456789"));
    }

    @Test
    public void should_be_weak_when_has_only_letters_and_numbers_and_symbols() {
        assertEquals(STRONG, PasswordUtil.assessPassword("abcd123!"));
    }

}