package com.pl2kn.algorithms.unionfind;

abstract class UnionFind {

  protected int[] nodes;

  public UnionFind(int n) {
    nodes = new int[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = i;
    }
  }

  public abstract void union(int p, int q);

  public abstract int find(int p);
}
