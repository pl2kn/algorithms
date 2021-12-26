package com.pl2kn.algorithms.graph;

import com.pl2kn.algorithms.collection.list.MinBinaryHeap;
import java.util.Stack;

/**
 * Dijkstra's Algorithm implementation.
 */
public class DijkstraShortestPath implements ShortestPath {

  private final DirectedEdge[] edgeTo;
  private final double[] distTo;

  private static class WeightedVertex implements Comparable<WeightedVertex> {

    private final int vertex;
    private final double weight;

    public WeightedVertex(int vertex, double weight) {
      this.vertex = vertex;
      this.weight = weight;
    }

    @Override
    public int compareTo(WeightedVertex that) {
      return Double.compare(this.weight, that.weight);
    }
  }

  /**
   * Creates The Shortest Path tree for the source vertex.
   *
   * @param graph  the edge weighted directed graph
   * @param source the source vertex
   */
  public DijkstraShortestPath(EdgeWeightedDigraph graph, int source) {
    int vertexCount = graph.V();
    edgeTo = new DirectedEdge[vertexCount];
    distTo = new double[vertexCount];
    MinBinaryHeap<WeightedVertex> queue = new MinBinaryHeap<>(vertexCount);
    boolean[] marked = new boolean[vertexCount];

    for (int i = 0; i < vertexCount; i++) {
      distTo[i] = Double.POSITIVE_INFINITY;
    }
    distTo[source] = 0.0;

    queue.add(new WeightedVertex(0, 0.0));

    while (!queue.isEmpty()) {
      WeightedVertex weightedVertex = queue.poll();
      int vertex = weightedVertex.vertex;
      if (!marked[vertex]) {
        marked[vertex] = true;
        for (DirectedEdge edge : graph.adj(vertex)) {
          relax(edge);
          int w = edge.to();
          queue.add(new WeightedVertex(w, distTo[w]));
        }
      }
    }
  }

  private void relax(DirectedEdge edge) {
    int v = edge.from();
    int w = edge.to();
    if (distTo[w] > distTo[v] + edge.weight()) {
      distTo[w] = distTo[v] + edge.weight();
      edgeTo[w] = edge;
    }
  }

  @Override
  public double distTo(int v) {
    return distTo[v];
  }

  @Override
  public Iterable<DirectedEdge> pathTo(int v) {
    Stack<DirectedEdge> stack = new Stack<>();
    for (DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()]) {
      stack.add(edge);
    }
    return stack;
  }
}
