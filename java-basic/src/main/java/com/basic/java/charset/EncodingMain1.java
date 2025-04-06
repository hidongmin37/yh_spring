package com.basic.java.charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EncodingMain1 {
    private static final Charset EUC_KR = Charset.forName("EUC_KR");
    private static final Charset MS_949 = Charset.forName("MS_949");
    public static void main(String[] args) {
        System.out.println("== ASCII 영문 처리 ==");
        encoding("A", StandardCharsets.US_ASCII);
        encoding("A", StandardCharsets.ISO_8859_1);
        encoding("A", StandardCharsets.UTF_8);
        encoding("A", StandardCharsets.UTF_16BE);
        encoding("A", EUC_KR);
        System.out.println("== 한글 처리 ==");
        encoding("가", EUC_KR);
        encoding("가", MS_949);
        encoding("가", StandardCharsets.US_ASCII);
        encoding("가", StandardCharsets.ISO_8859_1);
        encoding("가", StandardCharsets.UTF_8);
        encoding("가", StandardCharsets.UTF_16BE);

        String str = "A";
        byte[] bytes = str.getBytes();
        System.out.println("bytes = " + Arrays.toString(bytes));
    }

    private static void encoding(String text, Charset charset) {
        byte[] bytes = text.getBytes(charset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n",text,charset, Arrays.toString(bytes),bytes.length);
    }
}
