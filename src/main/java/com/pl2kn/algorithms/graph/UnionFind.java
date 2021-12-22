package com.pl2kn.algorithms.graph;

/**
 * Union Find with Weighted Subsets implementation.
 */
public class UnionFind {

  private final int[] nodes;
  private final int[] weights;

  /**
   * Creates nodes and weights.
   *
   * @param n the number of nodes
   */
  public UnionFind(int n) {
    nodes = new int[n];
    weights = new int[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = i;
      weights[i] = 1;
    }
  }

  /**
   * Unions two nodes.
   *
   * @param p the first node to union
   * @param q the second node to union
   */
  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot == qRoot) {
      return;
    }
    if (weights[pRoot] > weights[qRoot]) {
      nodes[qRoot] = pRoot;
      weights[pRoot] += weights[qRoot];
    } else {
      nodes[pRoot] = qRoot;
      weights[qRoot] += weights[pRoot];
    }
  }

  /**
   * Finds the parent of the node.
   *
   * @param p the node
   * @return the parent node
   */
  public int find(int p) {
    while (nodes[p] != p) {
      p = nodes[p];
    }
    return p;
  }
}
