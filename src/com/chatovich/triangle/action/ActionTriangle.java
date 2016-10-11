package com.chatovich.triangle.action;

import com.chatovich.triangle.entity.Point;
import com.chatovich.triangle.entity.Triangle;
import com.chatovich.triangle.exception.WrongDataException;

/**
 * Calculates  different parameters of the triangle (e.g. side length, perimeter, area ...)
 */
public class ActionTriangle {

    /** calculates the distance between two points
     * @param a the first point
     * @param b the second point
     * @return the distance between two points*/
    public double calcLength (Point a, Point b){

        return Math.sqrt(Math.pow(a.getX()-b.getX(),2)+Math.pow(a.getY()-b.getY(),2));

    }

    /** calculates the perimeter of the triangle
     * @param triangle the triangle which perimeter should be calculated
     * @return perimeter of the triangle */
    public double calcPerimeter (Triangle triangle){

        ActionTriangle actionTriangle = new ActionTriangle();
        double side1 = actionTriangle.calcLength(triangle.getA(), triangle.getB());
        double side2 = actionTriangle.calcLength(triangle.getB(), triangle.getC());
        double side3 = actionTriangle.calcLength(triangle.getA(), triangle.getC());

        return side1+side2+side3;

    }

    /** calculates the area of the triangle using Heron's formula
     * @param triangle the triangle which area should be calculated
     * @return the area of the triangle */
    public double calcArea (Triangle triangle){

        ActionTriangle actionTriangle = new ActionTriangle();
        double perimeter = actionTriangle.calcPerimeter(triangle);
        double side1 = actionTriangle.calcLength(triangle.getA(), triangle.getB());
        double side2 = actionTriangle.calcLength(triangle.getB(), triangle.getC());
        double side3 = actionTriangle.calcLength(triangle.getA(), triangle.getC());

        return Math.sqrt(perimeter/2*(perimeter/2-side1)*(perimeter/2-side2)*(perimeter/2-side3));

    }

    /** checks whether the triangle is right-angled
     * @param triangle the triangle
     * @return true if the triangle is right-angled one */
    public boolean isRightAngledTriangle (Triangle triangle) {

        ActionTriangle actionTriangle = new ActionTriangle();
        double side1 = actionTriangle.calcLength(triangle.getA(), triangle.getB());
        double side2 = actionTriangle.calcLength(triangle.getB(), triangle.getC());
        double side3 = actionTriangle.calcLength(triangle.getA(), triangle.getC());
        double[] array = {side1, side2, side3};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j + 1] > array[j]) {
                    double temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return Math.pow(array[0], 2) == Math.pow(array[1], 2) + Math.pow(array[2], 2);
    }

/** checks whether the triangle has the same points or the points create a line */
    public void checkDataForTriangle (Triangle triangle) throws WrongDataException{

        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();

        if (a.getX()==b.getX()&&a.getX()==c.getX()||a.getY()==b.getY()&&a.getY()==c.getY()){
            throw new WrongDataException("These points don't create a triangle.");
        }

        if (a.equals(b)||a.equals(c)||b.equals(c)){
            throw new WrongDataException("Some of the points have the same coordinates, they can't create a triangle.");
        }
    }
}
