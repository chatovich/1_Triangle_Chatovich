package com.chatovich.triangle.runner;

import com.chatovich.triangle.action.ReadData;
import com.chatovich.triangle.creator.TriangleCreator;

import java.util.List;

/**
 * Class with main method
 */
public class TriangleRunner {

    final static String FILE_NAME = System.getProperty("user.dir")+"/file/triangle.txt";

    public static void main(String[] args) {

        List<String> triangleList = ReadData.TxtFile(FILE_NAME);
        TriangleCreator triangleCreator = new TriangleCreator();
        triangleCreator.createTriangle(triangleList);

    }
}
