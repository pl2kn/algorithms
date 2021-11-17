package com.pl2kn.algorithms.sort;

/**
 * Merge Bottom Up Sort implementation.
 */
public class MergeBottomUpSort extends MergeSort {

  @Override
  public <T extends Comparable<T>> void sort(T[] array) {
    int n = array.length;
    for (int length = 1; length < n; length *= 2) {
      for (int low = 0; low < n - length; low += length * 2) {
        int high = Math.min(low + length * 2 - 1, n - 1);
        merge(array, low, low + length - 1, high);
      }
    }
  }
}
