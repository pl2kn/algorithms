package com.pl2kn.algorithms.graph;

import java.util.ArrayList;

/**
 * Flow Network Implementation.
 */
public class FlowNetwork {

  private final int V;
  private int E;
  private final ArrayList<ArrayList<FlowEdge>> adj;

  public int V() {
    return V;
  }

  /**
   * Creates adjacency lists size of the V.
   *
   * @param V the vertex count
   */
  public FlowNetwork(int V) {
    this.V = V;
    adj = new ArrayList<>();
    for (int v = 0; v < V; v++) {
      adj.add(new ArrayList<>());
    }
  }

  /**
   * Adds the flow edge to the both of adjacency.
   *
   * @param edge the edge to add
   */
  public void addEdge(FlowEdge edge) {
    int v = edge.from();
    int w = edge.to();
    adj.get(v).add(edge);
    adj.get(w).add(edge);
  }

  public Iterable<FlowEdge> adj(int v) {
    return adj.get(v);
  }
}
