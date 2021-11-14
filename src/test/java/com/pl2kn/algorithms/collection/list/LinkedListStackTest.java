package com.pl2kn.algorithms.collection.list;

public class LinkedListStackTest extends StackTest {

  @Override
  public Stack<Integer> createStack() {
    return new LinkedListStack<>();
  }
}
