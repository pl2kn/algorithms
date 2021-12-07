package com.pl2kn.algorithms.app.collinearpoints;

public class BruteCollinearPoints {

  private LineSegment[] segments = new LineSegment[4];
  private int numberOfSegments;

  public BruteCollinearPoints(Point[] points) {
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
    for (int i = 0; i < points.length - 3; i++) {
      for (int j = i + 1; j < points.length - 2; j++) {
        for (int l = j + 1; l < points.length - 1; l++) {
          for (int k = l + 1; k < points.length; k++) {
            if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[l])
                && points[i].slopeTo(points[j]) == points[i].slopeTo(points[k])) {
              if (numberOfSegments == segments.length) {
                resize(numberOfSegments * 2);
              }
              Point[] collinearPoints = {points[i], points[j], points[l], points[k]};
              Point minPoint = collinearPoints[0];
              Point maxPoint = collinearPoints[0];
              for (Point collinearPoint: collinearPoints) {
                if (collinearPoint.compareTo(minPoint) < 0) {
                  minPoint = collinearPoint;
                }
                if (collinearPoint.compareTo(maxPoint) > 0) {
                  maxPoint = collinearPoint;
                }
              }
              segments[numberOfSegments++] = new LineSegment(minPoint, maxPoint);
            }
          }
        }
      }
    }
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

  private void resize(int capacity) {
    LineSegment[] temp = new LineSegment[capacity];
    for (int i = 0; i < numberOfSegments; i++) {
      temp[i] = segments[i];
    }
    segments = temp;
  }
}
