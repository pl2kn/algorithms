package com.pl2kn.algorithms.collection.symboltable;

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
}
