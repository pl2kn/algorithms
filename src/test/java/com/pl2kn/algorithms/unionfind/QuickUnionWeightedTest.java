package com.pl2kn.algorithms.unionfind;

public class QuickUnionWeightedTest extends UnionFindTest {

  @Override
  public UnionFind createUnionFind(int n) {
    return new QuickUnionWeighted(n);
  }
}
