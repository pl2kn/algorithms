package com.pl2kn.algorithms.graph;

interface ShortestPath {

  double distTo(int v);

  Iterable<DirectedEdge> pathTo(int v);
}
