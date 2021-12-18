package com.pl2kn.algorithms.graph;

import java.util.ArrayList;

/**
 * Directed Graph implementation.
 */
public class Digraph {

  private final int V;
  private int E;
  private final ArrayList<ArrayList<Integer>> adj;

  /**
   * Creates Adjacency List.
   *
   * @param V the vertices count
   */
  public Digraph(int V) {
    this.V = V;
    adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
  }

  public void addEdge(int v, int u) {
    adj.get(v).add(u);
    E++;
  }

  public Iterable<Integer> adj(int v) {
    return adj.get(v);
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }
}
