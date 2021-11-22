package com.pl2kn.algorithms.collection.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class MaxPriorityQueueTest {

  public abstract MaxPriorityQueue<Integer> createQueue();

  @Test
  public void Five_Elements_Max_Priority_Queue_Test() {
    MaxPriorityQueue<Integer> queue = createQueue();

    Integer[] array = {1, 3, 15, 5, 2, 5, 7};
    int minCount = 3;
    for (Integer integer : array) {
      queue.insert(integer);
      if (queue.size() > minCount) {
        queue.delMax();
      }
    }

    assertEquals(3, queue.delMax());
    assertEquals(2, queue.delMax());
    assertEquals(1, queue.delMax());
    assertTrue(queue.isEmpty());
  }

  @Test
  public void Duplicates_Test() {
    MaxPriorityQueue<Integer> queue = createQueue();

    Integer[] array = {2, 2, 2, 2, 2, 2, 2};
    int minCount = 3;
    for (Integer integer : array) {
      queue.insert(integer);
      if (queue.size() > minCount) {
        queue.delMax();
      }
    }

    assertEquals(2, queue.delMax());
    assertEquals(2, queue.delMax());
    assertEquals(2, queue.delMax());
    assertTrue(queue.isEmpty());
  }
}
