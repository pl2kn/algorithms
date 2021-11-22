package com.pl2kn.algorithms.collection.list;

interface MaxPriorityQueue<T extends Comparable<T>> {

  boolean isEmpty();

  void insert(T item);

  T delMax();

  int size();
}
