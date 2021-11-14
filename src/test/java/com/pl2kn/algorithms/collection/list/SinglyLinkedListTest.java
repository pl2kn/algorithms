package com.pl2kn.algorithms.collection.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {

  @Test
  public void Size_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    singlyLinkedList.addFirst(1);
    singlyLinkedList.addFirst(2);
    singlyLinkedList.addFirst(3);

    assertEquals(3, singlyLinkedList.getSize());
  }

  @Test
  public void Add_To_Beginning_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    singlyLinkedList.addFirst(1);
    singlyLinkedList.addFirst(2);

    Integer head = 3;
    singlyLinkedList.addFirst(head);

    assertEquals(head, singlyLinkedList.getHead().getItem());
  }

  @Test
  public void Add_To_End_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    Integer head = 1;
    singlyLinkedList.addLast(head);
    singlyLinkedList.addLast(2);
    singlyLinkedList.addLast(3);

    assertEquals(head, singlyLinkedList.getHead().getItem());
  }

  @Test
  public void One_Element_Head_And_Tail_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    Integer head = 3;
    singlyLinkedList.addFirst(head);

    assertEquals(head, singlyLinkedList.getHead().getItem());
    assertEquals(head, singlyLinkedList.getTail().getItem());
  }

  @Test
  public void Delete_Single_Node_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    Integer singleNode = 1;
    singlyLinkedList.addFirst(singleNode);
    singlyLinkedList.delete(singleNode);

    assertEquals(0, singlyLinkedList.getSize());
    assertNull(singlyLinkedList.getHead());
    assertNull(singlyLinkedList.getTail());
  }

  @Test
  public void Delete_Head_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    Integer item1 = 1;
    Integer item2 = 2;
    Integer item3 = 3;
    Integer item4 = 4;

    singlyLinkedList.addLast(item1);
    singlyLinkedList.addLast(item2);
    singlyLinkedList.addLast(item3);
    singlyLinkedList.addLast(item4);

    singlyLinkedList.delete(item1);

    assertEquals(3, singlyLinkedList.getSize());
    assertEquals(item2, singlyLinkedList.getHead().getItem());
  }

  @Test
  public void Delete_Tail_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    Integer item1 = 1;
    Integer item2 = 2;
    Integer item3 = 3;
    Integer item4 = 4;

    singlyLinkedList.addLast(item1);
    singlyLinkedList.addLast(item2);
    singlyLinkedList.addLast(item3);
    singlyLinkedList.addLast(item4);

    singlyLinkedList.delete(item4);

    assertEquals(3, singlyLinkedList.getSize());
    assertEquals(item3, singlyLinkedList.getTail().getItem());
  }

  @Test
  public void Contains_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    singlyLinkedList.addFirst(1);
    singlyLinkedList.addFirst(2);
    singlyLinkedList.addFirst(3);

    assertTrue(singlyLinkedList.contains(3));
  }

  @Test
  public void Not_Contain_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    singlyLinkedList.addFirst(1);
    singlyLinkedList.addFirst(2);
    singlyLinkedList.addFirst(3);

    assertFalse(singlyLinkedList.contains(6));
  }
  
  @Test
  public void Add_After_Middle_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    Integer item1 = 1;
    Integer item2 = 2;
    Integer item3 = 3;
    Integer item4 = 4;
    Integer item5 = 5;

    singlyLinkedList.addLast(item1);
    singlyLinkedList.addLast(item2);
    singlyLinkedList.addLast(item3);
    singlyLinkedList.addLast(item4);

    SinglyLinkedNode<Integer> current = singlyLinkedList.getHead();
    SinglyLinkedNode<Integer> node = null;
    while (current != null) {
      if (current.getItem().compareTo(item2) == 0) {
        node = current;
        break;
      }
      current = current.getNextNode();
    }

    singlyLinkedList.addAfter(node, item5);

    assertTrue(isItemBetweenItems(singlyLinkedList, item2, item3, item5));
  }

  @Test
  public void Add_After_Tail_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    Integer item1 = 1;
    Integer item2 = 2;
    Integer item3 = 3;
    Integer item4 = 4;
    Integer item5 = 5;

    singlyLinkedList.addLast(item1);
    singlyLinkedList.addLast(item2);
    singlyLinkedList.addLast(item3);
    singlyLinkedList.addLast(item4);

    SinglyLinkedNode<Integer> tail = singlyLinkedList.getTail();

    SinglyLinkedNode<Integer> current = singlyLinkedList.getHead();
    SinglyLinkedNode<Integer> node = null;
    while (current != null) {
      if (current.getItem().compareTo(item4) == 0) {
        node = current;
        break;
      }
      current = current.getNextNode();
    }

    singlyLinkedList.addAfter(node, item5);

    assertEquals(tail.getNextNode().getItem(), item5);
  }

  private boolean isItemBetweenItems(SinglyLinkedList<Integer> singlyLinkedList, Integer afterItem, Integer beforeItem, Integer item) {
    SinglyLinkedNode<Integer> current = singlyLinkedList.getHead();
    while (current != null) {
      if (current.getItem().compareTo(afterItem) == 0) {
        if (current.getNextNode().getItem().compareTo(item) != 0) {
          return false;
        }
        return current.getNextNode().getNextNode().getItem().compareTo(beforeItem) == 0;
      }
      current = current.getNextNode();
    }

    return false;
  }
}
