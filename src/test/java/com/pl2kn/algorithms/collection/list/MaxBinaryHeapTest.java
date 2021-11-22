package com.pl2kn.algorithms.collection.list;

public class MaxBinaryHeapTest extends MaxPriorityQueueTest {

  @Override
  public MaxPriorityQueue<Integer> createQueue() {
    return new MaxBinaryHeap<>(100);
  }
}
