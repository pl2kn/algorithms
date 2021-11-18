package com.pl2kn.algorithms.sort;

abstract class Sort {

  public abstract <T extends Comparable<T>> void sort(T[] array);

  protected static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
