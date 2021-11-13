package com.pl2kn.algorithms.list;

import static org.junit.jupiter.api.Assertions.*;

import com.pl2kn.algorithms.collection.list.SinglyLinkedList;
import com.pl2kn.algorithms.collection.list.SinglyLinkedNode;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

  @Test
  public void Size_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    singlyLinkedList.addToBeginning(1);
    singlyLinkedList.addToBeginning(2);
    singlyLinkedList.addToBeginning(3);

    assertEquals(3, singlyLinkedList.getSize());
  }

  @Test
  public void Add_To_Beginning_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    singlyLinkedList.addToBeginning(1);
    singlyLinkedList.addToBeginning(2);

    Integer head = 3;
    singlyLinkedList.addToBeginning(head);

    assertEquals(head, singlyLinkedList.getHead().getItem());
  }

  @Test
  public void Add_To_End_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    Integer head = 1;
    singlyLinkedList.addToEnd(head);
    singlyLinkedList.addToEnd(2);
    singlyLinkedList.addToEnd(3);

    assertEquals(head, singlyLinkedList.getHead().getItem());
  }

  @Test
  public void One_Element_Head_And_Tail_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    Integer head = 3;
    singlyLinkedList.addToBeginning(head);

    assertEquals(head, singlyLinkedList.getHead().getItem());
    assertEquals(head, singlyLinkedList.getTail().getItem());
  }

  @Test
  public void Delete_Single_Node_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    Integer singleNode = 1;
    singlyLinkedList.addToBeginning(singleNode);
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

    singlyLinkedList.addToEnd(item1);
    singlyLinkedList.addToEnd(item2);
    singlyLinkedList.addToEnd(item3);
    singlyLinkedList.addToEnd(item4);

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

    singlyLinkedList.addToEnd(item1);
    singlyLinkedList.addToEnd(item2);
    singlyLinkedList.addToEnd(item3);
    singlyLinkedList.addToEnd(item4);

    singlyLinkedList.delete(item4);

    assertEquals(3, singlyLinkedList.getSize());
    assertEquals(item3, singlyLinkedList.getTail().getItem());
  }

  @Test
  public void Contains_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    singlyLinkedList.addToBeginning(1);
    singlyLinkedList.addToBeginning(2);
    singlyLinkedList.addToBeginning(3);

    assertTrue(singlyLinkedList.contains(3));
  }

  @Test
  public void Not_Contain_Test() {
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    singlyLinkedList.addToBeginning(1);
    singlyLinkedList.addToBeginning(2);
    singlyLinkedList.addToBeginning(3);

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

    singlyLinkedList.addToEnd(item1);
    singlyLinkedList.addToEnd(item2);
    singlyLinkedList.addToEnd(item3);
    singlyLinkedList.addToEnd(item4);

    singlyLinkedList.addAfter(item2, item5);

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

    singlyLinkedList.addToEnd(item1);
    singlyLinkedList.addToEnd(item2);
    singlyLinkedList.addToEnd(item3);
    singlyLinkedList.addToEnd(item4);

    SinglyLinkedNode<Integer> tail = singlyLinkedList.getTail();

    singlyLinkedList.addAfter(item4, item5);

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
