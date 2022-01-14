package com.pl2kn.algorithms.string;

import java.math.BigInteger;
import java.util.Random;

/**
 * Rabin-Karp algorithm implementation.
 */
public class RabinKarp {

  private final String pattern;
  private final int radix;
  private final int patternLength;
  private final long prime;
  private long rm;
  private final long patternHash;

  public RabinKarp(String pattern) {
    this.pattern = pattern;
    this.radix = 256;
    patternLength = pattern.length();
    prime = longRandomPrime();
    rm = 1;
    for (int i = 1; i <= patternLength - 1; i++) {
      rm = (radix * rm) % prime;
    }
    patternHash = hash(pattern, patternLength);
  }

  public int search(String txt) {
    int textLength = txt.length();
    if (textLength < patternLength) {
      return textLength;
    }

    long textHash = hash(txt, patternLength);
    // check for match at offset 0
    if ((patternHash == textHash) && check(txt, 0)) {
      return 0;
    }

    // check for hash match; if hash match, check for exact match
    for (int i = patternLength; i < textLength; i++) {
      // Remove leading digit, add trailing digit, check for match.
      textHash = (textHash + prime - rm * txt.charAt(i - patternLength) % prime) % prime;
      textHash = (textHash * radix + txt.charAt(i)) % prime;

      // match
      int offset = i - patternLength + 1;
      if ((patternHash == textHash) && check(txt, offset)) {
        return offset;
      }
    }

    // no match
    return textLength;
  }

  private boolean check(String text, int i) {
    for (int j = 0; j < patternLength; j++) {
      if (pattern.charAt(j) != text.charAt(i + j)) {
        return false;
      }
    }
    return true;
  }

  private long hash(String key, int m) {
    long h = 0;
    for (int j = 0; j < m; j++) {
      h = (radix * h + key.charAt(j)) % prime;
    }
    return h;
  }

  private static long longRandomPrime() {
    BigInteger prime = BigInteger.probablePrime(31, new Random());
    return prime.longValue();
  }
}
