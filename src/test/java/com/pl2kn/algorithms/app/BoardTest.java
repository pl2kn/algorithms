package com.pl2kn.algorithms.app;

import static org.junit.jupiter.api.Assertions.*;

import com.pl2kn.algorithms.app.puzzle.Board;
import java.util.ArrayList;
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

  @Test
  public void Four_Neighbours_Test() {
    int[][] tiles = {
        {8, 1, 3},
        {4, 0, 2},
        {7, 6, 5}
    };
    Board board = new Board(tiles);

    int[][] neighbourTiles1 = {
        {8, 0, 3},
        {4, 1, 2},
        {7, 6, 5}
    };
    Board neighbour1 = new Board(neighbourTiles1);

    int[][] neighbourTiles2 = {
        {8, 1, 3},
        {4, 6, 2},
        {7, 0, 5}
    };
    Board neighbour2 = new Board(neighbourTiles2);

    int[][] neighbourTiles3 = {
        {8, 1, 3},
        {0, 4, 2},
        {7, 6, 5}
    };
    Board neighbour3 = new Board(neighbourTiles3);

    int[][] neighbourTiles4 = {
        {8, 1, 3},
        {4, 2, 0},
        {7, 6, 5}
    };
    Board neighbour4 = new Board(neighbourTiles4);

    ArrayList<Board> expectedNeighbours = new ArrayList<>();
    expectedNeighbours.add(neighbour1);
    expectedNeighbours.add(neighbour2);
    expectedNeighbours.add(neighbour3);
    expectedNeighbours.add(neighbour4);

    Iterable<Board> boards = board.neighbors();
    int neighbourCount = 0;
    for (Board neighbour : boards) {
      assertTrue(expectedNeighbours.contains(neighbour));
      neighbourCount++;
    }
    assertEquals(expectedNeighbours.size(), neighbourCount);
  }

  @Test
  public void Three_Neighbours_Test() {
    int[][] tiles = {
        {8, 0, 3},
        {4, 1, 2},
        {7, 6, 5}
    };
    Board board = new Board(tiles);

    int[][] neighbourTiles1 = {
        {8, 1, 3},
        {4, 0, 2},
        {7, 6, 5}
    };
    Board neighbour1 = new Board(neighbourTiles1);

    int[][] neighbourTiles2 = {
        {0, 8, 3},
        {4, 1, 2},
        {7, 6, 5}
    };
    Board neighbour2 = new Board(neighbourTiles2);

    int[][] neighbourTiles3 = {
        {8, 3, 0},
        {4, 1, 2},
        {7, 6, 5}
    };
    Board neighbour3 = new Board(neighbourTiles3);

    ArrayList<Board> expectedNeighbours = new ArrayList<>();
    expectedNeighbours.add(neighbour1);
    expectedNeighbours.add(neighbour2);
    expectedNeighbours.add(neighbour3);

    Iterable<Board> boards = board.neighbors();
    int neighbourCount = 0;
    for (Board neighbour : boards) {
      assertTrue(expectedNeighbours.contains(neighbour));
      neighbourCount++;
    }
    assertEquals(expectedNeighbours.size(), neighbourCount);
  }

  @Test
  public void Two_Neighbours_Test() {
    int[][] tiles = {
        {0, 8, 3},
        {4, 1, 2},
        {7, 6, 5}
    };
    Board board = new Board(tiles);

    int[][] neighbourTiles1 = {
        {4, 8, 3},
        {0, 1, 2},
        {7, 6, 5}
    };
    Board neighbour1 = new Board(neighbourTiles1);

    int[][] neighbourTiles2 = {
        {8, 0, 3},
        {4, 1, 2},
        {7, 6, 5}
    };
    Board neighbour2 = new Board(neighbourTiles2);

    ArrayList<Board> expectedNeighbours = new ArrayList<>();
    expectedNeighbours.add(neighbour1);
    expectedNeighbours.add(neighbour2);

    Iterable<Board> boards = board.neighbors();
    int neighbourCount = 0;
    for (Board neighbour : boards) {
      assertTrue(expectedNeighbours.contains(neighbour));
      neighbourCount++;
    }
    assertEquals(expectedNeighbours.size(), neighbourCount);
  }

  @Test
  public void Is_Not_Goal_Test() {
    int[][] tiles = {
        {0, 8, 3},
        {4, 1, 2},
        {7, 6, 5}
    };
    Board board = new Board(tiles);
    assertFalse(board.isGoal());
  }

  @Test
  public void Is_Goal_Test() {
    int[][] tiles = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}
    };
    Board board = new Board(tiles);
    assertTrue(board.isGoal());
  }

  @Test
  public void Three_Dimension_End_Zero_Twin_Test() {
    int[][] tiles = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}
    };
    Board board = new Board(tiles);
    int[][] expectedTwin = {
        {2, 1, 3},
        {4, 5, 6},
        {7, 8, 0}
    };
    Board expectedTwinBoard = new Board(expectedTwin);
    assertEquals(expectedTwinBoard, board.twin());
  }

  @Test
  public void Three_Dimension_With_Zero_Twin_Test() {
    int[][] tiles = {
        {1, 0, 3},
        {4, 5, 6},
        {7, 8, 2}
    };
    Board board = new Board(tiles);
    int[][] expectedTwin = {
        {1, 0, 3},
        {5, 4, 6},
        {7, 8, 2}
    };
    Board expectedTwinBoard = new Board(expectedTwin);
    assertEquals(expectedTwinBoard, board.twin());
  }
}
