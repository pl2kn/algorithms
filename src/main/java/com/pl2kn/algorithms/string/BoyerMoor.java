package com.pl2kn.algorithms.string;

public class BoyerMoor {

    private final int[] right;
    private final String pattern;

    public BoyerMoor(String pattern) {
        int radix = 256;
        this.pattern = pattern;
        right = new int[radix];
        for (int c = 0; c < radix; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < pattern.length(); j++) {
            right[pattern.charAt(j)] = j;
        }
    }

    public int search(String text) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int skip;
        for (int i = 0; i <= textLength - patternLength; i += skip) {
            skip = 0;
            for (int j = patternLength - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = Math.max(1, j - right[text.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) {
                return i;
            }
        }
        return textLength;
    }
}
