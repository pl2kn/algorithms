package com.pl2kn.algorithms.unionfind;

public class QuickUnionWeightedFlatTest extends UnionFindTest {

  @Override
  public UnionFind createUnionFind(int n) {
    return new QuickUnionWeightedFlat(n);
  }
}
