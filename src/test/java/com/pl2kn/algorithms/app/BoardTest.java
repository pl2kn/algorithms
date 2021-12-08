package com.pl2kn.algorithms.app;

import static org.junit.jupiter.api.Assertions.*;

import com.pl2kn.algorithms.app.puzzle.Board;
import org.junit.jupiter.api.Test;

public class BoardTest {

  @Test
  public void Get_Correct_Row_Test() {
    int[][] tiles = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}
    };
    Board board = new Board(tiles);
    assertEquals(1, board.getCorrectRow(4));
    assertEquals(0, board.getCorrectRow(1));
    assertEquals(1, board.getCorrectRow(6));
    assertEquals(2, board.getCorrectRow(8));
    assertEquals(2, board.getCorrectRow(0));
  }

  @Test
  public void Get_Correct_Col_Test() {
    int[][] tiles = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}
    };
    Board board = new Board(tiles);
    assertEquals(0, board.getCorrectCol(1));
    assertEquals(2, board.getCorrectCol(3));
    assertEquals(0, board.getCorrectCol(4));
    assertEquals(2, board.getCorrectCol(6));
    assertEquals(1, board.getCorrectCol(8));
    assertEquals(2, board.getCorrectCol(0));
  }

  @Test
  public void Get_Correct_Value_Test() {
    int[][] tiles = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}
    };
    Board board = new Board(tiles);
    assertEquals(1, board.getCorrectValue(0, 0));
    assertEquals(2, board.getCorrectValue(0, 1));
    assertEquals(3, board.getCorrectValue(0, 2));
    assertEquals(5, board.getCorrectValue(1, 1));
    assertEquals(8, board.getCorrectValue(2, 1));
    assertEquals(0, board.getCorrectValue(2, 2));
  }

  @Test
  public void Get_Hamming_Test() {
    int[][] tiles = {
        {8, 1, 3},
        {4, 0, 2},
        {7, 6, 5}
    };
    Board board = new Board(tiles);
    assertEquals(5, board.hamming());
  }

  @Test
  public void Get_Manhattan_Test() {
    int[][] tiles = {
        {8, 1, 3},
        {4, 0, 2},
        {7, 6, 5}
    };
    Board board = new Board(tiles);
    assertEquals(10, board.manhattan());
  }

  @Test
  public void Get_Equals_Test() {
    int[][] tiles1 = {
        {8, 1, 3},
        {4, 0, 2},
        {7, 6, 5}
    };
    int[][] tiles2 = {
        {8, 1, 3},
        {4, 0, 2},
        {7, 6, 5}
    };
    Board board1 = new Board(tiles1);
    Board board2 = new Board(tiles2);
    assertEquals(board1, board2);
  }
}
