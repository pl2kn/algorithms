package com.pl2kn.algorithms.collection.symboltable;

import java.util.Arrays;

/**
 * Binary Search implementation of Symbol Table.
 *
 * @param <K> key type
 * @param <V> value type
 */
public class BinarySearchSymbolTable<K extends Comparable<K>, V> implements SymbolTable<K, V> {

  private K[] keys;

  private V[] values;

  private int size;

  public BinarySearchSymbolTable(int capacity) {
    keys = (K[]) new Comparable[capacity];
    values = (V[]) new Object[capacity];
  }

  @Override
  public void put(K key, V value) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    int rank = rank(key);
    if (rank < size && key.compareTo(keys[rank]) == 0) {
      values[rank] = value;
      return;
    }
    for (int i = size; i > rank; i--) {
      keys[i] = keys[i - 1];
      values[i] = values[i - 1];
    }
    keys[rank] = key;
    values[rank] = value;
    size++;
  }

  @Override
  public V get(K key) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    if (isEmpty()) {
      return null;
    }
    int rank = rank(key);
    if (rank < size && key.compareTo(keys[rank]) == 0) {
      return values[rank];
    }
    return null;
  }

  @Override
  public void delete(K key) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    if (isEmpty()) {
      return;
    }
    int rank = rank(key);
    if (key.compareTo(keys[rank]) != 0) {
      return;
    }
    for (int i = rank; i < size - 1; i++) {
      keys[i] = keys[i + 1];
      values[i] = values[i + 1];
    }
    size--;
    keys[size] = null;
    values[size] = null;
  }

  @Override
  public boolean contains(K key) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    if (isEmpty()) {
      return false;
    }
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
    return Arrays.asList(keys);
  }

  private int rank(K key) throws IllegalAccessException {
    if (key == null) {
      throw new IllegalAccessException();
    }
    int low = 0;
    int high = size - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int comp = key.compareTo(keys[mid]);
      if (comp == 0) {
        return mid;
      }
      if (comp < 0) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}
