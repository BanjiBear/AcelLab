package io.acellab.service.web.startline.Util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OneTimePasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "@$!%?&#<>";
    private static final String ALL_CHARS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARS;
    private static final int LENGTH = 12;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(generateRandomString());
        }
    }

    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(LENGTH);

        // Ensure at least one character from each required set
        sb.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        sb.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        sb.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        sb.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

        // Fill the remaining characters
        for (int i = 4; i < LENGTH; i++) {
            sb.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }

        // Shuffle the characters to ensure randomness
        List<Character> charList = new ArrayList<>();
        for (char c : sb.toString().toCharArray()) {
            charList.add(c);
        }
        Collections.shuffle(charList, random);

        // Convert the list back to a string
        StringBuilder result = new StringBuilder(LENGTH);
        for (char c : charList) {
            result.append(c);
        }

        return result.toString();
    }
}