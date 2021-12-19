package com.pl2kn.algorithms.graph;

import java.util.Stack;

/**
 * Depth-First Search implementation.
 */
public class DepthFirstSearch implements Path {

  private final boolean[] marked;
  private final int[] edgeTo;
  private final int s;

  public DepthFirstSearch(Graph graph, int s) {
    marked = new boolean[graph.V()];
    edgeTo = new int[graph.V()];
    this.s = s;
    dfs(graph, s);
  }

  private void dfs(Graph graph, int v) {
    marked[v] = true;
    for (int w : graph.adj(v)) {
      if (!marked[w]) {
        edgeTo[w] = v;
        dfs(graph, w);
      }
    }
  }

  @Override
  public boolean hasPathTo(int v) {
    return marked[v];
  }

  @Override
  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) {
      return null;
    }
    Stack<Integer> path = new Stack<>();
    for (int i = v; i != s; i = edgeTo[i]) {
      path.add(i);
    }
    path.add(s);
    return path;
  }
}
