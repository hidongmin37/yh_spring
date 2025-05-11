package com.basic.io.file;

import java.io.File;
import java.io.IOException;

public class OldFilePath {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/..");
        System.out.println("path = " + file.getParent());

        // 절대 경로(여러 표현이 있다.)
        System.out.println("Absolute path = " + file.getAbsolutePath());

        // 정규 경로(하나만 가능하다)
        System.out.println("Canonical path = "+ file.getCanonicalPath());

        File[] fileList = file.listFiles();
        for (File fileOne : fileList) {
            System.out.println((fileOne.isFile() ? "F" : "D") + " | " + fileOne.getName());
        }
    }
}
