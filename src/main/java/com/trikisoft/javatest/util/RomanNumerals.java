package com.trikisoft.javatest.util;

public class RomanNumerals {

    private static final String[] ROMAN_LETTERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] ROMAN_NUMBERS_VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static String arabicToRoman(int arabicNumber) {

        if (arabicNumber <= 0) {
            throw new IllegalArgumentException(arabicNumber + " cannot be parse to Roman numeration");
        }

        StringBuilder romanNumberResult = new StringBuilder();

        for (int i = 0; i < ROMAN_NUMBERS_VALUES.length; i++) {

            while (arabicNumber >= ROMAN_NUMBERS_VALUES[i]) {
                romanNumberResult.append(ROMAN_LETTERS[i]);
                arabicNumber = arabicNumber - ROMAN_NUMBERS_VALUES[i];
            }

        }
        return romanNumberResult.toString();
    }
}
