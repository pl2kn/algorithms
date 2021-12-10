package com.pl2kn.algorithms.app.puzzle;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {

  private boolean isSolvable;

  private SearchNode solution;

  public Solver(Board board) {
    MinPQ<SearchNode> gameTree = new MinPQ<>();
    MinPQ<SearchNode> twinGameTree = new MinPQ<>();
    gameTree.insert(new SearchNode(board, 0, null));
    twinGameTree.insert(new SearchNode(board.twin(), 0, null));
    while (true) {
      SearchNode current = gameTree.delMin();
      SearchNode currentTwin = twinGameTree.delMin();
      if (currentTwin.board.isGoal()) {
        isSolvable = false;
        solution = null;
        return;
      }
      if (current.board.isGoal()) {
        isSolvable = true;
        solution = current;
        return;
      }
      for (Board neighbour : current.board.neighbors()) {
        if (current.previous == null || !current.previous.board.equals(neighbour)) {
          gameTree.insert(new SearchNode(neighbour, current.movesCount + 1, current));
        }
      }
      for (Board neighbour : currentTwin.board.neighbors()) {
        if (currentTwin.previous == null || !currentTwin.previous.board.equals(neighbour)) {
          twinGameTree.insert(new SearchNode(neighbour, currentTwin.movesCount + 1, currentTwin));
        }
      }
    }
  }

  public boolean isSolvable() {
    return isSolvable;
  }

  public Iterable<Board> solution() {
    Stack<Board> solutionBoards = new Stack<>();
    SearchNode current = solution;
    while (current != null) {
      solutionBoards.push(current.board);
      current = current.previous;
    }
    return solutionBoards;
  }

  public int moves() {
    return solution.movesCount;
  }

  private class SearchNode implements Comparable<SearchNode> {

    private Board board;
    private int movesCount;
    private SearchNode previous;
    private int priority;

    public SearchNode(Board board, int movesCount, SearchNode previous) {
      this.board = board;
      this.movesCount = movesCount;
      this.previous = previous;
      this.priority = board.manhattan() + movesCount;
    }

    public int priority() {
      return priority;
    }

    @Override
    public int compareTo(SearchNode o) {
      if (priority() > o.priority()) {
        return 1;
      } else if (priority() < o.priority()) {
        return -1;
      } else {
        return 0;
      }
    }
  }

  public static void main(String[] args) {
    int[][] tiles = {
        {0, 1, 3},
        {4, 2, 5},
        {7, 8, 6}
    };
    Board init = new Board(tiles);
    Solver solver = new Solver(init);
    if (!solver.isSolvable()) {
      StdOut.println("No solution possible");
    } else {
      StdOut.println("Minimum number of moves = " + solver.moves());
      for (Board board : solver.solution()) {
        StdOut.println(board);
      }
    }
  }
}
