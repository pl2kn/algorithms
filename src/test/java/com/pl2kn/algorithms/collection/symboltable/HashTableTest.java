package com.pl2kn.algorithms.collection.symboltable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class HashTableTest {

  public abstract HashTable<String, Integer> createHashTable(int size);

  @Test
  public void Put_Test() {
    HashTable<String, Integer> hashTable = createHashTable(5);
    hashTable.put("A", 1);
    hashTable.put("B", 2);
    hashTable.put("C", 3);
    hashTable.put("D", 4);
    hashTable.put("E", 5);
    hashTable.put("F", 6);
    hashTable.put("G", 7);
    hashTable.put("H", 8);

    assertEquals(8, hashTable.size());
    assertEquals(2, hashTable.get("B"));
    assertEquals(3, hashTable.get("C"));
    assertEquals(7, hashTable.get("G"));
  }
}
