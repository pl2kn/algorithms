package com.pl2kn.algorithms.collection.list;

/**
 * Doubly Linked Node implementation. Used in Doubly Linked List.
 *
 * @param <T> item type
 */
public class DoublyLinkedNode<T extends Comparable<T>> extends Node<T> {

  private DoublyLinkedNode<T> nextNode;

  private DoublyLinkedNode<T> previousNode;

  public DoublyLinkedNode(T item) {
    super(item);
  }

  public DoublyLinkedNode<T> getNextNode() {
    return nextNode;
  }

  public void setNextNode(DoublyLinkedNode<T> nextNode) {
    this.nextNode = nextNode;
  }

  public DoublyLinkedNode<T> getPreviousNode() {
    return previousNode;
  }

  public void setPreviousNode(DoublyLinkedNode<T> previousNode) {
    this.previousNode = previousNode;
  }
}
