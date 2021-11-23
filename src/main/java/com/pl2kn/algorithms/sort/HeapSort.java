package com.pl2kn.algorithms.sort;

/**
 * Heap Sort Implementation.
 */
public class HeapSort extends Sort {

  @Override
  public <T extends Comparable<T>> void sort(T[] array) {
    int n = array.length;
    for (int i = n / 2 - 1; i >= 0; i--) {
      sink(array, n, i);
    }
    while (n > 0) {
      swap(array, 0, n - 1);
      sink(array, --n, 0);
    }
  }

  private <T extends Comparable<T>> void sink(T[] array, int n, int k) {
    int largest = k;
    int leftChild = k * 2 + 1;
    int rightChild = k * 2 + 2;
    if (leftChild < n && greater(array, leftChild, largest)) {
      largest = leftChild;
    }
    if (rightChild < n && greater(array, rightChild, largest)) {
      largest = rightChild;
    }
    if (largest != k) {
      swap(array, k, largest);
      sink(array, n, largest);
    }
  }
}
