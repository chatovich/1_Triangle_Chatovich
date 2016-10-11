package com.chatovich.triangle.creator;

import com.chatovich.triangle.entity.Point;
import com.chatovich.triangle.exception.WrongDataException;
import com.chatovich.triangle.runner.TriangleRunner;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Parses String data
 */
public class TriangleParser {

    final static String LINE_TO_POINTS_REGEX = "\\s?[;]\\s?";
    final static String POINT_TO_COORDINATES_REGEX = "\\s?[,]\\s?";
    static final Logger LOGGER = LogManager.getLogger(TriangleRunner.class);

    public static String [] lineParser (String line)  {

        return line.trim().split(LINE_TO_POINTS_REGEX);
    }

    /** checks whether the triangle is right-angled
     * @param s coordinates to parse
     * @param line the whole line for creating a triangle
     * @return a point with 2 coordinates */
    public static Point coordinatesParser (String s, String line) throws WrongDataException {

        String [] coordinates = s.trim().split(POINT_TO_COORDINATES_REGEX);
        List <String> coorList = new ArrayList<>();

        for (int i = 0; i < coordinates.length; i++) {
            if (!coordinates[i].isEmpty()){
                coorList.add(coordinates[i]);
            }
        }

        if (coorList.size()!=2){
            throw new WrongDataException("We need 2 coordinates to build a triangle, not " + coordinates.length);
        }

        int x = 0;
        int y = 0;
        try {
            x = Integer.parseInt(coorList.get(0));
            y = Integer.parseInt(coorList.get(1));
        } catch (NumberFormatException e) {
            LOGGER.log(Level.ERROR, "At line (" + line + ") ", e);
        }

        return new Point(x,y);
    }
}
