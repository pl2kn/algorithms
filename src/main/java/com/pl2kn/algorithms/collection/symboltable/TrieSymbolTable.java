package com.pl2kn.algorithms.collection.symboltable;

import java.util.LinkedList;
import java.util.Queue;

/**
 * R-way Trie implementation.
 *
 * @param <T> the value type
 */
public class TrieSymbolTable<T> {

  private static final int R = 256;
  private Node root = new Node();

  private static class Node {

    private Object value;
    private final Node[] next = new Node[R];
  }

  public void put(String key, T value) {
    root = put(root, key, value, 0);
  }

  private Node put(Node node, String key, T value, int d) {
    if (node == null) {
      node = new Node();
    }
    if (d == key.length()) {
      node.value = value;
      return node;
    }
    char c = key.charAt(d);
    node.next[c] = put(node.next[c], key, value, d + 1);
    return node;
  }

  public T get(String key) {
    Node node = get(root, key, 0);
    if (node == null) {
      return null;
    }
    return (T) node.value;
  }

  private Node get(Node node, String key, int d) {
    if (node == null) {
      return null;
    }
    if (d == key.length()) {
      return node;
    }
    char c = key.charAt(d);
    return get(node.next[c], key, d + 1);
  }

  public boolean contains(String key) {
    return get(key) != null;
  }

  public void delete(String key) {
    root = delete(root, key, 0);
  }

  private Node delete(Node node, String key, int d) {
    if (node == null) {
      return null;
    }
    if (d == key.length()) {
      node.value = null;
    } else {
      char c = key.charAt(d);
      node.next[c] = delete(node.next[c], key, d + 1);
    }
    if (node.value != null) {
      return node;
    }
    for (int c = 0; c < R; c++) {
      if (node.next[c] != null) {
        return node;
      }
    }
    return null;
  }

  /**
   * Returns all keys.
   *
   * @return the keys
   */
  public Iterable<String> keys() {
    Queue<String> queue = new LinkedList<>();
    collect(root, "", queue);
    return queue;
  }

  /**
   * Finds all keys starting with a given prefix.
   *
   * @param prefix the given prefix
   * @return the keys
   */
  public Iterable<String> keysWithPrefix(String prefix) {
    Queue<String> queue = new LinkedList<>();
    Node node = get(root, prefix, 0);
    collect(node, prefix, queue);
    return queue;
  }

  private void collect(Node node, String prefix, Queue<String> queue) {
    if (node == null) {
      return;
    }
    if (node.value != null) {
      queue.add(prefix);
    }
    for (char c = 0; c < R; c++) {
      collect(node.next[c], prefix + c, queue);
    }
  }

  public String longestPrefixOf(String query) {
    int length = search(root, query, 0, 0);
    return query.substring(0, length);
  }

  private int search(Node node, String query, int d, int length) {
    if (node == null) {
      return length;
    }
    if (node.value != null) {
      length = d;
    }
    if (d == query.length()) {
      return length;
    }
    char c = query.charAt(d);
    return search(node.next[c], query, d + 1, length);
  }
}
