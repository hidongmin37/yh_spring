
package com.basic.io.file.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class ReadTextFileV3 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다";
        System.out.println("== Write String ==");
        System.out.println(writeString);

        Path path = Path.of(PATH);

        // 파일에 쓰기
        Files.writeString(path, writeString, StandardCharsets.UTF_8);
        // 파일에서 읽기
        Files.readString(path, StandardCharsets.UTF_8);

        System.out.println("== Read String ==");


        /**
         * 한줄씩 가져와서함.*/
        Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
        lines.forEach(System.out::println);
        lines.close();
    }
}
