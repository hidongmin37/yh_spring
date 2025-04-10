package com.basic.io.start;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayStreamMain2 {
    public static void main(String[] args) throws IOException {
        byte[] bytes = {1,2,3};

        // 메모리에 쓰기
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(bytes);

        // 메모리에서 읽기
        ByteArrayInputStream bias = new ByteArrayInputStream(baos.toByteArray());
        byte[] bytes1 =  bias.readAllBytes();
        System.out.println(Arrays.toString(bytes1));


    }
}
