package com.pl2kn.algorithms.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class DepthFirstSearchTest {

  @Test
  public void Has_Path_Test() {
    DepthFirstSearch dfs = new DepthFirstSearch(createGraph(), 0);
    assertTrue(dfs.hasPathTo(5));
    assertTrue(dfs.hasPathTo(3));
    assertTrue(dfs.hasPathTo(4));
    assertTrue(dfs.hasPathTo(6));
    assertTrue(dfs.hasPathTo(1));
    assertTrue(dfs.hasPathTo(2));

    assertFalse(dfs.hasPathTo(7));
    assertFalse(dfs.hasPathTo(8));
    assertFalse(dfs.hasPathTo(9));
    assertFalse(dfs.hasPathTo(12));
  }

  @Test
  public void Path_To_Test() {
    DepthFirstSearch dfs = new DepthFirstSearch(createGraph(), 0);
    Stack<Integer> expectedPath = new Stack<>();
    expectedPath.add(4);
    expectedPath.add(6);
    expectedPath.add(0);
    assertEquals(expectedPath, dfs.pathTo(4));
  }

  @Test
  public void No_Path_To_Test() {
    DepthFirstSearch dfs = new DepthFirstSearch(createGraph(), 0);
    assertNull(dfs.pathTo(12));
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
