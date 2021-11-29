package com.pl2kn.algorithms.collection.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked List Queue implementation.
 *
 * @param <T> item type
 */
public class LinkedListQueue<T> implements Queue<T>, Iterable<T> {

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

  @Override
  public Iterator<T> iterator() {
    return new LinkedListQueueIterator(first);
  }

  private class LinkedListQueueIterator implements Iterator<T> {

    private SinglyLinkedNode<T> current;

    public LinkedListQueueIterator(SinglyLinkedNode<T> first) {
      current = first;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      T item = current.getItem();
      current = current.getNextNode();
      return item;
    }
  }
}
