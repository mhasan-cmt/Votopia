package com.teamPhoenix.votopia.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;
@Slf4j
public class ImageUtil {
    public static byte[] multipartToBytearray(MultipartFile multipartFile) throws IOException {
        return multipartFile.getBytes();
    }
    public static String multipartToBase64(byte[] multipartFile) {
        try{
            return Base64.getEncoder().encodeToString(multipartFile);
        }
        catch (Exception e){
            log.error("Can not convert image to base64");
            return null;
        }
    }
}
