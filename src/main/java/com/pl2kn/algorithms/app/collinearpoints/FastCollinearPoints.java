package com.pl2kn.algorithms.app.collinearpoints;

import java.util.Arrays;

public class FastCollinearPoints {

  private LineSegment[] segments = new LineSegment[4];
  private int numberOfSegments;

  public FastCollinearPoints(Point[] points) {
    if (points == null) {
      throw new IllegalArgumentException();
    }
    for (Point point : points) {
      if (point == null) {
        throw new IllegalArgumentException();
      }
    }
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points.length; j++) {
        if (i != j && points[i].compareTo(points[j]) == 0) {
          throw new IllegalArgumentException();
        }
      }
    }
    Point[] sortPoints = new Point[points.length];
    for (int i = 0; i < points.length; i++) {
      sortPoints[i] = points[i];
    }
    for (Point originPoint : points) {
      Arrays.sort(sortPoints, originPoint.slopeOrder());
      int seqCount = 0;
      for (int i = 1; i < sortPoints.length - 1; i++) {
        if (originPoint.slopeTo(sortPoints[i]) == originPoint.slopeTo(sortPoints[i + 1])) {
          seqCount++;
        } else {
          if (seqCount + 1 >= 3) {
            addCollinearPoints(originPoint, sortPoints, i - seqCount, i);
          }
          seqCount = 0;
        }
      }
      if (seqCount + 1 >= 3) {
        addCollinearPoints(originPoint, sortPoints, sortPoints.length - 1 - seqCount, sortPoints.length - 1);
      }
    }
  }

  private void addCollinearPoints(Point originPoint, Point[] sortPoints, int start, int end) {
    Point[] collinearPoints = new Point[end - start + 2];
    int m = 0;
    for (int j = start; j <= end; j++) {
      collinearPoints[m++] = sortPoints[j];
    }
    collinearPoints[m++] = originPoint;
    Arrays.sort(collinearPoints);
    if (originPoint.compareTo(collinearPoints[0]) == 0) {
      LineSegment newLineSegment = new LineSegment(collinearPoints[0], collinearPoints[m - 1]);
      if (numberOfSegments == segments.length) {
        resize(numberOfSegments * 2);
      }
      segments[numberOfSegments++] = newLineSegment;
    }
  }

  private void resize(int capacity) {
    LineSegment[] temp = new LineSegment[capacity];
    for (int i = 0; i < numberOfSegments; i++) {
      temp[i] = segments[i];
    }
    segments = temp;
  }

  private Point[] resizePoints(Point[] points, int capacity) {
    Point[] newPoints = new Point[capacity];
    for (int i = 0; i < points.length; i++) {
      newPoints[i] = points[i];
    }
    return newPoints;
  }

  public int numberOfSegments() {
    return numberOfSegments;
  }

  public LineSegment[] segments() {
    LineSegment[] result = new LineSegment[numberOfSegments];
    for (int i = 0; i < numberOfSegments; i++) {
      result[i] = segments[i];
    }
    return result;
  }

  public static void main(String[] args) {
//    Point[] points = new Point[8];
//    points[0] = new Point(10000, 0);
//    points[1] = new Point(0, 10000);
//    points[2] = new Point(3000, 7000);
//    points[3] = new Point(7000, 3000);
//    points[4] = new Point(20000, 21000);
//    points[5] = new Point(3000, 4000);
//    points[6] = new Point(14000, 15000);
//    points[7] = new Point(6000, 7000);

    Point[] points = new Point[15];
    points[0] = new Point(10000, 0);
    points[1] = new Point(8000, 2000);
    points[2] = new Point(2000, 8000);
    points[3] = new Point(0, 10000);
    points[4] = new Point(20000, 0);
    points[5] = new Point(18000, 2000);
    points[6] = new Point(2000, 18000);
    points[7] = new Point(10000, 20000);
    points[8] = new Point(30000, 0);
    points[9] = new Point(0 , 30000);
    points[10] = new Point(20000 , 10000);
    points[11] = new Point(13000 , 0);
    points[12] = new Point(11000 , 3000);
    points[13] = new Point(5000 , 12000);
    points[14] = new Point(9000 , 6000);

//    Point[] points = new Point[4];
//
//    points[0] = new Point(8903, 14085);
//    points[1] = new Point(7001, 14085);
//    points[2] = new Point(16137, 14085);
//    points[3] = new Point(11541, 14085);

    FastCollinearPoints fast = new FastCollinearPoints(points);
    LineSegment[] segments = fast.segments();
  }
}
