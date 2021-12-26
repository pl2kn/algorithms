package com.pl2kn.algorithms.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DijkstraShortestPathAlgorithmTest {

  @Test
  public void Simple_Test() {
    EdgeWeightedDigraph graph = new EdgeWeightedDigraph(8);
    DirectedEdge edge05 = new DirectedEdge(0, 4, 9.0);
    DirectedEdge edge45 = new DirectedEdge(4, 5, 4.0);
    DirectedEdge edge52 = new DirectedEdge(5, 2, 1.0);
    DirectedEdge edge26 = new DirectedEdge(2, 6, 11.0);
    graph.addEdge(new DirectedEdge(0, 1, 5.0));
    graph.addEdge(edge05);
    graph.addEdge(new DirectedEdge(0, 7, 8.0));
    graph.addEdge(new DirectedEdge(1, 2, 12.0));
    graph.addEdge(new DirectedEdge(1, 3, 15.0));
    graph.addEdge(new DirectedEdge(1, 7, 4.0));
    graph.addEdge(new DirectedEdge(2, 3, 3.0));
    graph.addEdge(edge26);
    graph.addEdge(new DirectedEdge(3, 6, 9.0));
    graph.addEdge(edge45);
    graph.addEdge(new DirectedEdge(4, 6, 20.0));
    graph.addEdge(new DirectedEdge(4, 7, 5.0));
    graph.addEdge(edge52);
    graph.addEdge(new DirectedEdge(5, 6, 13.0));
    graph.addEdge(new DirectedEdge(7, 5, 6.0));
    graph.addEdge(new DirectedEdge(7, 2, 7.0));

    DijkstraShortestPath sp = new DijkstraShortestPath(graph, 0);

    assertEquals(5.0, sp.distTo(1));
    assertEquals(14.0, sp.distTo(2));
    assertEquals(17.0, sp.distTo(3));
    assertEquals(9.0, sp.distTo(4));
    assertEquals(13.0, sp.distTo(5));
    assertEquals(25.0, sp.distTo(6));
    assertEquals(8.0, sp.distTo(7));

    List<DirectedEdge> expectedPathTo = new ArrayList<>();
    expectedPathTo.add(edge05);
    expectedPathTo.add(edge45);
    expectedPathTo.add(edge52);
    expectedPathTo.add(edge26);
    int edgeCount = 0;
    for (DirectedEdge edge : sp.pathTo(6)) {
      assertTrue(expectedPathTo.contains(edge));
      edgeCount++;
    }
    assertEquals(4, edgeCount);
  }
}
