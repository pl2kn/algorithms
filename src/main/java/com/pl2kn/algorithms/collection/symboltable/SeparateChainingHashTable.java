package com.pl2kn.algorithms.collection.symboltable;

/**
 * Separate Chaining Hash Table implementation.
 *
 * @param <K> key type
 * @param <V> value type
 */
public class SeparateChainingHashTable<K, V> implements HashTable<K, V> {

  private int size;
  private int tableSize;
  private HashTableNode<K, V>[] table;

  public SeparateChainingHashTable(int m) {
    tableSize = m;
    table = (HashTableNode<K, V>[]) new HashTableNode[m];
  }

  @Override
  public void put(K key, V value) {
    int i = hash(key);
    HashTableNode<K, V> current = table[i];
    while (current != null) {
      if (key.equals(current.getKey())) {
        current.setValue(value);
        return;
      }
      current = current.getNext();
    }
    table[i] = new HashTableNode<>(key, value, table[i]);
    size++;
  }

  @Override
  public V get(K key) {
    int i = hash(key);
    HashTableNode<K, V> current = table[i];
    while (current != null) {
      if (key.equals(current.getKey())) {
        return current.getValue();
      }
      current = current.getNext();
    }
    return null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  private int hash(K key) {
    return Math.abs(key.hashCode()) % tableSize;
  }
}
