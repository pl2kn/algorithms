package com.pl2kn.algorithms.collection.list;

/**
 * Max Binary Heap Implementation.
 *
 * @param <T> node type
 */
public class MaxBinaryHeap<T extends Comparable<T>> implements MaxPriorityQueue<T> {

  private final T[] nodes;

  private int size;

  public MaxBinaryHeap(int n) {
    nodes = (T[]) new Comparable[n];
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void insert(T item) {
    nodes[++size] = item;
    swim(size);
  }

  @Override
  public T delMax() {
    final T max = nodes[1];
    swap(1, size--);
    sink(1);
    nodes[size + 1] = null;
    return max;
  }

  @Override
  public int size() {
    return size;
  }

  private void swim(int k) {
    while (k > 1 && less(parent(k), k)) {
      swap(k, parent(k));
      k /= 2;
    }
  }

  private void sink(int k) {
    while (k * 2 <= size) {
      int child = k * 2;
      if (child < size && less(child, child + 1)) {
        child++;
      }
      if (!less(k, child)) {
        break;
      }
      swap(k, child);
      k = child;
    }
  }

  private int parent(int k) {
    return k / 2;
  }

  private void swap(int i, int j) {
    T temp = nodes[i];
    nodes[i] = nodes[j];
    nodes[j] = temp;
  }

  private boolean less(int i, int j) {
    return nodes[i].compareTo(nodes[j]) < 0;
  }
}
