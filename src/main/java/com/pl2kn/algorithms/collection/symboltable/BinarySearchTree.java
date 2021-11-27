package com.pl2kn.algorithms.collection.symboltable;

/**
 * Binary Search Implementation.
 *
 * @param <K> key type
 * @param <V> value type
 */
public class BinarySearchTree<K extends Comparable<K>, V> implements SymbolTable<K, V> {

  private Node root;

  private class Node {

    private K key;
    private V value;
    private Node left;
    private Node right;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  @Override
  public void put(K key, V value) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    root = put(root, key, value);
  }

  private Node put(Node root, K key, V value) {
    if (root == null) {
      return new Node(key, value);
    }
    int comp = key.compareTo(root.key);
    if (comp > 0) {
      root.right = put(root.right, key, value);
    } else if (comp < 0) {
      root.left = put(root.left, key, value);
    } else {
      root.value = value;
    }
    return root;
  }

  @Override
  public V get(K key) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    Node current = root;
    while (current != null) {
      int comp = key.compareTo(current.key);
      if (comp > 0) {
        current = current.right;
      } else if (comp < 0) {
        current = current.left;
      } else {
        return current.value;
      }
    }
    return null;
  }

  @Override
  public void delete(K key) throws IllegalAccessException {

  }

  @Override
  public boolean contains(K key) throws IllegalAccessException {
    return false;
  }

  @Override
  public K min() {
    return null;
  }

  @Override
  public K max() {
    return null;
  }

  @Override
  public void deleteMin() throws IllegalAccessException {

  }

  @Override
  public void deleteMax() throws IllegalAccessException {

  }

  @Override
  public K floor(K key) throws IllegalAccessException {
    return null;
  }

  @Override
  public K ceiling(K key) throws IllegalAccessException {
    return null;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public Iterable<K> keys() {
    return null;
  }
}
