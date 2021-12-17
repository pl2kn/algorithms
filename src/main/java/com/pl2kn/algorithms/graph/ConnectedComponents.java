package com.pl2kn.algorithms.graph;

/**
 * Connected Components implementation.
 */
public class ConnectedComponents {

  private final boolean[] marked;
  private final int[] id;
  private int count;

  /**
   * Creates connected components using Depth-First Search.
   *
   * @param graph graph to handle
   */
  public ConnectedComponents(Graph graph) {
    marked = new boolean[graph.V()];
    id = new int[graph.V()];
    for (int v = 0; v < graph.V(); v++) {
      if (!marked[v]) {
        dfs(graph, v);
        count++;
      }
    }
  }

  private void dfs(Graph graph, int s) {
    marked[s] = true;
    id[s] = count;
    for (int w : graph.adj(s)) {
      if (!marked[w]) {
        dfs(graph, w);
      }
    }
  }

  public int count() {
    return count;
  }

  public int id(int v) {
    return id[v];
  }
}
