package com.pl2kn.algorithms.collection.list;

/**
 * Resizing Array Queue Implementation.
 *
 * @param <T> item type
 */
public class ResizingArrayQueue<T> implements Queue<T> {

  private T[] items;

  private int size;

  private int firstIndex;

  public ResizingArrayQueue() {
    items = (T[]) new Object[1];
  }

  @Override
  public void enqueue(T item) {
    if (items.length == size) {
      resize(2 * items.length);
    }

    items[firstIndex + size++] = item;
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      return null;
    }

    final T item = items[firstIndex];
    items[firstIndex++] = null;
    size--;

    if (size > 0 && size == items.length / 4) {
      resize(items.length / 2);
      firstIndex = 0;
    }

    return item;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  private void resize(int capacity) {
    T[] newItems = (T[]) new Object[capacity];
    for (int i = 0; i < size; i++) {
      newItems[i] = items[firstIndex + i];
    }

    items = newItems;
  }
}
