package com.pl2kn.algorithms.graph;

import java.util.Stack;

/**
 * Topological Sort implementation.
 */
public class DepthFirstOrder {

  private final boolean[] marked;
  private final Stack<Integer> reversedPost;

  public DepthFirstOrder(Digraph digraph) {
    marked = new boolean[digraph.V()];
    reversedPost = new Stack<>();
    for (int v = 0; v < digraph.V(); v++) {
      if (!marked[v]) {
        dfs(digraph, v);
      }
    }
  }

  private void dfs(Digraph digraph, int s) {
    marked[s] = true;
    for (int v : digraph.adj(s)) {
      if (!marked[v]) {
        dfs(digraph, v);
      }
    }
    reversedPost.add(s);
  }

  public Iterable<Integer> reversedPost() {
    return reversedPost;
  }
}
