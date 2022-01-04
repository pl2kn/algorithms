package com.pl2kn.algorithms.collection.symboltable;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;
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

  @Test
  public void Keys_Test() {
    TrieSymbolTable<Integer> trie = new TrieSymbolTable<>();
    String firstKey = "First";
    trie.put(firstKey, 1);
    String secondKey = "Second";
    trie.put(secondKey, 2);
    String thirdKey = "Third";
    trie.put(thirdKey, 3);
    Queue<String> queue = new LinkedList<>();
    queue.add(firstKey);
    queue.add(secondKey);
    queue.add(thirdKey);
    int keyCount = 0;
    for (String key : trie.keys()) {
      keyCount++;
      assertTrue(queue.contains(key));
    }
    assertEquals(queue.size(), keyCount);
  }

  @Test
  public void Keys_With_Prefix_Test() {
    TrieSymbolTable<Integer> trie = new TrieSymbolTable<>();
    trie.put("by", 1);
    trie.put("seal", 2);
    trie.put("sells", 3);
    trie.put("she", 4);
    trie.put("shells", 5);
    trie.put("shore", 6);
    trie.put("the", 7);
    int keyCount = 0;
    for (String key : trie.keysWithPrefix("sh")) {
      keyCount++;
      assertTrue(key.equals("she") || key.equals("shells") || key.equals("shore"));
    }
    assertEquals(3, keyCount);
  }

  @Test
  public void Longest_Prefix_Of_Test() {
    TrieSymbolTable<Integer> trie = new TrieSymbolTable<>();
    trie.put("by", 1);
    trie.put("seal", 2);
    trie.put("sells", 3);
    trie.put("she", 4);
    trie.put("shells", 5);
    trie.put("shore", 6);
    trie.put("the", 7);
    assertEquals("shells", trie.longestPrefixOf("shellsort"));
  }
}
