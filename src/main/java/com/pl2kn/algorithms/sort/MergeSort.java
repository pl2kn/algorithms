package com.pl2kn.algorithms.sort;

/**
 * Merge Sort implementation.
 */
public class MergeSort extends Sort {

  @Override
  public <T extends Comparable<T>> void sort(T[] array) {
    sort(array, 0, array.length - 1);
  }

  private <T extends Comparable<T>> void sort(T[] array, int low, int high) {
    if (high <= low) {
      return;
    }

    int mid = low + (high - low) / 2;
    sort(array, low, mid);
    sort(array, mid + 1, high);
    merge(array, low, mid, high);
  }

  private <T extends Comparable<T>> void merge(T[] array, int low, int mid, int high) {
    T[] tempArray = (T[]) new Comparable[array.length];
    for (int i = 0; i < array.length; i++) {
      tempArray[i] = array[i];
    }

    int i = low;
    int j = mid + 1;
    for (int k = low; k <= high; k++) {
      if (i > mid) {
        array[k] = tempArray[j++];
      } else if (j > high) {
        array[k] = tempArray[i++];
      } else if (tempArray[i].compareTo(tempArray[j]) < 0) {
        array[k] = tempArray[i++];
      } else {
        array[k] = tempArray[j++];
      }
    }
  }
}
