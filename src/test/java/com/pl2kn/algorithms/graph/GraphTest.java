package com.pl2kn.algorithms.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class GraphTest {

  @Test
  public void Simple_Test() {
    Graph graph = new Graph(10);

    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(0, 3);

    assertEquals(10, graph.vertexCount());
    assertEquals(3, graph.getEdgeCount());

    ArrayList<Integer> expectedAdj = new ArrayList<>();
    expectedAdj.add(1);
    expectedAdj.add(2);
    expectedAdj.add(3);
    int adjCount = 0;
    for (Integer adj : graph.adj(0)) {
      assertTrue(expectedAdj.contains(adj));
      adjCount++;
    }
    assertEquals(expectedAdj.size(), adjCount);
  }
}
