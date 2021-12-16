package com.pl2kn.algorithms.graph;

public interface Path {

  boolean hasPathTo(int v);

  Iterable<Integer> pathTo(int v);
}
