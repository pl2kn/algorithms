package com.pl2kn.algorithms.collection.symboltable;

interface HashTable<K, V> {

  void put(K key, V value);

  V get(K key);

  int size();

  boolean isEmpty();
}
