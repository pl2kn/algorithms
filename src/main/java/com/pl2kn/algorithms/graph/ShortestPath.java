package com.pl2kn.algorithms.graph;

public abstract class ShortestPath {

  private final EdgeWeightedDigraph graph;
  private final int source;

  public ShortestPath(EdgeWeightedDigraph graph, int source) {
    this.graph = graph;
    this.source = source;
  }

  public abstract double distTo(int v);

  public abstract Iterable<DirectedEdge> pathTo(int v);
}
