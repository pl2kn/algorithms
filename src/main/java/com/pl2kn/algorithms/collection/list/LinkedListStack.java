package com.pl2kn.algorithms.collection.list;

/**
 * Linked List implementation of Stack.
 *
 * @param <T> item type.
 */
public class LinkedListStack<T> implements Stack<T> {

  private SinglyLinkedNode<T> first;

  @Override
  public void push(T item) {
    SinglyLinkedNode<T> newFirst = new SinglyLinkedNode<>(item);

    newFirst.setNextNode(first);
    first = newFirst;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      return null;
    }

    T item = first.getItem();
    first = first.getNextNode();
    return item;
  }

  @Override
  public boolean isEmpty() {
    return first == null;
  }
}
