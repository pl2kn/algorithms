package com.pl2kn.algorithms.sort;

/**
 * Insertion Sort implementation.
 */
public class InsertionSort extends Sort {

  @Override
  public <T extends Comparable<T>> void sort(T[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = i; j > 0; j--) {
        if (array[j].compareTo(array[j - 1]) < 0) {
          swap(array, j, j - 1);
        } else {
          break;
        }
      }
    }
  }
}
