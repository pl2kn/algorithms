package com.pl2kn.algorithms.app.collinearpoints;

import edu.princeton.cs.algs4.StdDraw;
import java.util.Comparator;

public class Point implements Comparable<Point> {

  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void draw() {
    StdDraw.point(x, y);
  }

  public void drawTo(Point that) {
    StdDraw.line(this.x, this.y, that.x, that.y);
  }

  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  public double slopeTo(Point that) {
    if (x == that.x) {
      if (y == that.y) {
        return Double.NEGATIVE_INFINITY;
      }
      return Double.POSITIVE_INFINITY;
    } else if (y == that.y) {
      return +0.0;
    }
    return (double) (that.y - this.y) / (that.x - this.x);
  }

  private class SlopeOrderComparator implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
      double slope1 = slopeTo(o1);
      double slope2 = slopeTo(o2);
      if (slope1 < slope2) {
        return -1;
      } else if (slope1 > slope2) {
        return 1;
      } else {
        return 0;
      }
    }
  }

  public Comparator<Point> slopeOrder() {
    return new SlopeOrderComparator();
  }

  @Override
  public int compareTo(Point o) {
    if (this.y < o.y) {
      return -1;
    }
    if (this.y == o.y) {
      if (this.x < o.x) {
        return -1;
      } else if (this.x > o.x) {
        return 1;
      }
      return 0;
    }
    return 1;
  }
}
