package com.chatovich.triangle.creator;

import com.chatovich.triangle.action.ActionTriangle;
import com.chatovich.triangle.entity.Point;
import com.chatovich.triangle.entity.Triangle;
import com.chatovich.triangle.exception.WrongDataException;
import com.chatovich.triangle.runner.TriangleRunner;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Creates a triangle using String line
 */
public class TriangleCreator {

    static final Logger LOGGER = LogManager.getLogger(TriangleRunner.class);

    public void createTriangle (List<String> triangleList) {

        for (String line : triangleList) {
            try {
                if (line.isEmpty()){
                    LOGGER.log(Level.ERROR, "At line ("+line+") impossible to build a triangle, the line is empty");
                    continue;
                }
                String[] points = TriangleParser.lineParser(line);
                if (points.length != 3) {
                    LOGGER.log(Level.ERROR, "At line ("+line+"): for building a triangle we need 3 points, not "+ points.length);
                    continue;
                }
                Triangle triangle = new Triangle();
                triangle.setA(TriangleParser.coordinatesParser(points[0],line));
                triangle.setB(TriangleParser.coordinatesParser(points[1], line));
                triangle.setC(TriangleParser.coordinatesParser(points[2], line));

                ActionTriangle actionTriangle = new ActionTriangle();
                //checks whether the triangle doesnt't have the same points or the points don't create a line
                actionTriangle.checkDataForTriangle(triangle);
                double perimeter = actionTriangle.calcPerimeter(triangle);
                double area = actionTriangle.calcArea(triangle);
                LOGGER.log(Level.INFO, triangle+" was created, perimeter = "+String.format("%.2f",perimeter) +
                        ", area = " + String.format("%.2f",area));

            } catch (WrongDataException e) {
                LOGGER.log(Level.ERROR, "At line ("+line+") ",e);
            }
        }
    }

}
