package com.pl2kn.algorithms.graph;

import java.util.ArrayList;

/**
 * Undirected Graph implementation.
 */
public class Graph {

  private final int V;
  private int E;
  private final ArrayList<ArrayList<Integer>> adj;

  /**
   * Creates Adjacency List.
   *
   * @param V the vertices count
   */
  public Graph(int V) {
    this.V = V;
    adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
  }

  /**
   * Add undirected edge between the vertices.
   *
   * @param v the first vertex
   * @param u the second vertex
   */
  public void addEdge(int v, int u) {
    adj.get(v).add(u);
    adj.get(u).add(v);
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
