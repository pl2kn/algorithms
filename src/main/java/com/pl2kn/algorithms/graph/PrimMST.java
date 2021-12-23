package com.pl2kn.algorithms.graph;

import com.pl2kn.algorithms.collection.list.MinBinaryHeap;
import java.util.ArrayList;
import java.util.List;

/**
 * Prim's Algorithm implementation.
 */
public class PrimMST {

  private final List<Edge> mst = new ArrayList<>();
  private final MinBinaryHeap<Edge> heap;
  private boolean[] marked;

  public PrimMST(EdgeWeightedGraph graph) {
    int edgeCount = graph.E();
    heap = new MinBinaryHeap<>(edgeCount);
    marked = new boolean[edgeCount];
    visit(graph, 0);
    while (!heap.isEmpty()) {
      Edge edge = heap.poll();
      int v = edge.either();
      int w = edge.other(v);
      if (marked[v] && marked[w]) {
        continue;
      }
      mst.add(edge);
      if (!marked[v]) {
        visit(graph, v);
      }
      if (!marked[w]) {
        visit(graph, w);
      }
    }
  }

  public Iterable<Edge> edges() {
    return mst;
  }

  private void visit(EdgeWeightedGraph graph, int vertex) {
    marked[vertex] = true;
    for (Edge edge : graph.adj(vertex)) {
      if (!marked[edge.other(vertex)]) {
        heap.add(edge);
      }
    }
  }
}
