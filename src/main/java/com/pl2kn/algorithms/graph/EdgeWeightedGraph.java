package com.pl2kn.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

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
   * @param edge the edge
   */
  public void addEdge(Edge edge) {
    int v = edge.either();
    int w = edge.other(v);
    adj.get(v).add(edge);
    adj.get(w).add(edge);
    E++;
  }

  /**
   * Returns all edges of the graph.
   *
   * @return the edges
   */
  public Iterable<Edge> edges() {
    List<Edge> edges = new ArrayList<>();
    for (int v = 0; v < V; v++) {
      int selfLoopCount = 0;
      for (Edge edge : adj(v)) {
        if (v < edge.other(v)) {
          edges.add(edge);
        } else if (v == edge.other(v)) {
          //add only one self-loop edge
          if (selfLoopCount % 2 == 0) {
            edges.add(edge);
          }
          selfLoopCount++;
        }
      }
    }
    return edges;
  }

  public int E() {
    return E;
  }

  public Iterable<Edge> adj(int v) {
    return adj.get(v);
  }
}
