package com.pl2kn.algorithms.unionfind;

public class QuickUnionTest extends UnionFindTest {

  @Override
  public UnionFind createUnionFind(int n) {
    return new QuickUnion(n);
  }
}
