package com.pl2kn.algorithms.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class BreadthFirstSearchTest {

  @Test
  public void Has_Path_Test() {
    BreadthFirstSearch bfs = new BreadthFirstSearch(createGraph(), 0);
    assertTrue(bfs.hasPathTo(5));
    assertTrue(bfs.hasPathTo(3));
    assertTrue(bfs.hasPathTo(4));
    assertTrue(bfs.hasPathTo(6));
    assertTrue(bfs.hasPathTo(1));
    assertTrue(bfs.hasPathTo(2));

    assertFalse(bfs.hasPathTo(7));
    assertFalse(bfs.hasPathTo(8));
    assertFalse(bfs.hasPathTo(9));
    assertFalse(bfs.hasPathTo(12));
  }

  @Test
  public void Path_To_Test() {
    BreadthFirstSearch bfs = new BreadthFirstSearch(createGraph(), 0);
    Stack<Integer> expectedPath = new Stack<>();
    expectedPath.add(4);
    expectedPath.add(6);
    expectedPath.add(0);
    assertEquals(expectedPath, bfs.pathTo(4));
  }

  @Test
  public void Short_Path_To_Test() {
    BreadthFirstSearch bfs = new BreadthFirstSearch(createGraph(), 0);
    Stack<Integer> expectedPath = new Stack<>();
    expectedPath.add(5);
    expectedPath.add(0);
    assertEquals(expectedPath, bfs.pathTo(5));
  }

  @Test
  public void No_Path_To_Test() {
    BreadthFirstSearch bfs = new BreadthFirstSearch(createGraph(), 0);
    assertNull(bfs.pathTo(12));
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
