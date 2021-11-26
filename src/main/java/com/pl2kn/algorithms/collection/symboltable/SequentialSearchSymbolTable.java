package com.pl2kn.algorithms.collection.symboltable;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Sequential Search Symbol Table Implementation.
 *
 * @param <K> key type
 * @param <V> value typ
 */
public class SequentialSearchSymbolTable<K extends Comparable<K>, V> implements SymbolTable<K, V> {

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
  public K min() {
    K min = first.key;
    Node current = first.next;
    while (current != null) {
      if (current.key.compareTo(min) < 0) {
        min = current.key;
      }
      current = current.next;
    }
    return min;
  }

  @Override
  public K max() {
    K max = first.key;
    Node current = first.next;
    while (current != null) {
      if (current.key.compareTo(max) > 0) {
        max = current.key;
      }
      current = current.next;
    }
    return max;
  }

  @Override
  public void deleteMin() throws IllegalAccessException {
    delete(min());
  }

  @Override
  public void deleteMax() throws IllegalAccessException {
    delete(max());
  }

  @Override
  public K floor(K key) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    K floor = null;
    Node current = first.next;
    while (current != null) {
      if (current.key.compareTo(key) <= 0) {
        if (floor == null) {
          floor = current.key;
        } else if (current.key.compareTo(floor) > 0) {
          floor = current.key;
        }
      }
      current = current.next;
    }
    if (floor == null) {
      throw new NoSuchElementException();
    }
    return floor;
  }

  @Override
  public K ceiling(K key) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    K ceiling = null;
    Node current = first.next;
    while (current != null) {
      if (current.key.compareTo(key) >= 0) {
        if (ceiling == null) {
          ceiling = current.key;
        } else if (current.key.compareTo(ceiling) < 0) {
          ceiling = current.key;
        }
      }
      current = current.next;
    }
    if (ceiling == null) {
      throw new NoSuchElementException();
    }
    return ceiling;
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
