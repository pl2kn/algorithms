package com.pl2kn.algorithms.collection.symboltable;

/**
 * Open Addressing Hash Table Implementation.
 *
 * @param <K> key type
 * @param <V> value type
 */
public class OpenAddressingHashTable<K, V> implements HashTable<K, V> {

  private int tableSize = 10000;
  private int size;
  private V[] values = (V[]) new Object[tableSize];
  private K[] keys = (K[]) new Object[tableSize];

  @Override
  public void put(K key, V value) {
    int i;
    for (i = hash(key); keys[i] != null; i = (i + 1) % tableSize) {
      if (key.equals(keys[i])) {
        return;
      }
    }
    keys[i] = key;
    values[i] = value;
    size++;
  }

  @Override
  public V get(K key) {
    for (int i = hash(key); keys[i] != null; i = (i + 1) % tableSize) {
      if (key.equals(keys[i])) {
        return values[i];
      }
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
