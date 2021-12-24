package com.pl2kn.algorithms.collection.list;

/**
 * Indexed Min Priority Queue implementation.
 *
 * @param <T> the item type
 */
public class IndexedMinPriorityQueue<T extends Comparable<T>> {

  private final T[] items;
  private final int[] heap;
  private final int[] heapIndexes;
  private int size;

  public IndexedMinPriorityQueue(int n) {
    items = (T[]) new Comparable[n];
    heap = new int[n + 1];
    heapIndexes = new int[n];
  }

  /**
   * Inserts the item at index i in the queue and reorder the queue.
   *
   * @param i    the index
   * @param item the item
   */
  public void insert(int i, T item) {
    if (contains(i)) {
      throw new IllegalArgumentException("index is already in the priority queue");
    }
    items[i] = item;
    heap[++size] = i;
    heapIndexes[i] = size;
    swim(size);
  }

  /**
   * Updates the item at index i in the queue and reorder the queue.
   *
   * @param i    the index
   * @param item the item
   */
  public void update(int i, T item) {
    T oldItem = items[i];
    if (item.compareTo(oldItem) == 0) {
      return;
    }
    items[i] = item;
    int index = heapIndexes[i];
    if (item.compareTo(oldItem) > 0) {
      sink(index);
    } else {
      swim(index);
    }
  }

  /**
   * Deletes and returns the index of the min item of the queue.
   *
   * @return the index of the min item
   */
  public int delMin() {
    int minIndex = heap[1];
    heap[1] = heap[size--];
    heapIndexes[minIndex] = -1;
    items[minIndex] = null;
    sink(1);
    return minIndex;
  }

  private boolean contains(int i) {
    return items[i] != null;
  }

  private void swim(int k) {
    while (k > 1 && less(k, k / 2)) {
      swap(k, k / 2);
      k /= 2;
    }
  }

  private void sink(int k) {
    while (k * 2 <= size) {
      int child = k * 2;
      if (child < size && less(child + 1, child)) {
        child++;
      }
      if (!less(child, k)) {
        break;
      }
      swap(k, child);
      k = child;
    }
  }

  private boolean less(int i, int j) {
    return items[heap[i]].compareTo(items[heap[j]]) < 0;
  }

  private void swap(int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
    heapIndexes[heap[i]] = i;
    heapIndexes[heap[j]] = j;
  }
}
