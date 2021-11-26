package com.pl2kn.algorithms.collection.symboltable;

interface SymbolTable<K extends Comparable<K>, V> {

  void put(K key, V value) throws IllegalAccessException;

  V get(K key) throws IllegalAccessException;

  void delete(K key) throws IllegalAccessException;

  boolean contains(K key) throws IllegalAccessException;

  K min();

  K max();

  void deleteMin() throws IllegalAccessException;

  void deleteMax() throws IllegalAccessException;

  K floor(K key) throws IllegalAccessException;

  K ceiling(K key) throws IllegalAccessException;

  boolean isEmpty();

  int size();

  Iterable<K> keys();
}
