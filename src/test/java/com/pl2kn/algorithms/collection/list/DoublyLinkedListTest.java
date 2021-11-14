package com.pl2kn.algorithms.collection.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

  @Test
  public void Add_First_Link_Order_Test() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    Integer[] ints = {1, 2, 3, 4, 5, 6};
    Integer[] actualInts = {6, 5, 4, 3, 2, 1};

    for (Integer anInt : ints) {
      list.addFirst(anInt);
    }

    assertTrue(checkLinks(list, actualInts));
  }

  @Test
  public void Add_Last_Link_Order_Test() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    Integer[] ints = {1, 2, 3, 4, 5, 6};

    for (Integer anInt : ints) {
      list.addLast(anInt);
    }

    assertTrue(checkLinks(list, ints));
  }

  @Test
  public void Add_After_Test() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    Integer[] ints = {1, 2, 3, 4, 5, 6};
    Integer[] actualInts = {1, 2, 7, 3, 4, 5, 6};

    for (Integer anInt : ints) {
      list.addLast(anInt);
    }

    DoublyLinkedNode<Integer> node = list.getHead().getNextNode();
    list.addAfter(node, 7);

    assertTrue(checkLinks(list, actualInts));
  }

  @Test
  public void Add_After_Tail_Test() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    Integer[] ints = {1, 2, 3, 4, 5, 6};
    Integer[] actualInts = {1, 2, 3, 4, 5, 6, 7};

    for (Integer anInt : ints) {
      list.addLast(anInt);
    }

    DoublyLinkedNode<Integer> node = list.getTail();
    list.addAfter(node, 7);

    assertTrue(checkLinks(list, actualInts));
  }

  @Test
  public void Add_Before_Test() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    Integer[] ints = {1, 2, 3, 4, 5, 6};
    Integer[] actualInts = {1, 2, 7, 3, 4, 5, 6};

    for (Integer anInt : ints) {
      list.addLast(anInt);
    }

    DoublyLinkedNode<Integer> node = list.getHead().getNextNode().getNextNode();
    list.addBefore(node, 7);

    assertTrue(checkLinks(list, actualInts));
  }

  @Test
  public void Add_Before_Head_Test() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    Integer[] ints = {1, 2, 3, 4, 5, 6};
    Integer[] actualInts = {7, 1, 2, 3, 4, 5, 6};

    for (Integer anInt : ints) {
      list.addLast(anInt);
    }

    DoublyLinkedNode<Integer> node = list.getHead();
    list.addBefore(node, 7);

    assertTrue(checkLinks(list, actualInts));
  }

  @Test
  public void Delete_Test() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    Integer[] ints = {1, 2, 3, 4, 5, 6};
    Integer[] actualInts = {1, 3, 4, 5, 6};

    for (Integer anInt : ints) {
      list.addLast(anInt);
    }

    DoublyLinkedNode<Integer> node = list.getHead().getNextNode();
    list.delete(node);

    assertTrue(checkLinks(list, actualInts));
  }

  @Test
  public void Delete_Head_Test() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    Integer[] ints = {1, 2, 3, 4, 5, 6};
    Integer[] actualInts = {2, 3, 4, 5, 6};

    for (Integer anInt : ints) {
      list.addLast(anInt);
    }

    DoublyLinkedNode<Integer> node = list.getHead();
    list.delete(node);

    assertTrue(checkLinks(list, actualInts));
  }

  @Test
  public void Delete_Tail_Test() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    Integer[] ints = {1, 2, 3, 4, 5, 6};
    Integer[] actualInts = {1, 2, 3, 4, 5};

    for (Integer anInt : ints) {
      list.addLast(anInt);
    }

    DoublyLinkedNode<Integer> node = list.getTail();
    list.delete(node);

    assertTrue(checkLinks(list, actualInts));
  }

  @Test
  public void Size_Test() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    Integer[] ints = {1, 2, 3, 4, 5, 6};

    for (Integer anInt : ints) {
      list.addLast(anInt);
    }

    assertEquals(6, list.getSize());
  }

  private boolean checkLinks(DoublyLinkedList<Integer> list, Integer[] orderedArray) {
    return checkLinksNormalOrder(list, orderedArray) && checkLinksReversedOrder(list, orderedArray);

  }

  private boolean checkLinksNormalOrder(DoublyLinkedList<Integer> list, Integer[] orderedArray) {
    DoublyLinkedNode<Integer> current = list.getHead();
    int i = 0;
    while (current != null) {
      if (current.getItem().compareTo(orderedArray[i]) != 0) {
        return false;
      }
      current = current.getNextNode();
      i++;
    }

    return true;
  }

  private boolean checkLinksReversedOrder(DoublyLinkedList<Integer> list, Integer[] orderedArray) {
    DoublyLinkedNode<Integer> current = list.getTail();
    int i = orderedArray.length - 1;
    while (current != null) {
      if (current.getItem().compareTo(orderedArray[i]) != 0) {
        return false;
      }
      current = current.getPreviousNode();
      i--;
    }

    return true;
  }
}
