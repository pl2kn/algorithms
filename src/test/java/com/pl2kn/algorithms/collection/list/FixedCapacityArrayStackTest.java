package com.pl2kn.algorithms.collection.list;

public class FixedCapacityArrayStackTest extends StackTest {

  @Override
  public Stack<Integer> createStack() {
    return new FixedCapacityArrayStack<>(100);
  }
}
