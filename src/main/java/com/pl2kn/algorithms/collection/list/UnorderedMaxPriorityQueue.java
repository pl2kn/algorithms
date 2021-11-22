package com.pl2kn.algorithms.collection.list;

/**
 * Unordered Max Priority Queue implementation.
 *
 * @param <T> item type
 */
public class UnorderedMaxPriorityQueue<T extends Comparable<T>> implements MaxPriorityQueue<T> {

  private T[] items;

  private int size;

  public UnorderedMaxPriorityQueue(int n) {
    items = (T[]) new Comparable[n];
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void insert(T item) {
    items[size++] = item;
  }

  @Override
  public T delMax() {
    int max = 0;
    for (int i = 0; i < size; i++) {
      if (items[i].compareTo(items[max]) > 0) {
        max = i;
      }
    }
    T temp = items[size - 1];
    items[size - 1] = items[max];
    items[max] = temp;

    return items[--size];
  }

  @Override
  public int size() {
    return size;
  }
}
