package com.pl2kn.algorithms.graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ConnectedComponentsTest {

  @Test
  public void Test_Connected_Components() {
    ConnectedComponents cc = new ConnectedComponents(createGraph());
    assertEquals(3, cc.count());
    assertEquals(cc.id(0), cc.id(1));
    assertEquals(cc.id(4), cc.id(1));
    assertEquals(cc.id(6), cc.id(4));
    assertEquals(cc.id(7), cc.id(8));
    assertEquals(cc.id(9), cc.id(10));
    assertEquals(cc.id(11), cc.id(12));
    assertNotEquals(cc.id(1), cc.id(12));
    assertNotEquals(cc.id(2), cc.id(9));
  }

  private Graph createGraph() {
    Graph graph = new Graph(13);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(0, 6);
    graph.addEdge(0, 5);
    graph.addEdge(6, 4);
    graph.addEdge(4, 5);
    graph.addEdge(4, 3);
    graph.addEdge(3, 5);
    graph.addEdge(7, 8);
    graph.addEdge(9, 10);
    graph.addEdge(9, 11);
    graph.addEdge(9, 12);
    graph.addEdge(11, 12);

    return graph;
  }
}
