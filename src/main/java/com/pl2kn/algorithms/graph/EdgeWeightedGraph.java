package com.pl2kn.algorithms.graph;

import java.util.ArrayList;

/**
 * Edge-Weighted Graph implementation.
 */
public class EdgeWeightedGraph {

  private final int V;
  private int E;
  private final ArrayList<ArrayList<Edge>> adj;

  /**
   * Creates an edge-weighted graph composed of V vertices.
   *
   * @param V the count of vertices.
   */
  public EdgeWeightedGraph(int V) {
    this.V = V;
    adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
  }

  /**
   * Adds the edge to the graph.
   *
   * @param edge an edge
   */
  public void addEdge(Edge edge) {
    int v = edge.either();
    int w = edge.other(v);
    adj.get(v).add(edge);
    adj.get(w).add(edge);
    E++;
  }

  public Iterable<Edge> adj(int v) {
    return adj.get(v);
  }
}
