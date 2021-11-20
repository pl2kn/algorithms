package com.pl2kn.algorithms.sort;

/**
 * 3-Way(Dutch Flag) Quick Sort implementation.
 */
public class QuickSort3Way extends Sort {

  @Override
  public <T extends Comparable<T>> void sort(T[] array) {
    sort(array, 0, array.length - 1);
  }

  private <T extends Comparable<T>> void sort(T[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    int lessIndex = left;
    int greaterIndex = right;
    int i = left;
    T pivot = array[left];
    while (i <= greaterIndex) {
      int comp = array[i].compareTo(pivot);
      if (comp < 0) {
        swap(array, i++, lessIndex++);
      } else if (comp > 0) {
        swap(array, i, greaterIndex--);
      } else {
        i++;
      }
    }
    sort(array, left, lessIndex - 1);
    sort(array, greaterIndex + 1, right);
  }
}
