package com.pl2kn.algorithms.collection.symboltable;

import com.pl2kn.algorithms.collection.list.LinkedListQueue;
import java.util.NoSuchElementException;

/**
 * Red Black Binary Search Implementation.
 *
 * @param <K> key type
 * @param <V> value type
 */
public class RedBlackBinarySearchTree<K extends Comparable<K>, V> implements SymbolTable<K, V> {

  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private Node root;

  private class Node {

    private K key;
    private V value;
    private Node left;
    private Node right;
    private boolean color;
    private int count;

    public Node(K key, V value, boolean color, int count) {
      this.key = key;
      this.value = value;
      this.color = color;
      this.count = count;
    }
  }

  @Override
  public void put(K key, V value) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    root = put(root, key, value);
  }

  private Node put(Node node, K key, V value) {
    if (node == null) {
      return new Node(key, value, RED, 1);
    }
    int comp = key.compareTo(node.key);
    if (comp < 0) {
      node.left = put(node.left, key, value);
    } else if (comp > 0) {
      node.right = put(node.right, key, value);
    } else {
      node.value = value;
    }
    if (isRed(node.right) && !isRed(node.left)) {
      node = rotateLeft(node);
    }
    if (isRed(node.left) && isRed(node.left.left)) {
      node = rotateRight(node);
    }
    if (isRed(node.left) && isRed(node.right)) {
      flipColors(node);
    }
    node.count = 1 + size(node.left) + size(node.right);
    return node;
  }

  @Override
  public V get(K key) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    return get(root, key);
  }

  private V get(Node node, K key) {
    if (node == null) {
      return null;
    }
    int comp = key.compareTo(node.key);
    if (comp < 0) {
      return get(node.left, key);
    } else if (comp > 0) {
      return get(node.right, key);
    } else {
      return node.value;
    }
  }

  @Override
  public void delete(K key) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    root = delete(root, key);
  }

  private Node delete(Node node, K key) {
    if (node == null) {
      return null;
    }
    int comp = key.compareTo(node.key);
    if (comp < 0) {
      node.left = delete(node.left, key);
    } else if (comp > 0) {
      node.right = delete(node.right, key);
    } else {
      if (node.right == null) {
        return node.left;
      }
      if (node.left == null) {
        return node.right;
      }
      Node temp = node;
      node = min(node.right);
      node.right = deleteMin(temp.right);
      node.left = temp.left;
    }
    node.count = 1 + size(node.left) + size(node.right);
    return node;
  }

  @Override
  public boolean contains(K key) throws IllegalAccessException {
    return get(key) != null;
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
    root = deleteMin(root);
  }

  private Node deleteMin(Node node) {
    if (node.left == null) {
      return node.right;
    }
    node.left = deleteMin(node.left);
    node.count = 1 + size(node.left) + size(node.right);
    return node;
  }

  @Override
  public void deleteMax() throws IllegalAccessException {
    root = deleteMax(root);
  }

  private Node deleteMax(Node node) {
    if (node.right == null) {
      return node.left;
    }
    node.right = deleteMax(node.right);
    node.count = 1 + size(node.left) + size(node.right);
    return node;
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
      return floor(node.left, key);
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
    return size() == 0;
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

  private Node rotateLeft(Node node) {
    Node newRoot = node.right;
    node.right = newRoot.left;
    newRoot.left = node;
    newRoot.color = node.color;
    node.color = RED;
    return newRoot;
  }

  private Node rotateRight(Node node) {
    Node newRoot = node.left;
    node.left = newRoot.right;
    newRoot.right = node;
    newRoot.color = node.color;
    node.color = RED;
    return newRoot;
  }

  private void flipColors(Node node) {
    node.color = RED;
    node.left.color = BLACK;
    node.right.color = BLACK;
  }

  private boolean isRed(Node node) {
    if (node == null) {
      return false;
    }
    return node.color;
  }
}
