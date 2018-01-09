package com.mvc.common.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class ConvertUtils {

    public static String convertFileToStrBase64(String src) throws IOException{
        File file = new File(src);
        if (!file.exists()) {
            return "";
        } else {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int b;
            byte[] buffer = new byte[1024];
            while ((b = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, b);
            }
            byte[] fileBytes = bos.toByteArray();
            fis.close();
            bos.close();
            return Base64.getEncoder().encodeToString(fileBytes);
        }
    }
}
