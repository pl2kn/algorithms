package com.pl2kn.algorithms.unionfind;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class QuickUnionWeightedTest extends UnionFindTest {

  @Override
  public UnionFind createUnionFind(int n) {
    return new QuickUnionWeighted(n);
  }

  @Test
  public void Ten_Nodes_Test() {
    UnionFind uf = new QuickUnionWeighted(10);
    uf.union(0, 1);
    uf.union(1, 2);
    uf.union(1, 3);
    uf.union(0, 4);
    assertEquals(uf.find(0), uf.find(3));
  }
}
