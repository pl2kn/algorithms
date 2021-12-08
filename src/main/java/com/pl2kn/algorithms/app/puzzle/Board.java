package com.pl2kn.algorithms.app.puzzle;

import java.util.Iterator;

/**
 * 8-puzzle game board implementation.
 */
public class Board {

  private int[][] tiles;
  private int n;

  public Board(int[][] tiles) {
    this.tiles = new int[tiles.length][];
    for (int i = 0; i < tiles.length; i++) {
      this.tiles[i] = new int[tiles[i].length];
      for (int j = 0; j < tiles[i].length; j++) {
        this.tiles[i][j] = tiles[i][j];
      }
    }
    this.n = tiles.length;
  }

  public int dimension() {
    return n;
  }

  /**
   * Calculates the Hamming distance.
   *
   * @return the distance.
   */
  public int hamming() {
    int distance = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int value = tiles[i][j];
        if (value != 0 && value != getCorrectValue(i, j)) {
          distance++;
        }
      }
    }
    return distance;
  }

  /**
   * Calculates the Manhattan distance.
   *
   * @return the distance.
   */
  public int manhattan() {
    int distance = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int value = tiles[i][j];
        if (value != 0) {
          int rowDistance = Math.abs(getCorrectRow(value) - i);
          int colDistance = Math.abs(getCorrectCol(value) - j);
          distance += rowDistance + colDistance;
        }
      }
    }
    return distance;
  }

  /**
   * Returns the correct value for the given tile.
   *
   * @param row a row
   * @param col a col
   * @return the correct value
   */
  public int getCorrectValue(int row, int col) {
    if (row == n - 1 && col == n - 1) {
      return 0;
    }
    return row * dimension() + col + 1;
  }

  public int getCorrectRow(int value) {
    if (value == 0) {
      return n - 1;
    }
    return (value - 1) / n;
  }

  public int getCorrectCol(int value) {
    if (value == 0) {
      return n - 1;
    }
    return (value - 1) % n;
  }

  public Iterable<Board> neighbors() {
    return null;
  }

  private class BoardNeighbors implements Iterable<Board> {

    private class BoardNeighborsIterator implements Iterator<Board> {

      @Override
      public boolean hasNext() {
        return false;
      }

      @Override
      public Board next() {
        return null;
      }
    }

    @Override
    public Iterator<Board> iterator() {
      return null;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (obj.getClass() != this.getClass()) {
      return false;
    }
    Board that = (Board) obj;
    if (this.n != that.n) {
      return false;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (this.tiles[i][j] != that.tiles[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}
