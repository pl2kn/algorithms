package com.pl2kn.algorithms.collection.symboltable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TernarySearchTrieTest {

  @Test
  public void Simple_Put_Get_Test() {
    TernarySearchTrie<Integer> trie = new TernarySearchTrie<>();
    trie.put("first", 1);
    trie.put("second", 2);
    trie.put("third", 3);
    trie.put("forth", 4);
    assertEquals(1, trie.get("first"));
    assertEquals(2, trie.get("second"));
    assertEquals(3, trie.get("third"));
    assertEquals(4, trie.get("forth"));
  }
}
