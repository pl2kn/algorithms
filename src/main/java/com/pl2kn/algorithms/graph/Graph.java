package com.pl2kn.algorithms.graph;

import java.util.ArrayList;

public class Graph {

  private final int vertexCount;
  private int edgeCount;
  private final ArrayList<ArrayList<Integer>> adj;

  public Graph(int vertexCount) {
    this.vertexCount = vertexCount;
    adj = new ArrayList<>();
    for (int i = 0; i < vertexCount; i++) {
      adj.add(new ArrayList<>());
    }
  }

  public void addEdge(int v, int u) {
    adj.get(v).add(u);
    adj.get(u).add(v);
    edgeCount++;
  }

  public Iterable<Integer> adj(int v) {
    return adj.get(v);
  }

  public int vertexCount() {
    return vertexCount;
  }

  public int getEdgeCount() {
    return edgeCount;
  }
}
