package com.pl2kn.algorithms.collection.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class IndexedMinPriorityQueueTest {

  @Test
  public void Simple_Test() {
    IndexedMinPriorityQueue<Integer> queue = new IndexedMinPriorityQueue<>(15);
    queue.insert(0, 4);
    queue.insert(1, 1);
    queue.insert(2, 33);
    queue.insert(3, 12);
    queue.insert(4, 100);
    queue.insert(5, 8);
    queue.insert(6, 60);
    queue.insert(7, 19);
    queue.insert(8, 27);
    queue.insert(9, 44);
    queue.insert(10, 31);
    queue.insert(11, 21);
    queue.insert(12, 55);
    queue.insert(13, 5);
    queue.insert(14, 88);

    assertEquals(queue.delMin(), 1);
    assertEquals(queue.delMin(), 0);
    assertEquals(queue.delMin(), 13);
    assertEquals(queue.delMin(), 5);
    assertEquals(queue.delMin(), 3);
    assertEquals(queue.delMin(), 7);
    assertEquals(queue.delMin(), 11);
    assertEquals(queue.delMin(), 8);
    assertEquals(queue.delMin(), 10);
    assertEquals(queue.delMin(), 2);
    assertEquals(queue.delMin(), 9);
    assertEquals(queue.delMin(), 12);
    assertEquals(queue.delMin(), 6);
    assertEquals(queue.delMin(), 14);
    assertEquals(queue.delMin(), 4);
  }

  @Test
  public void Update_Less_Then_Parent_Test() {
    IndexedMinPriorityQueue<Integer> queue = new IndexedMinPriorityQueue<>(15);
    queue.insert(0, 4);
    queue.insert(1, 1);
    queue.insert(2, 33);
    queue.insert(3, 12);
    queue.insert(4, 100);
    queue.insert(5, 8);
    queue.insert(6, 60);
    queue.insert(7, 19);
    queue.insert(8, 27);
    queue.insert(9, 44);
    queue.insert(10, 31);
    queue.insert(11, 21);
    queue.insert(12, 55);
    queue.insert(13, 5);
    queue.insert(14, 88);

    queue.update(10, 0);
    assertEquals(queue.delMin(), 10);
    assertEquals(queue.delMin(), 1);
    assertEquals(queue.delMin(), 0);
  }

  @Test
  public void Update_Greater_Then_Child_Test() {
    IndexedMinPriorityQueue<Integer> queue = new IndexedMinPriorityQueue<>(15);
    queue.insert(0, 4);
    queue.insert(1, 1);
    queue.insert(2, 33);
    queue.insert(3, 12);
    queue.insert(4, 100);
    queue.insert(5, 8);
    queue.insert(6, 60);
    queue.insert(7, 19);
    queue.insert(8, 27);
    queue.insert(9, 44);
    queue.insert(10, 31);
    queue.insert(11, 21);
    queue.insert(12, 55);
    queue.insert(13, 5);
    queue.insert(14, 88);

    queue.update(1, 7);
    assertEquals(queue.delMin(), 0);
    assertEquals(queue.delMin(), 13);
    assertEquals(queue.delMin(), 1);
  }
}
