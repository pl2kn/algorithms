package com.pl2kn.algorithms.collection.list;

public class UnorderedMaxPQTest extends MaxPriorityQueueTest {

  @Override
  public MaxPriorityQueue<Integer> createQueue() {
    return new UnorderedMaxPriorityQueue<>(100);
  }
}
