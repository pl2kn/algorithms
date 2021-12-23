package com.pl2kn.algorithms.collection.list;

/**
 * Min Binary Heap long implementation.
 *
 * @param <T> the item type
 */
public class MinBinaryHeap<T extends Comparable<T>> {

  private final T[] items;
  private int size;

  public MinBinaryHeap(int n) {
    items = (T[]) new Comparable[n];
  }

  public void add(T item) {
    items[size++] = item;
    heapifyUp();
  }

  /**
   * Returns the min item without deleting.
   *
   * @return the min item
   */
  public T peek() {
    if (size == 0) {
      throw new IllegalStateException();
    }
    return items[0];
  }

  /**
   * Returns and delete the min item.
   *
   * @return the min item
   */
  public T poll() {
    if (size == 0) {
      throw new IllegalStateException();
    }
    T min = items[0];
    items[0] = items[--size];
    heapifyDown();
    return min;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private void heapifyUp() {
    int index = size - 1;
    while (hasParent(index) && greater(getParentIndex(index), index)) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }

  private void heapifyDown() {
    int index = 0;
    while (hasLeftChild(index)) {
      int smallestChildIndex = getLeftChildIndex(index);
      if (hasRightChild(index) && less(getRightChildIndex(index), smallestChildIndex)) {
        smallestChildIndex = getRightChildIndex(index);
      }
      if (less(index, smallestChildIndex)) {
        break;
      }
      swap(index, smallestChildIndex);
      index = smallestChildIndex;
    }
  }

  private int getLeftChildIndex(int index) {
    return index * 2 + 1;
  }

  private int getRightChildIndex(int index) {
    return index * 2 + 2;
  }

  private int getParentIndex(int index) {
    return (index - 1) / 2;
  }

  private boolean hasLeftChild(int index) {
    return getLeftChildIndex(index) < size;
  }

  private boolean hasRightChild(int index) {
    return getRightChildIndex(index) < size;
  }

  private boolean hasParent(int index) {
    return getParentIndex(index) >= 0;
  }

  private boolean greater(int i, int j) {
    return items[i].compareTo(items[j]) > 0;
  }

  private boolean less(int i, int j) {
    return items[i].compareTo(items[j]) < 0;
  }

  private void swap(int i, int j) {
    T temp = items[i];
    items[i] = items[j];
    items[j] = temp;
  }
}
