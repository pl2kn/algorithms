package com.pl2kn.algorithms.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PrimMSTTest {

  @Test
  public void Simple_Test() {
    EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
    Edge edge07 = new Edge(0, 7, 0.16);
    Edge edge45 = new Edge(4, 5, 0.35);
    Edge edge57 = new Edge(5, 7, 0.28);
    Edge edge17 = new Edge(1, 7, 0.19);
    Edge edge02 = new Edge(0, 2, 0.26);
    Edge edge23 = new Edge(2, 3, 0.17);
    Edge edge62 = new Edge(6, 2, 0.40);
    graph.addEdge(edge07);
    graph.addEdge(edge23);
    graph.addEdge(edge17);
    graph.addEdge(edge02);
    graph.addEdge(edge57);
    graph.addEdge(new Edge(1, 3, 0.29));
    graph.addEdge(new Edge(1, 5, 0.32));
    graph.addEdge(new Edge(2, 7, 0.34));
    graph.addEdge(edge45);
    graph.addEdge(new Edge(1, 2, 0.36));
    graph.addEdge(new Edge(4, 7, 0.37));
    graph.addEdge(new Edge(0, 4, 0.38));
    graph.addEdge(edge62);
    graph.addEdge(new Edge(3, 6, 0.52));
    graph.addEdge(new Edge(6, 0, 0.58));
    graph.addEdge(new Edge(6, 4, 0.93));
    PrimMST mst = new PrimMST (graph);

    List<Edge> expectedMST = new ArrayList<>();
    expectedMST.add(edge07);
    expectedMST.add(edge45);
    expectedMST.add(edge57);
    expectedMST.add(edge17);
    expectedMST.add(edge02);
    expectedMST.add(edge23);
    expectedMST.add(edge62);

    int edgesCount = 0;
    for (Edge edge : mst.edges()) {
      edgesCount++;
      assertTrue(expectedMST.contains(edge));
    }
    assertEquals(expectedMST.size(), edgesCount);
  }
}
