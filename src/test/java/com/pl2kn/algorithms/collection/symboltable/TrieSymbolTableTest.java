package com.pl2kn.algorithms.collection.symboltable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TrieSymbolTableTest {
  @Test
  public void Simple_Test() {
    TrieSymbolTable<Integer> trie = new TrieSymbolTable<>();
    trie.put("First", 1);
    trie.put("Second", 2);
    trie.put("Third", 3);
    assertEquals(1, trie.get("First"));
    assertEquals(2, trie.get("Second"));
    assertEquals(3, trie.get("Third"));
  }
}
