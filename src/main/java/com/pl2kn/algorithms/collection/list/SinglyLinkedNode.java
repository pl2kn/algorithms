package com.pl2kn.algorithms.collection.list;

/**
 * Node used in Singly Linked List.
 *
 * @param <T> type of items
 */
public class SinglyLinkedNode<T> extends Node<T> {

  private SinglyLinkedNode<T> nextNode;

  public SinglyLinkedNode(T item) {
    super(item);
  }

  public SinglyLinkedNode<T> getNextNode() {
    return nextNode;
  }

  public void setNextNode(SinglyLinkedNode<T> nextNode) {
    this.nextNode = nextNode;
  }
}
