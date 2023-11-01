package com.teamPhoenix.votopia.exceptions;

public class CanNotConvertImageToBase64Exception extends IllegalStateException{
    public CanNotConvertImageToBase64Exception() {
        super("Can not convert image to base64 string.");
    }
}
