package com.pl2kn.algorithms.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class DigraphTest {

  @Test
  public void Simple_Test() {
    Digraph graph = new Digraph(13);

    graph.addEdge(0, 5);
    graph.addEdge(0, 1);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 5);
    graph.addEdge(3, 2);
    graph.addEdge(4, 3);
    graph.addEdge(4, 2);
    graph.addEdge(5, 4);

    assertEquals(13, graph.V());
    assertEquals(9, graph.E());

    ArrayList<Integer> expectedAdj = new ArrayList<>();
    expectedAdj.add(4);
    int adjCount = 0;
    for (Integer adj : graph.adj(5)) {
      assertTrue(expectedAdj.contains(adj));
      adjCount++;
    }
    assertEquals(expectedAdj.size(), adjCount);
  }
}

