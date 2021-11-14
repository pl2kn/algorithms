package com.pl2kn.algorithms.collection.list;

public class LinkedListQueueTest extends QueueTest {

  @Override
  Queue<Integer> createQueue() {
    return new LinkedListQueue<>();
  }
}
