package com.pl2kn.algorithms.sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class QuickSelectTest {

  @Test
  public void Event_Element_Array_Test() {
    int[] array = {7, 0, 3, 4, 3, 5, 1};

    assertEquals(3, QuickSelect.select(array, 3));
  }
}
