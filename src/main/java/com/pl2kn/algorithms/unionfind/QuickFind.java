package com.pl2kn.algorithms.unionfind;

/**
 * Quick Find implementation of Union-Find data structure.
 */
public class QuickFind extends UnionFind {

  public QuickFind(int n) {
    super(n);
  }

  @Override
  public void union(int p, int q) {
    int pNode = nodes[p];
    int qNode = nodes[q];
    for (int i = 0; i < nodes.length; i++) {
      if (nodes[i] == pNode) {
        nodes[i] = qNode;
      }
    }
  }

  @Override
  public int find(int p) {
    return nodes[p];
  }
}
