package com.pl2kn.algorithms.app.deques;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

  private static final int INIT_CAPACITY = 8;
  private Item[] items;
  private int size;

  public RandomizedQueue() {
    items = (Item[]) new Object[INIT_CAPACITY];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void enqueue(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    if (size == items.length) {
      resize(size * 2);
    }
    items[size++] = item;
  }

  public Item dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    if (size == items.length / 4) {
      resize(size / 2);
    }
    int randomIndex = StdRandom.uniform(size);
    Item item = items[randomIndex];
    items[randomIndex] = items[--size];
    items[size] = null;
    return item;
  }

  public Item sample() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return items[StdRandom.uniform(size)];
  }

  private void resize(int capacity) {
    Item[] newItems = (Item[]) new Object[capacity];
    for (int i = 0; i < size; i++) {
      newItems[i] = items[i];
    }
    items = newItems;
  }

  private class RandomizedQueueIterator implements Iterator<Item> {

    private int currentIndex;
    private int[] randomIndices;

    public RandomizedQueueIterator() {
      randomIndices = new int[size];
      for (int i = 0; i < size; i++) {
        randomIndices[i] = i;
      }
      StdRandom.shuffle(randomIndices);
      this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
      return currentIndex < size;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return items[randomIndices[currentIndex++]];
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  @Override
  public Iterator<Item> iterator() {
    return new RandomizedQueueIterator();
  }

  public static void main(String[] args) {
  }
}
