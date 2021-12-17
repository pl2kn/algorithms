package com.pl2kn.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch implements Path {

  private final boolean[] marked;
  private final int[] edgeTo;
  private final int[] distTo;

  public BreadthFirstSearch(Graph graph, int s) {
    marked = new boolean[graph.V()];
    edgeTo = new int[graph.V()];
    distTo = new int[graph.V()];
    bfs(graph, s);
  }

  private void bfs(Graph graph, int s) {
    Queue<Integer> queue = new LinkedList<>();
    marked[0] = true;
    queue.add(s);
    while (!queue.isEmpty()) {
      int v = queue.poll();
      for (int w : graph.adj(v)) {
        if (!marked[w]) {
          edgeTo[w] = v;
          distTo[w] = distTo[v] + 1;
          marked[w] = true;
          queue.add(w);
        }
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
    Stack<Integer> stack = new Stack<>();
    int i;
    for (i = v; distTo[i] != 0; i = edgeTo[i]) {
      stack.add(i);
    }
    stack.add(i);
    return stack;
  }
}
