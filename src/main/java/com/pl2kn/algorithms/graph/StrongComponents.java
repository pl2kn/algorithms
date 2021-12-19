package com.pl2kn.algorithms.graph;

import java.util.Stack;

/**
 * Kosaraju's algorithm implementation.
 */
public class StrongComponents {

  private final boolean[] marked;
  private final int[] id;
  private int count;

  public StrongComponents(Digraph digraph) {
    marked = new boolean[digraph.V()];
    id = new int[digraph.V()];
    DepthFirstOrder dfo = new DepthFirstOrder(digraph.reverse());
    for (int v : dfo.reversedPost()) {
      if (!marked[v]) {
        dfs(digraph, v);
        count++;
      }
    }
  }

  private void dfs(Digraph digraph, int s) {
    marked[s] = true;
    id[s] = count;
    for (int v : digraph.adj(s)) {
      if (!marked[v]) {
        dfs(digraph, v);
      }
    }
  }

  public boolean stronglyConnected(int v, int w) {
    return id[v] == id[w];
  }
}
