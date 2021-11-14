package com.pl2kn.algorithms.collection.list;

abstract class  Node<T> {

  protected T item;

  public Node(T item) {
    this.item = item;
  }

  public T getItem() {
    return item;
  }
}
