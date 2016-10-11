package com.chatovich.triangle.action;

import com.chatovich.triangle.creator.TriangleCreator;
import com.chatovich.triangle.entity.Triangle;
import com.chatovich.triangle.exception.WrongDataException;
import com.chatovich.triangle.runner.TriangleRunner;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yultos_ on 08.10.2016
 */
public class ReadData {

    static final Logger LOGGER = LogManager.getLogger(ReadData.class);

    public static List<String> TxtFile(String fileName) {

        String line;
        List<String> list = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        }catch(FileNotFoundException e){
            LOGGER.fatal("File error", e);
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "IOException",e);
        }
        return list;
    }
}
