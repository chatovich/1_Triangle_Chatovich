package com.chatovich.triangle.test;

import com.chatovich.triangle.action.ActionTriangle;
import com.chatovich.triangle.entity.Point;
import com.chatovich.triangle.entity.Triangle;
import com.chatovich.triangle.exception.WrongDataException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import java.io.File;


/**
 * tests methods that calculate triangle parameters
 */
public class ActionTriangleTest {

    static ActionTriangle actionTriangle;
    static Triangle triangle;
    static Point a;
    static Point b;
    static Point c;

    @BeforeClass
    public static void init(){
        actionTriangle = new ActionTriangle();
        a = new Point(0, 0);
        b = new Point(0, 5);
        c = new Point(3, 0);
        triangle = new Triangle(a,b,c);
    }

    @AfterClass
    public static void clear (){
        triangle = null;
        actionTriangle = null;
        a = null;
        b = null;
        c = null;

    }

    @Test
    public void calcLengthTestTrue (){
        double actual = actionTriangle.calcLength(a,b);
        Assert.assertEquals("Test for side length failed", 5.0, actual, 0.1);
    }

    @Test
    public void calcPerimeterTest (){
        double actual = actionTriangle.calcPerimeter(triangle);
        Assert.assertEquals(13.83, actual, 0.1);
    }

    @Test
    public void calcAreaTest (){
        double actual = actionTriangle.calcArea(triangle);
        Assert.assertEquals(7.5, actual, 0.1);
    }

    @Test
    public void isRightAngledTriangleTestTrue (){
        boolean actual = actionTriangle.isRightAngledTriangle(triangle);
        Assert.assertTrue("Test for right-angled triangle failed",actual);
    }

    @Test
    public void checkDataForTriangleTest () {
        b.setY(0);
        try {
            actionTriangle.checkDataForTriangle(triangle);
            Assert.fail("Test for the same X or Y coordinates should have thrown WrongDataException.");
        } catch (WrongDataException e) {
            Assert.assertEquals("These points don't create a triangle.", e.getMessage());
        }
        b.setY(5);
    }

    @Test
    public void checkFile (){
        File file = new File(System.getProperty("user.dir")+"/file/triangle.txt");
        boolean actual = file.exists();
        Assert.assertTrue("File doesn't exist",actual);
    }
}
