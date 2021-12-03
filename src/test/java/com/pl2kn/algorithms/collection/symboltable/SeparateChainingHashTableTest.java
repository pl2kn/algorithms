package com.pl2kn.algorithms.collection.symboltable;

public class SeparateChainingHashTableTest extends HashTableTest {

  @Override
  public HashTable<String, Integer> createHashTable(int size) {
    return new SeparateChainingHashTable<>(size);
  }
}
