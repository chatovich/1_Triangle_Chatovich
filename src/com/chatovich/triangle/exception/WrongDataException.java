package com.chatovich.triangle.exception;

/**
 * Created by Yultos_ on 05.10.2016.
 */
public class WrongDataException extends Exception {

    public WrongDataException(String message){
        super(message);
    }

    public WrongDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongDataException(Throwable cause) {
        super(cause);
    }

}
