package com.trikisoft.javatest.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class RomanNumeralsIT {

    @Test
    public void should_parse_1_to_I() {
        assertThat(RomanNumerals.arabicToRoman(1), is("I"));
    }

    @Test
    public void should_parse_2_to_II() {
        assertThat(RomanNumerals.arabicToRoman(2), is("II"));
    }

    @Test
    public void should_parse_3_to_III() {
        assertThat(RomanNumerals.arabicToRoman(3), is("III"));
    }

    @Test
    public void should_not_parse_4_to_IIII() {
        assertThat(RomanNumerals.arabicToRoman(4), not("IIII"));
    }

    @Test
    public void should_parse_5_to_V() {
        assertThat(RomanNumerals.arabicToRoman(5), is("V"));
    }

    @Test
    public void should_parse_6_to_VI() {
        assertThat(RomanNumerals.arabicToRoman(6), is("VI"));
    }

    @Test
    public void should_parse_7_to_VII() {
        assertThat(RomanNumerals.arabicToRoman(7), is("VII"));
    }

    @Test
    public void should_not_parse_9_to_VIIII() {
        assertThat(RomanNumerals.arabicToRoman(9), not("VIIII"));
    }

    @Test
    public void should_parse_10_to_X() {
        assertThat(RomanNumerals.arabicToRoman(10), is("X"));
    }

    @Test
    public void should_parse_11_to_XI() {
        assertThat(RomanNumerals.arabicToRoman(11), is("XI"));
    }

    @Test
    public void should_parse_15_to_XV() {
        assertThat(RomanNumerals.arabicToRoman(15), is("XV"));
    }

    @Test
    public void should_parse_16_to_XVI() {
        assertThat(RomanNumerals.arabicToRoman(16), is("XVI"));
    }

    @Test
    public void should_parse_50_to_L() {
        assertThat(RomanNumerals.arabicToRoman(50), is("L"));
    }

    @Test
    public void should_parse_51_to_LI() {
        assertThat(RomanNumerals.arabicToRoman(51), is("LI"));
    }

    @Test
    public void should_parse_55_to_LV() {
        assertThat(RomanNumerals.arabicToRoman(55), is("LV"));
    }

    @Test
    public void should_parse_56_to_LVI() {
        assertThat(RomanNumerals.arabicToRoman(56), is("LVI"));
    }

    @Test
    public void should_parse_60_to_LX() {
        assertThat(RomanNumerals.arabicToRoman(60), is("LX"));
    }

    @Test
    public void should_parse_70_to_LXX() {
        assertThat(RomanNumerals.arabicToRoman(70), is("LXX"));
    }

    @Test
    public void should_parse_80_to_LXXX() {
        assertThat(RomanNumerals.arabicToRoman(80), is("LXXX"));
    }

    @Test
    public void should_parse_81_to_LXXXI() {
        assertThat(RomanNumerals.arabicToRoman(81), is("LXXXI"));
    }

    @Test
    public void should_parse_85_to_LXXXV() {
        assertThat(RomanNumerals.arabicToRoman(85), is("LXXXV"));
    }

    @Test
    public void should_parse_86_to_LXXXVI() {
        assertThat(RomanNumerals.arabicToRoman(86), is("LXXXVI"));
    }

    @Test
    public void should_parse_126_to_CXXVI() {
        assertThat(RomanNumerals.arabicToRoman(126), is("CXXVI"));
    }

    @Test
    public void should_parse_2507_to_MMDVII() {
        assertThat(RomanNumerals.arabicToRoman(2507), is("MMDVII"));
    }

    @Test
    public void should_parse_4_to_IV() {
        assertThat(RomanNumerals.arabicToRoman(4), is("IV"));
    }

    @Test
    public void should_parse_9_to_IX() {
        assertThat(RomanNumerals.arabicToRoman(9), is("IX"));
    }

    @Test
    public void should_parse_14_to_XIV() {
        assertThat(RomanNumerals.arabicToRoman(14), is("XIV"));
    }

    @Test
    public void should_parse_24_to_XXIV() {
        assertThat(RomanNumerals.arabicToRoman(24), is("XXIV"));
    }

    @Test
    public void should_parse_40_to_XL() {
        assertThat(RomanNumerals.arabicToRoman(40), is("XL"));
    }

    @Test
    public void should_parse_49_to_XLIX() {
        assertThat(RomanNumerals.arabicToRoman(49), is("XLIX"));
    }

    @Test
    public void should_parse_90_to_XC() {
        assertThat(RomanNumerals.arabicToRoman(90), is("XC"));
    }

    @Test
    public void should_parse_99_to_XCIX() {
        assertThat(RomanNumerals.arabicToRoman(99), is("XCIX"));
    }

    @Test
    public void should_parse_400_to_CD() {
        assertThat(RomanNumerals.arabicToRoman(400), is("CD"));
    }

    @Test
    public void should_parse_900_to_CM() {
        assertThat(RomanNumerals.arabicToRoman(900), is("CM"));
    }

    @Test
    public void should_not_parse_900_to_I() {
        assertThat(RomanNumerals.arabicToRoman(900), not("XXXVVVIIIMIII"));
    }
}