package com.pl2kn.algorithms.collection.list;

/**
 * Resizing Array Stack Implementation.
 *
 * @param <T> item type
 */
public class ResizingArrayStack<T> implements Stack<T> {

  private T[] items;

  private int size;

  public ResizingArrayStack() {
    items = (T[]) new Object[1];
  }

  @Override
  public void push(T item) {
    if (items.length == size) {
      resize(2 * items.length);
    }

    items[size++] = item;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      return null;
    }

    T item = items[--size];
    items[size] = null;

    if (size > 0 && size < items.length / 4) {
      resize(items.length / 2);
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
      newItems[i] = items[i];
    }

    items = newItems;
  }
}
