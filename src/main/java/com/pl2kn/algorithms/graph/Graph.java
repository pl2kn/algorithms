package com.pl2kn.algorithms.graph;

import java.util.ArrayList;

public class Graph {

  private final int V;
  private int E;
  private final ArrayList<ArrayList<Integer>> adj;

  public Graph(int V) {
    this.V = V;
    adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
  }

  public void addEdge(int v, int u) {
    adj.get(v).add(u);
    adj.get(u).add(v);
    E++;
  }

  public Iterable<Integer> adj(int v) {
    return adj.get(v);
  }

  public int V() {
    return V;
  }

  public int getE() {
    return E;
  }
}
