package com.company.objectInput;

import java.io.Serializable;

public class Line implements Serializable {
    private Point point1;
    private Point point2;
    private int index;

    public Line(Point point1, Point point2, int index) {
        this.point1 = point1;
        this.point2 = point2;
        this.index = index;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Line{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                ", index=" + index +
                '}';
    }
}
