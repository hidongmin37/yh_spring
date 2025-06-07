package com.basic.was.v3;

import java.net.URLDecoder;
import java.net.URLEncoder;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PercentEncoding {
    public static void main(String[] args) {
        String encoder = URLEncoder.encode("갸",UTF_8);
        System.out.println(encoder);

        String decoder = URLDecoder.decode(encoder, UTF_8);
        System.out.println(decoder);
    }
}
