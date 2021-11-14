package com.pl2kn.algorithms.collection.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class StackTest {

  public abstract Stack<Integer> createStack();

  @Test
  public void One_Element_Test() {
    Stack<Integer> stack = createStack();
    stack.push(1);

    assertFalse(stack.isEmpty());
    assertEquals(1, stack.pop());
    assertTrue(stack.isEmpty());
  }

  @Test
  public void Several_Element_Test() {
    Stack<Integer> stack = createStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    assertFalse(stack.isEmpty());
    assertEquals(5, stack.pop());
    assertEquals(4, stack.pop());
    assertEquals(3, stack.pop());
    assertEquals(2, stack.pop());
    assertEquals(1, stack.pop());
    assertTrue(stack.isEmpty());
  }

  @Test
  public void Empty_Stack_Test() {
    Stack<Integer> stack = createStack();

    assertTrue(stack.isEmpty());
    assertNull(stack.pop());
  }

  @Test
  public void Mixed_Push_Pop_Test() {
    Stack<Integer> stack = createStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    assertFalse(stack.isEmpty());
    assertEquals(5, stack.pop());
    assertEquals(4, stack.pop());
    stack.push(6);
    assertEquals(6, stack.pop());
    assertEquals(3, stack.pop());
    assertEquals(2, stack.pop());
    assertEquals(1, stack.pop());
    assertTrue(stack.isEmpty());
  }
}
