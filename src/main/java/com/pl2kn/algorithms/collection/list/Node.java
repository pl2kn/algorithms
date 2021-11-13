package com.pl2kn.algorithms.collection.list;

abstract class  Node<T extends Comparable<T>> {

  protected T item;

  public Node(T item) {
    this.item = item;
  }

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }
}
