package com.pl2kn.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Ford Fulkerson Algorithm implementation.
 */
public class FordFulkerson {

  private boolean[] marked;
  private FlowEdge[] edgeTo;
  private double value;

  public FordFulkerson(FlowNetwork graph, int source, int target) {
    value = 0.0;
    while (hasAugmentingPath(graph, source, target)) {
      double bottle = Double.POSITIVE_INFINITY;
      for (int v = target; v != source; v = edgeTo[v].other(v)) {
        bottle = Math.min(bottle, edgeTo[v].residualCapacity(v));
      }
      for (int v = target; v != source; v = edgeTo[v].other(v)) {
        edgeTo[v].addResidualFlowTo(v, bottle);
      }
      value += bottle;
    }
  }

  private boolean hasAugmentingPath(FlowNetwork graph, int source, int target) {
    int vertexCount = graph.V();
    edgeTo = new FlowEdge[vertexCount];
    marked = new boolean[vertexCount];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    marked[source] = true;
    while (!queue.isEmpty()) {
      int v = queue.poll();
      for (FlowEdge edge : graph.adj(v)) {
        int w = edge.other(v);
        if (edge.residualCapacity(w) > 0 && !marked[w]) {
          edgeTo[w] = edge;
          marked[w] = true;
          queue.add(w);
        }
      }
    }
    return marked[target];
  }

  public double value() {
    return value;
  }

  public boolean inCut(int v) {
    return marked[v];
  }
}
