package com.pl2kn.algorithms.compression;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/**
 * Compressing using run-length coding with 8-bit run lengths.
 */
public class RunLength {

  private static final int R = 256;
  private static final int LG_R = 8;

  private RunLength() {
  }

  /**
   * Reads a sequence of bits from standard input and decodes them.
   */
  public static void expand() {
    boolean b = false;
    while (!BinaryStdIn.isEmpty()) {
      int run = BinaryStdIn.readInt(LG_R);
      for (int i = 0; i < run; i++) {
        BinaryStdOut.write(b);
      }
      b = !b;
    }
    BinaryStdOut.close();
  }

  /**
   * Reads a sequence of bits from standard input and compresses them using run-length coding with
   * 8-bit run lengths.
   */
  public static void compress() {
    char run = 0;
    boolean old = false;
    while (!BinaryStdIn.isEmpty()) {
      boolean b = BinaryStdIn.readBoolean();
      if (b != old) {
        BinaryStdOut.write(run, LG_R);
        run = 1;
        old = !old;
      } else {
        if (run == R - 1) {
          BinaryStdOut.write(run, LG_R);
          run = 0;
          BinaryStdOut.write(run, LG_R);
        }
        run++;
      }
    }
    BinaryStdOut.write(run, LG_R);
    BinaryStdOut.close();
  }
}
