package com.pl2kn.algorithms.unionfind;

/**
 * Quick Union implementation with weighted sets of Union-Find data structure. But each time we find
 * a root we will make subtrees more flat by moving nodes closer to their roots.
 */
public class QuickUnionWeightedFlat extends QuickUnionWeighted {

  public QuickUnionWeightedFlat(int n) {
    super(n);
  }

  @Override
  public int find(int p) {
    while (p != nodes[p]) {
      nodes[p] = nodes[nodes[p]];
      p = nodes[p];
    }

    return p;
  }
}
