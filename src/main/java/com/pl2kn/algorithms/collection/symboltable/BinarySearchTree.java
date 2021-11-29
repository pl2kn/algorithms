package com.pl2kn.algorithms.collection.symboltable;

import com.pl2kn.algorithms.collection.list.LinkedListQueue;
import java.util.NoSuchElementException;

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
    private int count;

    public Node(K key, V value, int count) {
      this.key = key;
      this.value = value;
      this.count = count;
    }
  }

  @Override
  public void put(K key, V value) throws IllegalAccessException {
    root = put(root, key, value);
  }

  private Node put(Node node, K key, V value) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    if (node == null) {
      return new Node(key, value, 1);
    }
    int comp = key.compareTo(node.key);
    if (comp > 0) {
      node.right = put(node.right, key, value);
    } else if (comp < 0) {
      node.left = put(node.left, key, value);
    } else {
      node.value = value;
    }
    node.count = 1 + size(node.left) + size(node.right);
    return node;
  }

  @Override
  public V get(K key) throws IllegalAccessException {
    return get(root, key).value;
  }

  private Node get(Node node, K key) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    if (node == null) {
      return null;
    }
    int comp = key.compareTo(node.key);
    if (comp < 0) {
      return get(node.left, key);
    } else if (comp > 0) {
      return get(node.right, key);
    } else {
      return node;
    }
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
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return min(root).key;
  }

  private Node min(Node node) {
    if (node.left == null) {
      return node;
    }
    return min(node.left);
  }

  @Override
  public K max() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return max(root).key;
  }

  private Node max(Node node) {
    if (node.right == null) {
      return node;
    }
    return max(node.right);
  }

  @Override
  public void deleteMin() throws IllegalAccessException {

  }

  @Override
  public void deleteMax() throws IllegalAccessException {

  }

  @Override
  public K floor(K key) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    return floor(root, key).key;
  }

  private Node floor(Node node, K key) {
    if (node == null) {
      return null;
    }
    int comp = key.compareTo(node.key);
    if (comp == 0) {
      return node;
    }
    if (comp < 0) {
      return ceiling(node.left, key);
    }
    Node rightFloor = floor(node.right, key);
    if (rightFloor == null) {
      return node;
    }
    return rightFloor;
  }

  @Override
  public K ceiling(K key) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    return ceiling(root, key).key;
  }

  private Node ceiling(Node node, K key) {
    if (node == null) {
      return null;
    }
    int comp = key.compareTo(node.key);
    if (comp == 0) {
      return node;
    }
    if (comp > 0) {
      return ceiling(node.right, key);
    }
    Node leftCeiling = ceiling(node.left, key);
    if (leftCeiling == null) {
      return node;
    }
    return leftCeiling;
  }

  public int rank(K key) {
    return rank(root, key);
  }

  private int rank(Node node, K key) {
    if (node == null) {
      return 0;
    }
    int comp = key.compareTo(node.key);
    if (comp < 0) {
      return rank(node.left, key);
    } else if (comp > 0) {
      return 1 + size(node.left) + rank(node.right, key);
    } else {
      return size(node.left);
    }
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int size() {
    return size(root);
  }

  private int size(Node node) {
    if (node == null) {
      return 0;
    }
    return node.count;
  }

  @Override
  public Iterable<K> keys() {
    LinkedListQueue<K> queue = new LinkedListQueue<>();
    inorder(root, queue);
    return queue;
  }

  private void inorder(Node node, LinkedListQueue<K> queue) {
    if (node == null) {
      return;
    }
    inorder(node.left, queue);
    queue.enqueue(node.key);
    inorder(node.right, queue);
  }
}
