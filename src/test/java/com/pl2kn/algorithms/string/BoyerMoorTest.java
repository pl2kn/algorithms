package com.pl2kn.algorithms.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BoyerMoorTest {

  @Test
  public void Simple_Test() {
    BoyerMoor bm = new BoyerMoor("pattern");
    assertEquals(3, bm.search("asdpattern"));
  }
}
