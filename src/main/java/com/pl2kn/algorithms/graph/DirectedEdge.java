package com.pl2kn.algorithms.graph;

/**
 * Directed Weighted Edge implementation.
 */
public class DirectedEdge {

  private final int v;
  private final int w;
  private final double weight;

  /**
   * Creates the weighted edge from v to w.
   *
   * @param v      the first vertex
   * @param w      the second vertex
   * @param weight the edge weight
   */
  public DirectedEdge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public int from() {
    return v;
  }

  public int to() {
    return w;
  }

  public double weight() {
    return weight;
  }
}
