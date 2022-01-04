package com.pl2kn.algorithms.collection.symboltable;

/**
 * Ternary Search Trie implementation.
 *
 * @param <T> the value type
 */
public class TernarySearchTrie<T> {

  private Node root;

  private class Node {

    private T value;
    private char character;
    private Node left;
    private Node middle;
    private Node right;
  }

  public void put(String key, T value) {
    root = put(root, key, value, 0);
  }

  private Node put(Node node, String key, T value, int d) {
    char currentChar = key.charAt(d);
    if (node == null) {
      node = new Node();
      node.character = currentChar;
    }
    if (currentChar < node.character) {
      node.left = put(node.left, key, value, d);
    } else if (currentChar > node.character) {
      node.right = put(node.right, key, value, d);
    } else if (d < key.length() - 1) {
      node.middle = put(node.middle, key, value, d + 1);
    } else {
      node.value = value;
    }
    return node;
  }

  public boolean contains(String key) {
    return get(key) != null;
  }

  public T get(String key) {
    Node node = get(root, key, 0);
    if (node == null) {
      return null;
    }
    return node.value;
  }

  public Node get(Node node, String key, int d) {
    if (node == null) {
      return null;
    }
    char currentChar = key.charAt(d);
    if (currentChar < node.character) {
      return get(node.left, key, d);
    } else if (currentChar > node.character) {
      return get(node.right, key, d);
    } else if (d < key.length() - 1) {
      return get(node.middle, key, d + 1);
    } else {
      return node;
    }
  }
}
