package com.pl2kn.algorithms.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class EdgeWeightedGraphTest {

  @Test
  public void Simple_Test() {
    EdgeWeightedGraph graph = new EdgeWeightedGraph(9);
    Edge edge45 = new Edge(4, 5, 0.35);
    Edge edge57 = new Edge(5, 7, 0.28);
    Edge edge15 = new Edge(1, 5, 0.32);

    graph.addEdge(edge45);
    graph.addEdge(new Edge(4, 7, 0.37));
    graph.addEdge(edge57);
    graph.addEdge(new Edge(0, 7, 0.16));
    graph.addEdge(edge15);
    graph.addEdge(new Edge(0, 4, 0.38));
    graph.addEdge(new Edge(2, 3, 0.17));
    graph.addEdge(new Edge(1, 7, 0.19));
    graph.addEdge(new Edge(0, 2, 0.26));
    graph.addEdge(new Edge(1, 2, 0.36));
    graph.addEdge(new Edge(1, 3, 0.29));
    graph.addEdge(new Edge(2, 7, 0.34));
    graph.addEdge(new Edge(6, 2, 0.40));
    graph.addEdge(new Edge(6, 2, 0.40));
    graph.addEdge(new Edge(3, 6, 0.52));
    graph.addEdge(new Edge(6, 0, 0.58));
    graph.addEdge(new Edge(6, 4, 0.93));

    ArrayList<Edge> expectedEdges = new ArrayList<>();
    expectedEdges.add(edge45);
    expectedEdges.add(edge57);
    expectedEdges.add(edge15);
    assertEquals(expectedEdges, graph.adj(5));
  }
}
