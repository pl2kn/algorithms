package com.pl2kn.algorithms.sort;

/**
 * Quick Sort Implementation.
 */
public class QuickSort extends Sort {

  @Override
  public <T extends Comparable<T>> void sort(T[] array) {
    sort(array, 0, array.length - 1);
  }

  public <T extends Comparable<T>> void sort(T[] array, int left, int right) {
    if (left >= right) {
      return;
    }

    int index = partition(array, left, right);
    sort(array, left, index);
    sort(array, index + 1, right);
  }

  private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
    int i = left;
    int j = right + 1;

    while (i <= j) {
      while (array[++i].compareTo(array[left]) < 0) {
        if (i == right) {
          break;
        }
      }

      while (array[--j].compareTo(array[left]) > 0) {
        if (j == left) {
          break;
        }
      }

      if (i < j) {
        swap(array, i, j);
      }
    }

    swap(array, left, j);

    return j;
  }
}
