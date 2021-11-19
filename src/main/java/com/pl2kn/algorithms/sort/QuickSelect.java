package com.pl2kn.algorithms.sort;

/**
 * Quick Select implementation.
 */
public class QuickSelect {

  /**
   * Finds the k-th smallest element.
   *
   * @param array an array of integers
   * @param k     and index of element to me find
   * @return element
   */
  public static int select(int[] array, int k) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
      int index = partition(array, left, right);
      if (index == k) {
        return array[k];
      }
      if (k < index) {
        right = index - 1;
      } else {
        left = index + 1;
      }
    }

    return array[k];
  }

  private static int partition(int[] array, int left, int right) {
    int pivot = array[left];
    int index = left;
    for (int i = left + 1; i <= right; i++) {
      if (array[i] < pivot) {
        swap(array, ++index, i);
      }
    }
    swap(array, left, index);
    return index;
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
