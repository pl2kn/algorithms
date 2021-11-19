package com.pl2kn.algorithms.sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class QuickSelectTest {

  @Test
  public void First_Max_Array_Test() {
    int[] array = {7, 0, 3, 4, 3, 5, 1};

    assertEquals(0, QuickSelect.select(array, 0));
  }

  @Test
  public void Desc_Sorted_Array_Test() {
    int[] array = {7, 6, 5, 4, 3, 2, 1, 0};

    assertEquals(3, QuickSelect.select(array, 3));
  }

  @Test
  public void Asc_Sorted_Array_Test() {
    int[] array = {0, 1, 2, 3, 4, 5, 6, 7};

    assertEquals(3, QuickSelect.select(array, 3));
  }

  @Test
  public void Mixed_Array_Test() {
    int[] array = {7, 0, 5, 12, 1, 6, 3, 5, 14, 2, 10, 4};

    assertEquals(2, QuickSelect.select(array, 2));
  }

  @Test
  public void Duplicates_Array_Test() {
    int[] array = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    assertEquals(2, QuickSelect.select(array, 2));
  }
}
