package com.pl2kn.algorithms.collection.list;

public class ResizingArrayQueueTest extends QueueTest {

  @Override
  Queue<Integer> createQueue() {
    return new ResizingArrayQueue<>();
  }
}
