package com.pl2kn.algorithms.unionfind;

/**
 * Quick Union implementation with weighted sets of Union-Find data structure.
 */
public class QuickUnionWeighted extends QuickUnion {

  private final int[] weights;

  /**
   * We need additional array to store weights of each set.
   *
   * @param n count of nodes.
   */
  public QuickUnionWeighted(int n) {
    super(n);

    weights = new int[n];
  }

  @Override
  public void union(int p, int q) {
    int pRoot = nodes[p];
    int qRoot = nodes[q];

    if (pRoot == qRoot) {
      return;
    }

    if (weights[pRoot] > weights[qRoot]) {
      nodes[qRoot] = pRoot;
      weights[qRoot] += weights[pRoot];
    } else {
      nodes[pRoot] = qRoot;
      weights[pRoot] += weights[qRoot];
    }
  }
}
