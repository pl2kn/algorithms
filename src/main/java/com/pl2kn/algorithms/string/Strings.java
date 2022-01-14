package com.pl2kn.algorithms.string;

import java.util.Arrays;

/**
 * String basic operations' implementation.
 */
public class Strings {

  /**
   * Computes the length of the longest common prefix.
   *
   * @param string        the first string
   * @param anotherString the second string
   * @return the length of the longest common prefix
   */
  public static int lcp(String string, String anotherString) {
    int n = Math.min(string.length(), anotherString.length());
    for (int i = 0; i < n; i++) {
      if (string.charAt(i) != anotherString.charAt(i)) {
        return i;
      }
    }
    return n;
  }

  /**
   * Returns the longest repeated substring in the given string.
   *
   * @param string the string
   * @return the longest repeated substring
   */
  public static String lrs(String string) {
    int stringLength = string.length();
    String[] suffixes = new String[stringLength];
    for (int i = 0; i < stringLength; i++) {
      suffixes[i] = string.substring(i, stringLength);
    }
    Arrays.sort(suffixes);
    String lrs = "";
    for (int i = 0; i < stringLength - 1; i++) {
      int len = lcp(suffixes[i], suffixes[i + 1]);
      if (len > lrs.length()) {
        lrs = suffixes[i].substring(0, len);
      }
    }
    return lrs;
  }

  /**
   * Return the pattern substring position in the text.
   *
   * @param pattern the pattern
   * @param text    the text
   * @return the position
   */
  public static int search(String pattern, String text) {
    int patternLength = pattern.length();
    int textLength = text.length();
    for (int i = 0; i < textLength - patternLength; i++) {
      int j;
      for (j = 0; j < patternLength; j++) {
        if (text.charAt(i + j) != pattern.charAt(j)) {
          break;
        }
      }
      if (j == patternLength) {
        return i;
      }
    }
    return textLength;
  }

  /**
   * Return the pattern substring position in the text with implicit backup.
   *
   * @param pattern the pattern
   * @param text    the text
   * @return the position
   */
  public static int altSearch(String pattern, String text) {
    int patternLength = pattern.length();
    int textLength = text.length();
    int i;
    int j;
    for (i = 0, j = 0; i < textLength && j < patternLength; i++) {
      if (text.charAt(i) == pattern.charAt(j)) {
        j++;
      } else {
        i -= j;
        j = 0;
      }
    }
    if (j == patternLength) {
      return i - patternLength;
    }

    return textLength;
  }
}
