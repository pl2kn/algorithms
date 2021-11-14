package com.pl2kn.algorithms.collection.list;

/**
 * Linked List implementation.
 *
 * @param <T> item type
 */
public class SinglyLinkedList<T extends Comparable<T>> {

  private SinglyLinkedNode<T> head;

  private SinglyLinkedNode<T> tail;

  private int size;

  public int getSize() {
    return size;
  }

  public SinglyLinkedNode<T> getHead() {
    return head;
  }

  public SinglyLinkedNode<T> getTail() {
    return tail;
  }

  /**
   * Inserts the item at the beginning of the list.
   *
   * @param item Item added
   */
  public void addFirst(T item) {
    SinglyLinkedNode<T> newNode = new SinglyLinkedNode<>(item);

    if (head == null) {
      tail = newNode;
    }

    newNode.setNextNode(head);
    head = newNode;

    size++;
  }

  /**
   * Inserts the new item to the end of the list.
   *
   * @param item Item added
   */
  public void addLast(T item) {
    SinglyLinkedNode<T> newItem = new SinglyLinkedNode<>(item);

    if (head == null) {
      head = newItem;
    } else {
      tail.setNextNode(newItem);
    }
    tail = newItem;

    size++;
  }

  /**
   * Inserts the item after the node.
   *
   * @param node existing Node
   * @param item item added
   */
  public void addAfter(SinglyLinkedNode<T> node, T item) {
    if (node == null) {
      return;
    }

    SinglyLinkedNode<T> newNode = new SinglyLinkedNode<>(item);
    newNode.setNextNode(node.getNextNode());
    node.setNextNode(newNode);
  }

  /**
   * Deletes the first occurrence of the given item.
   *
   * @param item Item deleted
   */
  public void delete(T item) {
    if (head == null) {
      return;
    }

    SinglyLinkedNode<T> currentNode = head;
    SinglyLinkedNode<T> previousNode = null;

    while (currentNode != null) {
      if (currentNode.getItem().compareTo(item) == 0) {
        if (previousNode == null) {
          head = head.getNextNode();

          if (head == null) {
            tail = null;
          }
        } else {
          previousNode.setNextNode(currentNode.getNextNode());

          if (currentNode.getNextNode() == null) {
            tail = previousNode;
          }
        }

        size--;
        return;
      }

      previousNode = currentNode;
      currentNode = currentNode.getNextNode();
    }
  }

  /**
   * Checks whether the item is present in the linked list.
   *
   * @param item checked item
   * @return whether the item exists or not
   */
  public boolean contains(T item) {
    SinglyLinkedNode<T> currentItem = head;

    while (currentItem != null) {
      if (currentItem.getItem().compareTo(item) == 0) {
        return true;
      }

      currentItem = currentItem.getNextNode();
    }

    return false;
  }
}
