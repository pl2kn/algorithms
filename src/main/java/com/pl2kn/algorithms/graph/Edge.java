package com.pl2kn.algorithms.graph;

/**
 * Weighted Edge implementation.
 */
public class Edge implements Comparable<Edge> {

  private final int v;
  private final int w;
  private final double weight;

  /**
   * Creates a wighted edge between two vertices.
   *
   * @param v      the first vertex
   * @param w      the second vertex
   * @param weight the edge weight
   */
  public Edge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public int either() {
    return v;
  }

  public int other(int vertex) {
    return vertex == v ? w : v;
  }

  @Override
  public int compareTo(Edge that) {
    return Double.compare(this.weight, that.weight);
  }
}
