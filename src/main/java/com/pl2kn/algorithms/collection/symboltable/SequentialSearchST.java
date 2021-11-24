package com.pl2kn.algorithms.collection.symboltable;

import java.util.Arrays;

/**
 * Sequential Search Symbol Table Implementation.
 *
 * @param <K> key type
 * @param <V> value typ
 */
public class SequentialSearchST<K extends Comparable<K>, V extends Comparable<V>> implements
    SymbolTable<K, V> {

  private Node first;

  private class Node {

    private K key;
    private V value;
    private Node next;

    public Node(K key, V value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  private int size;

  @Override
  public void put(K key, V value) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    Node current = first;
    while (current != null) {
      if (key.equals(current.key)) {
        current.value = value;
        return;
      }
      current = current.next;
    }
    first = new Node(key, value, first);
    size++;
  }

  @Override
  public V get(K key) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    Node current = first;
    while (current != null) {
      if (key.equals(current.key)) {
        return current.value;
      }
      current = current.next;
    }
    return null;
  }

  @Override
  public void delete(K key) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    Node previous = null;
    Node current = first;
    while (current != null) {
      if (key.equals(current.key)) {
        if (previous == null) {
          first = first.next;
        } else {
          previous.next = current.next;
        }
        size--;
      }
      previous = current;
      current = current.next;
    }
  }

  @Override
  public boolean contains(K key) throws IllegalAccessException {
    return get(key) != null;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterable<K> keys() {
    K[] keys = (K[]) new Comparable[size];
    Node current = first;
    int i = 0;
    while (current != null) {
      keys[i] = current.key;
      current = current.next;
    }
    return Arrays.asList(keys);
  }
}
