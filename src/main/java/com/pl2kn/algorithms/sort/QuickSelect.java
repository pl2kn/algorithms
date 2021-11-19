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
    int pivot = array[right];
    int index = left - 1;
    for (int i = left; i < right; i++) {
      if (array[i] < pivot) {
        swap(array, ++index, i);
      }
    }
    swap(array, index + 1, right);
    return index + 1;
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
