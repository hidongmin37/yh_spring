package com.basic.java.charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.SortedMap;

public class AvailableCharsetsMain {
    public static void main(String[] args) {
        // 이용 가능한 모든 Charset 자바 + OS
        System.out.println("-------------------------------");
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for (String charsetName : charsets.keySet()) {
            System.out.println("charsetName = " + charsetName);
        }
        System.out.println("-------------------------------");
        // 문자로 조회(대소문자 구문X),
        Charset ms949 = Charset.forName("MS949");
        System.out.println("ms949 = " + ms949);
        System.out.println("-------------------------------");
        // 별칭 조회
        Set<String> aliases = ms949.aliases();
        for (String alias : aliases) {
            System.out.println("alias = " + alias);
        }
        System.out.println("-------------------------------");
        // UTF-8 문자로 조회
        Charset charset = Charset.forName("UTF-8");
        System.out.println("charset = " + charset);
        System.out.println("-------------------------------");
        Charset charset2 = StandardCharsets.UTF_8;
        System.out.println("charset2 = " + charset2);
        System.out.println("-------------------------------");
        Charset defaultCharset = Charset.defaultCharset();
        System.out.println("defaultCharset = " + defaultCharset);
        System.out.println("-------------------------------");
    }
}
