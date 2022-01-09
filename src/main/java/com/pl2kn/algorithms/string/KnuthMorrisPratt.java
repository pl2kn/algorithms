package com.pl2kn.algorithms.string;

public class KnuthMorrisPratt {

    private final int patternLength;
    private int[][] dfa;

    public KnuthMorrisPratt(String pattern) {
        int radix = 256;
        this.patternLength = pattern.length();

        dfa = new int[radix][patternLength];
        dfa[pattern.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < patternLength; j++) {
            for (int c = 0; c < radix; c++) {
                dfa[c][j] = dfa[c][x];
            }
            dfa[pattern.charAt(j)][j] = j + 1;
            x = dfa[pattern.charAt(j)][x];
        }
    }

    public int search(String text) {
        int n = text.length();
        int i;
        int j;
        for (i = 0, j = 0; i < n && j < patternLength; i++) {
            j = dfa[text.charAt(i)][j];
        }
        if (j == patternLength) {
            return i - patternLength;
        }
        return n;
    }
}
