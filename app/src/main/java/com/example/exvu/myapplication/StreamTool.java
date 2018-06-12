package com.example.exvu.myapplication;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class StreamTool {
    public  static byte[] read(InputStream inputStream) throws Exception{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buffer))!=-1){
            byteArrayOutputStream.write(buffer,0,length);
        }
        inputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

}
