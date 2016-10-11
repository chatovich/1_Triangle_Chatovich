package com.chatovich.triangle.entity;

/**
 * Class for the entity Triangle
 */
public class Triangle {

    private Point a;
    private Point b;
    private Point c;

    public Triangle() {
    }

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public void setB(Point b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Triangle with points a (" + this.a + "), b (" + this.b + "), c (" + this.c +")";
    }
}
