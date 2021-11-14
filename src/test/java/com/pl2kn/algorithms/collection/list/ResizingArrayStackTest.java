package com.pl2kn.algorithms.collection.list;

public class ResizingArrayStackTest extends StackTest {

  @Override
  public Stack<Integer> createStack() {
    return new ResizingArrayStack<>();
  }
}
