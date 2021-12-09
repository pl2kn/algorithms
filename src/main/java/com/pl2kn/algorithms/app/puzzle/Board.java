package com.pl2kn.algorithms.app.puzzle;

import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;

/**
 * 8-puzzle game board implementation.
 */
public class Board {

  private int[][] tiles;
  private int dimension;

  /**
   * Constructs the board.
   *
   * @param tiles tiles to construct from
   */
  public Board(int[][] tiles) {
    this.tiles = new int[tiles.length][];
    for (int i = 0; i < tiles.length; i++) {
      this.tiles[i] = new int[tiles[i].length];
      for (int j = 0; j < tiles[i].length; j++) {
        this.tiles[i][j] = tiles[i][j];
      }
    }
    this.dimension = tiles.length;
  }

  public int dimension() {
    return dimension;
  }

  /**
   * Calculates the Hamming distance.
   *
   * @return the distance.
   */
  public int hamming() {
    int distance = 0;
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
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
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
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
   * Checks whether the puzzle is solved.
   *
   * @return result of the check
   */
  public boolean isGoal() {
    int value = 1;
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        if (i == dimension - 1 && j == dimension - 1) {
          if (tiles[i][j] != 0) {
            return false;
          }
        } else {
          if (tiles[i][j] != value) {
            return false;
          }
        }
        value++;
      }
    }
    return true;
  }

  /**
   * Returns the correct value for the given tile.
   *
   * @param row a row
   * @param col a col
   * @return the correct value
   */
  public int getCorrectValue(int row, int col) {
    if (row == dimension - 1 && col == dimension - 1) {
      return 0;
    }
    return row * dimension() + col + 1;
  }

  /**
   * Returns the row of the correct value.
   *
   * @param value the value
   * @return the row of the value
   */
  public int getCorrectRow(int value) {
    if (value == 0) {
      return dimension - 1;
    }
    return (value - 1) / dimension;
  }

  /**
   * Returns the col of the correct value.
   *
   * @param value the value
   * @return the coll of the value
   */
  public int getCorrectCol(int value) {
    if (value == 0) {
      return dimension - 1;
    }
    return (value - 1) % dimension;
  }

  /**
   * Changes two tiles places.
   *
   * @param row1 the row of the first tile
   * @param col1 the col of the first tile
   * @param row2 the row of the second tile
   * @param col2 the col of the second tile
   */
  public void swapTiles(int row1, int col1, int row2, int col2) {
    int temp = tiles[row1][col1];
    tiles[row1][col1] = tiles[row2][col2];
    tiles[row2][col2] = temp;
  }

  private boolean isTileExists(int row, int col) {
    return row >= 0 && row < dimension && col >= 0 && col < dimension;
  }

  /**
   * Returns the neighbours of the board.
   *
   * @return the queue of the neighbours
   */
  public Iterable<Board> neighbors() {
    int zeroRow = 0;
    int zeroCol = 0;
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        if (tiles[i][j] == 0) {
          zeroRow = i;
          zeroCol = j;
          break;
        }
      }
    }
    Queue<Board> neighbours = new Queue<>();
    enqueueNeighbour(neighbours, zeroRow, zeroCol, zeroRow - 1, zeroCol);
    enqueueNeighbour(neighbours, zeroRow, zeroCol, zeroRow + 1, zeroCol);
    enqueueNeighbour(neighbours, zeroRow, zeroCol, zeroRow, zeroCol - 1);
    enqueueNeighbour(neighbours, zeroRow, zeroCol, zeroRow, zeroCol + 1);

    return neighbours;
  }

  public Board twin() {
    int[][] tilesCopy = new int[dimension][dimension];
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        tilesCopy[i][j] = tiles[i][j];
      }
    }
    Board twinBoard = new Board(tilesCopy);
    if (tilesCopy[0][0] != 0 && tiles[0][1] != 0) {
      twinBoard.swapTiles(0, 0, 0, 1);
    } else {
      twinBoard.swapTiles(1, 0, 1, 1);
    }
    return twinBoard;
  }

  private void enqueueNeighbour(Queue<Board> neighbours, int zeroRow, int zeroCol, int row, int col) {
    if (isTileExists(row, col)) {
      Board neighbour = new Board(tiles);
      neighbour.swapTiles(zeroRow, zeroCol, row, col);
      neighbours.enqueue(neighbour);
    }
  }

  @Override
  public String toString() {
    String result = dimension + "\n";
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        result += " " + tiles[i][j];
      }
      result += "\n";
    }

    return result;
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
    if (this.dimension != that.dimension) {
      return false;
    }
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        if (this.tiles[i][j] != that.tiles[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}
