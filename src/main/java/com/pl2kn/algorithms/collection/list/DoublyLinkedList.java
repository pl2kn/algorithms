package com.pl2kn.algorithms.collection.list;

/**
 * Doubly Linked List Implementation.
 *
 * @param <T> item type
 */
public class DoublyLinkedList<T> {

  private DoublyLinkedNode<T> head;

  private DoublyLinkedNode<T> tail;

  private int size;

  public int getSize() {
    return size;
  }

  public DoublyLinkedNode<T> getHead() {
    return head;
  }

  public DoublyLinkedNode<T> getTail() {
    return tail;
  }

  /**
   * Inserts the item at the beginning of the list.
   *
   * @param item Item added
   */
  public void addFirst(T item) {
    DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(item);

    newNode.setNextNode(head);

    if (head != null) {
      head.setPreviousNode(newNode);
    } else {
      tail = newNode;
    }
    head = newNode;

    size++;
  }

  /**
   * Inserts the new item to the end of the list.
   *
   * @param item Item added
   */
  public void addLast(T item) {
    DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(item);

    if (head == null) {
      head = newNode;
    } else {
      tail.setNextNode(newNode);
      newNode.setPreviousNode(tail);
    }
    tail = newNode;

    size++;
  }

  /**
   * Inserts the item after the node.
   *
   * @param item Item added
   */
  public void addAfter(DoublyLinkedNode<T> node, T item) {
    if (node == null || head == null) {
      return;
    }

    DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(item);

    newNode.setNextNode(node.getNextNode());
    newNode.setPreviousNode(node);

    if (node != tail) {
      node.getNextNode().setPreviousNode(newNode);
    } else {
      tail = newNode;
    }

    node.setNextNode(newNode);

    size++;
  }

  /**
   * Inserts the item before the node.
   *
   * @param item Item added
   */
  public void addBefore(DoublyLinkedNode<T> node, T item) {
    if (node == null || head == null) {
      return;
    }

    DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(item);

    newNode.setNextNode(node);
    newNode.setPreviousNode(node.getPreviousNode());

    if (node != head) {
      node.getPreviousNode().setNextNode(newNode);
    } else {
      head = newNode;
    }

    node.setPreviousNode(newNode);

    size++;
  }

  /**
   * Deletes the node from the list.
   *
   * @param node node deleted
   */
  public void delete(DoublyLinkedNode<T> node) {
    if (node == null || head == null) {
      return;
    }

    if (node == head) {
      head = node.getNextNode();
    } else {
      node.getPreviousNode().setNextNode(node.getNextNode());
    }

    if (node == tail) {
      tail = node.getPreviousNode();
    } else {
      node.getNextNode().setPreviousNode(node.getPreviousNode());
    }

    size--;
  }

  /**
   * Checks whether the item is present in linked list.
   *
   * @param item item checked
   * @return whether item exists or not
   */
  public boolean contains(T item) {
    DoublyLinkedNode<T> currentItem = head;

    while (currentItem != null) {
      if (currentItem.getItem().equals(item)) {
        return true;
      }

      currentItem = currentItem.getNextNode();
    }

    return false;
  }
}
