package com.pl2kn.algorithms.graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StrongComponentsTest {

  @Test
  public void Strongly_Connected_Components_Test() {
    Digraph digraph = new Digraph(13);
    digraph.addEdge(4, 2);
    digraph.addEdge(2, 3);
    digraph.addEdge(3, 2);
    digraph.addEdge(6, 0);
    digraph.addEdge(0, 1);
    digraph.addEdge(2, 0);
    digraph.addEdge(11, 12);
    digraph.addEdge(12, 9);
    digraph.addEdge(9, 10);
    digraph.addEdge(9, 11);
    digraph.addEdge(7, 9);
    digraph.addEdge(10, 12);
    digraph.addEdge(11, 4);
    digraph.addEdge(4, 3);
    digraph.addEdge(3, 5);
    digraph.addEdge(6, 8);
    digraph.addEdge(8, 6);
    digraph.addEdge(5, 4);
    digraph.addEdge(0, 5);
    digraph.addEdge(6, 4);
    digraph.addEdge(6, 9);
    digraph.addEdge(7, 6);

    StrongComponents sc = new StrongComponents(digraph);
    assertTrue(sc.stronglyConnected(8, 6));
    assertTrue(sc.stronglyConnected(1, 1));
    assertTrue(sc.stronglyConnected(0, 3));
    assertTrue(sc.stronglyConnected(10, 12));
    assertFalse(sc.stronglyConnected(8, 9));
  }
}
