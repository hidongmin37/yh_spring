package com.basic.java.charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

public class EncodingMain2 {
    private static final Charset EUC_KR = Charset.forName("EUC_KR");
    private static final Charset MS_949 = Charset.forName("MS_949");
    public static void main(String[] args) {
        System.out.println("== ASCII 영문 처리 ==");
        test("A", StandardCharsets.US_ASCII, StandardCharsets.US_ASCII);
        test("A", StandardCharsets.US_ASCII, StandardCharsets.ISO_8859_1);
        test("A", StandardCharsets.US_ASCII, UTF_8);
        test("A", StandardCharsets.US_ASCII, StandardCharsets.UTF_16BE);
        test("A", StandardCharsets.US_ASCII, MS_949);
        test("A", StandardCharsets.US_ASCII, EUC_KR);
        System.out.println("== 한글 처리 ==");
        test("가", StandardCharsets.US_ASCII, StandardCharsets.US_ASCII);
        test("가", StandardCharsets.ISO_8859_1, StandardCharsets.ISO_8859_1);
        test("가", EUC_KR, EUC_KR);
        test("가", MS_949, MS_949);
        test("가", UTF_8, UTF_8);
        test("가", StandardCharsets.UTF_16BE, StandardCharsets.UTF_16BE);
        System.out.println("== 한글 처리2 ==");
        test("뷁", StandardCharsets.US_ASCII, StandardCharsets.US_ASCII);
        test("뷁", StandardCharsets.ISO_8859_1, StandardCharsets.ISO_8859_1);
        test("뷁", EUC_KR, EUC_KR);
        test("뷁", MS_949, MS_949);
        test("뷁", UTF_8, UTF_8);
        test("뷁", StandardCharsets.UTF_16BE, StandardCharsets.UTF_16BE);
        System.out.println("== 한글 처리3 ==");
        test("쮒", StandardCharsets.US_ASCII, StandardCharsets.US_ASCII);
        test("쮒", StandardCharsets.ISO_8859_1, StandardCharsets.ISO_8859_1);
        test("쮒", EUC_KR, EUC_KR);
        test("쮒", MS_949, MS_949);
        test("쮒", UTF_8, UTF_8);
        test("쮒", StandardCharsets.UTF_16BE, StandardCharsets.UTF_16BE);
        System.out.println("== 한글 인코딩 - 디코딩이 다른 경우 ==");
        test("가", EUC_KR, MS_949);
        test("가", EUC_KR, UTF_8);
        test("뷁", EUC_KR, MS_949);
        test("뷁", MS_949, EUC_KR);
        System.out.println("== 영문 인코딩  ==");
        test("A", EUC_KR, MS_949);
        test("A", EUC_KR, UTF_8);
        test("A", UTF_8, EUC_KR);
        test("A", UTF_8, MS_949);
        test("A", UTF_8, StandardCharsets.UTF_16BE);
    }

    private static void test(String text, Charset encodingCharset, Charset decodingCharset) {
        byte[] encoded = text.getBytes(encodingCharset);
        String decoded = new String(encoded, decodingCharset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %s byte -> [%s] 디코딩 -> %s \n",
                text,encodingCharset,Arrays.toString(encoded),encoded.length,decodingCharset,decoded);
    }
}
