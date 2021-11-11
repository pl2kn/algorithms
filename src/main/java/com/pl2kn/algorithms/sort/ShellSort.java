package com.pl2kn.algorithms.sort;

/**
 * Shell sort implementation. Gap sequence used here was offered by Knuth.
 */
public class ShellSort extends Sort {

  @Override
  public <T extends Comparable<T>> void sort(T[] array) {
    int n = array.length;

    int h = 1;
    while (h < n / 3) {
      h = h * 3 + 1;
    }

    while (h >= 1) {
      for (int i = h; i < n; i++) {
        for (int j = i; j >= h && array[j].compareTo(array[j - h]) < 0; j -= h) {
          swap(array, j, j - h);
        }
      }

      h = h / 3;
    }
  }
}
