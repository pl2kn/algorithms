package com.pl2kn.algorithms.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Kruskal's Algorithm implementation.
 */
public class KruskalMST {

  private final List<Edge> mst = new ArrayList<>();

  /**
   * Creates MST.
   *
   * @param graph the graph
   */
  public KruskalMST(EdgeWeightedGraph graph) {
    //sort the edges by the weight
    List<Edge> edges = new ArrayList<>();
    for (Edge edge : graph.edges()) {
      edges.add(edge);
    }
    Collections.sort(edges);
    UnionFind uf = new UnionFind(graph.E());

    //checks weather the edge makes a cycle or not using Union-Find
    for (Edge edge : edges) {
      int v = edge.either();
      int w = edge.other(v);
      if (uf.find(v) != uf.find(w)) {
        mst.add(edge);
        uf.union(v, w);
      }
    }
  }

  public Iterable<Edge> edges() {
    return mst;
  }
}
