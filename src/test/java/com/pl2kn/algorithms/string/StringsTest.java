package com.pl2kn.algorithms.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringsTest {

  @Test
  public void Simple_LCP_Test() {
    String string = "ababffffff";
    String anotherString = "abafffff";
    assertEquals(3, Strings.lcp(string, anotherString));
  }

  @Test
  public void Zero_LCP_Test() {
    String string = "ababffffff";
    String anotherString = "fabafffff";
    assertEquals(0, Strings.lcp(string, anotherString));
  }

  @Test
  public void Simple_LRS_Test() {
    String string = "zxcvababhhjjghgjgkabab";
    assertEquals("abab", Strings.lrs(string));
  }

  @Test
  public void Wrap_LRS_Test() {
    String string = "zxcvababhhffffffghgjgkabab";
    assertEquals("fffff", Strings.lrs(string));
  }
}
