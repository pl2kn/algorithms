package com.pl2kn.algorithms.graph;

import java.util.ArrayList;

/**
 * Edge Weighted Directed Graph implementation.
 */
public class EdgeWeightedDigraph {

  private final int V;
  private int E;
  private final ArrayList<ArrayList<DirectedEdge>> adj;

  /**
   * Creates Edge Weighted Directed Graph consisted of V vertex.
   *
   * @param V the vertex count
   */
  public EdgeWeightedDigraph(int V) {
    this.V = V;
    adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
  }

  public void addEdge(DirectedEdge edge) {
    adj.get(edge.from()).add(edge);
    E++;
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public Iterable<DirectedEdge> adj(int v) {
    return adj.get(v);
  }
}
