package com.pl2kn.algorithms.collection.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MinBinaryHeapTest {

  @Test
  public void Symmetric_Test() {
    MinBinaryHeap<Integer> heap = new MinBinaryHeap<>(15);
    heap.add(2);
    heap.add(6);
    heap.add(8);
    heap.add(15);
    heap.add(1);
    heap.add(60);
    heap.add(9);
    heap.add(100);
    heap.add(5);
    heap.add(11);
    heap.add(23);
    heap.add(33);
    heap.add(16);
    heap.add(7);
    heap.add(29);
    assertEquals(1, heap.poll());
    assertEquals(2, heap.poll());
    assertEquals(5, heap.poll());
    assertEquals(6, heap.poll());
    assertEquals(7, heap.poll());
    assertEquals(8, heap.poll());
    assertEquals(9, heap.poll());
    assertEquals(11, heap.poll());
    assertEquals(15, heap.poll());
    assertEquals(16, heap.poll());
    assertEquals(23, heap.poll());
    assertEquals(29, heap.poll());
    assertEquals(33, heap.poll());
    assertEquals(60, heap.poll());
    assertEquals(100, heap.poll());
  }
}
