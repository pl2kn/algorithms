package com.pl2kn.algorithms.sort;

/**
 * Bubble Sort implementation.
 */
public class BubbleSort extends Sort {

  @Override
  public <T extends Comparable<T>> void sort(T[] array) {
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (array[j].compareTo(array[j + 1]) > 0) {
          swap(array, j, j + 1);
        }
      }
    }
  }
}
