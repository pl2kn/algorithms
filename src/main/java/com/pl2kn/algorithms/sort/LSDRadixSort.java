package com.pl2kn.algorithms.sort;

/**
 * Least-Significant-Digit-First Radix Sort implementation.
 */
public class LSDRadixSort {

  /**
   * Sort the array of the fixedLength length strings.
   *
   * @param strings     the array of strings
   * @param fixedLength the length of strings
   */
  public static void sort(String[] strings, int fixedLength) {
    int radix = 256;
    int n = strings.length;
    String[] aux = new String[n];
    for (int d = fixedLength - 1; d >= 0; d--) {
      int[] count = new int[radix + 1];
      for (int i = 0; i < n; i++) {
        count[strings[i].charAt(d) + 1]++;
      }
      for (int r = 0; r < radix; r++) {
        count[r + 1] += count[r];
      }
      for (int i = 0; i < n; i++) {
        aux[count[strings[i].charAt(d)]++] = strings[i];
      }
      for (int i = 0; i < n; i++) {
        strings[i] = aux[i];
      }
    }
  }
}
