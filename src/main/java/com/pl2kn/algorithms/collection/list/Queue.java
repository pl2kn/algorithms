package com.pl2kn.algorithms.collection.list;

interface Queue<T> {

  void enqueue(T item);

  T dequeue();

  boolean isEmpty();
}
