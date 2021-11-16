package com.pl2kn.algorithms.fundamentals;

/**
 * Recursive Binary Search implementation.
 */
public class BinarySearchRecursive implements Search {

  public int search(int[] array, int target) {
    return search(array, 0, array.length - 1, target);
  }

  private int search(int[] array, int low, int high, int target) {
    if (low <= high) {
      int mid = low + (high - low) / 2;

      if (target == array[mid]) {
        return mid;
      }

      if (target < array[mid]) {
        return search(array, low, mid - 1, target);
      }

      return search(array, mid + 1, high, target);
    }

    return -1;
  }
}
