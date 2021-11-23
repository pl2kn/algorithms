package com.pl2kn.algorithms.sort;

public class HeapSortTest extends SortTest {

  @Override
  public Sort createSort() {
    return new HeapSort();
  }
}
