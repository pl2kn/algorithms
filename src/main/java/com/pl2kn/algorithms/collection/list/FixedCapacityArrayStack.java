package com.pl2kn.algorithms.collection.list;

/**
 * Stack using fixed size array implementation.
 *
 * @param <T> item type
 */
public class FixedCapacityArrayStack<T> implements Stack<T> {

  private T[] items;

  private int size;

  public FixedCapacityArrayStack(int capacity) {
    items = (T[]) new Object[capacity];
  }

  @Override
  public void push(T item) {
    items[size++] = item;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      return null;
    }

    return items[--size];
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }
}
