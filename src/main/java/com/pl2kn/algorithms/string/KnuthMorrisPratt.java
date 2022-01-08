package com.pl2kn.algorithms.string;

public class KnuthMorrisPratt {

    private final int R;
    private final int m;
    private int[][] dfa;

    public KnuthMorrisPratt(String pattern) {
        this.R = 256;
        this.m = pattern.length();

        // build DFA from pattern
        dfa = new int[R][m];
        dfa[pattern.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];
            dfa[pattern.charAt(j)][j] = j + 1;
            x = dfa[pattern.charAt(j)][x];
        }
    }
}
