package com.pl2kn.algorithms.unionfind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract public class UnionFindTest {

  public abstract UnionFind createUnionFind(int n);

  @Test
  void Node_Count() {
    UnionFind unionFind = createUnionFind(5);

    assertEquals(5, unionFind.nodes.length);
  }

  @Test
  void Two_Node_Union() {
    UnionFind unionFind = createUnionFind(2);
    unionFind.union(0, 1);

    assertEquals(1, unionFind.find(0));
    assertEquals(1, unionFind.find(1));
  }

  @Test
  void Three_Node_Union() {
    UnionFind unionFind = createUnionFind(3);
    unionFind.union(0, 1);
    unionFind.union(1, 2);

    assertEquals(2, unionFind.find(0));
    assertEquals(2, unionFind.find(1));
    assertEquals(2, unionFind.find(2));
  }

  @Test
  void Nine_Node_Union() {
    UnionFind unionFind = createUnionFind(10);
    unionFind.union(4, 3);
    unionFind.union(3, 8);
    unionFind.union(6, 5);
    unionFind.union(9, 4);
    unionFind.union(2, 1);

    assertTrue(unionFind.find(8) == unionFind.find(9));
    assertFalse(unionFind.find(5) == unionFind.find(0));
  }
}
