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
    for (int i = 0; i < n; i++) {
      weights[i] = 1;
    }
  }

  @Override
  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);

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
