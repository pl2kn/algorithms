package com.pl2kn.algorithms.collection.list;

/**
 * Linked List Queue implementation.
 *
 * @param <T> item type
 */
public class LinkedListQueue<T> implements Queue<T> {

  private SinglyLinkedNode<T> first;

  private SinglyLinkedNode<T> last;

  @Override
  public void enqueue(T item) {
    SinglyLinkedNode<T> newNode = new SinglyLinkedNode<>(item);

    if (isEmpty()) {
      first = newNode;
    } else {
      last.setNextNode(newNode);
    }

    last = newNode;
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      return null;
    }

    T item = first.getItem();
    first = first.getNextNode();

    if (isEmpty()) {
      last = null;
    }

    return item;
  }

  @Override
  public boolean isEmpty() {
    return first == null;
  }
}
