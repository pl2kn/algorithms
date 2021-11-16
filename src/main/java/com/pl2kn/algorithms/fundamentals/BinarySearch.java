package com.pl2kn.algorithms.fundamentals;

/**
 * Binary Search implementation.
 */
public class BinarySearch {

  /**
   * Returns the index of the item searched.
   *
   * @param array  an array of integers, must be sorted in ascending order
   * @param target an item searched
   * @return the index of the searched item
   */
  public int search(int[] array, int target) {
    int low = 0;
    int high = array.length;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (target == array[mid]) {
        return mid;
      }

      if (target < array[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return -1;
  }
}
