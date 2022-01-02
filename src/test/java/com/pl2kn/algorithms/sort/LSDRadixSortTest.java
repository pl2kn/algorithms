package com.pl2kn.algorithms.sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LSDRadixSortTest {

  @Test
  public void Simple_Test() {
    String[] strings = {"dab", "add", "cab", "fad", "fee", "bad", "dad", "bee", "fed", "bed", "ebb", "ace"};
    LSDRadixSort.sort(strings, 3);
    assertEquals("ace", strings[0]);
    assertEquals("add", strings[1]);
    assertEquals("bad", strings[2]);
    assertEquals("bed", strings[3]);
    assertEquals("bee", strings[4]);
    assertEquals("cab", strings[5]);
    assertEquals("dab", strings[6]);
    assertEquals("dad", strings[7]);
    assertEquals("ebb", strings[8]);
    assertEquals("fad", strings[9]);
    assertEquals("fed", strings[10]);
    assertEquals("fee", strings[11]);
  }
}
