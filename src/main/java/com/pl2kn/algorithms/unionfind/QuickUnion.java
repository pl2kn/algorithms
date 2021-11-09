package com.pl2kn.algorithms.unionfind;

/**
 * Quick Union implementation of Union-Find data structure.
 */
public class QuickUnion extends UnionFind {

  public QuickUnion(int n) {
    super(n);
  }

  @Override
  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);

    nodes[pRoot] = qRoot;
  }

  @Override
  public int find(int p) {
    while (p != nodes[p]) {
      p = nodes[p];
    }

    return p;
  }
}
