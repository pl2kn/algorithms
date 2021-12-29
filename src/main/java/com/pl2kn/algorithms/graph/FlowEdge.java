package com.pl2kn.algorithms.graph;

/**
 * Flow Edge implementation.
 */
public class FlowEdge {

  private final int v;
  private final int w;
  private final double capacity;
  private double flow;

  /**
   * Creates Flow Edge from the vertex x to the vertex w with the capacity.
   *
   * @param v        the vertex from
   * @param w        the vertex to
   * @param capacity the capacity
   */
  public FlowEdge(int v, int w, double capacity) {
    this.v = v;
    this.w = w;
    this.capacity = capacity;
  }

  public int from() {
    return v;
  }

  public int to() {
    return w;
  }

  public double capacity() {
    return capacity;
  }

  public double flow() {
    return flow;
  }

  public int other(int vertex) {
    if (vertex == v) {
      return w;
    } else if (vertex == w) {
      return v;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public double residualCapacity(int vertex) {
    if (vertex == v) {
      return flow;
    } else if (vertex == w) {
      return capacity - flow;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public void addResidualFlowTo(int vertex, double delta) {
    if (vertex == v) {
      flow -= delta;
    } else if (vertex == w) {
      flow += delta;
    } else {
      throw new IllegalArgumentException();
    }
  }
}
