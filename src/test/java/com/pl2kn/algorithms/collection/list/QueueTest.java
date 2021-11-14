package com.pl2kn.algorithms.collection.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class QueueTest {

  abstract Queue<Integer> createQueue();

  @Test
  public void One_Item_Test() {
    Queue<Integer> queue = createQueue();

    queue.enqueue(1);
    assertEquals(1, queue.dequeue());
    assertTrue(queue.isEmpty());
  }

  @Test
  public void Several_Item_Test() {
    Queue<Integer> queue = createQueue();

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    assertEquals(1, queue.dequeue());
    assertEquals(2, queue.dequeue());
    assertEquals(3, queue.dequeue());
    assertEquals(4, queue.dequeue());
    assertEquals(5, queue.dequeue());
    assertTrue(queue.isEmpty());
  }

  @Test
  public void Mixed_Queue_Dequeue_Test() {
    Queue<Integer> queue = createQueue();

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    assertEquals(1, queue.dequeue());
    assertEquals(2, queue.dequeue());
    assertEquals(3, queue.dequeue());
    assertEquals(4, queue.dequeue());
    queue.enqueue(6);
    assertEquals(5, queue.dequeue());
    assertEquals(6, queue.dequeue());
    assertTrue(queue.isEmpty());
  }
}
