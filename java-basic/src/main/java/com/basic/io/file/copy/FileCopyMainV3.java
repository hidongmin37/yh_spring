package com.basic.io.file.copy;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Slf4j
public class FileCopyMainV3 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        // 자바가 copy하는 게아니라
        // 운영체제에서 copy
        Path source = Path.of("temp/copy.dat");
        Path target = Path.of("temp/copay_new.dat");
        Files.copy(source,target    );

        long end = System.currentTimeMillis();

        System.out.println("Time taken :" + (end - start) + "ms");
    }
}
