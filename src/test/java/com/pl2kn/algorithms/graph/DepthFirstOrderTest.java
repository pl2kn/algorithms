package com.pl2kn.algorithms.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class DepthFirstOrderTest {

  @Test
  public void Topological_Sort_Test() {
    Digraph digraph = new Digraph(7);

    digraph.addEdge(0, 1);
    digraph.addEdge(0, 5);
    digraph.addEdge(0, 2);
    digraph.addEdge(3, 6);
    digraph.addEdge(3, 5);
    digraph.addEdge(3, 4);
    digraph.addEdge(5, 2);
    digraph.addEdge(6, 4);
    digraph.addEdge(6, 0);
    digraph.addEdge(3, 2);
    digraph.addEdge(1, 4);

    Stack<Integer> expectedOrder = new Stack<>();
    expectedOrder.add(3);
    expectedOrder.add(6);
    expectedOrder.add(0);
    expectedOrder.add(5);
    expectedOrder.add(2);
    expectedOrder.add(1);
    expectedOrder.add(4);

    DepthFirstOrder dfo = new DepthFirstOrder(digraph);

    assertEquals(expectedOrder, dfo.reversedPost());
  }
}
