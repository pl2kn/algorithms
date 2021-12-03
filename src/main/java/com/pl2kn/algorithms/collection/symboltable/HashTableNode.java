package com.pl2kn.algorithms.collection.symboltable;

class HashTableNode<K, V> {

  private K key;
  private V value;
  private HashTableNode<K, V> next;

  HashTableNode(K key, V value, HashTableNode<K, V> next) {
    this.key = key;
    this.value = value;
    this.next = next;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public HashTableNode<K, V> getNext() {
    return next;
  }
}
