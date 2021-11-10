package com.pl2kn.algorithms.unionfind;

public class QuickFindTest extends UnionFindTest {

  @Override
  public UnionFind createUnionFind(int n) {
    return new QuickFind(n);
  }
}
