package com.basic.was.httpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String method;
    private String path;
    private final Map<String, String> queryParameters = new HashMap<>();
    private final Map<String, String> headers = new HashMap<>();

    public HttpRequest(BufferedReader reader) throws IOException {
        parseRequestLine(reader);
        parserHeaders(reader);
        parseBody(reader);
        // 메시지 바디는 이후에 처리

    }

    // GET /search?q=hello HTTP/1.1
    // Host localhost:12345
    private void parseRequestLine(BufferedReader reader) throws IOException {
        String requestLine = reader.readLine();
        if (requestLine == null) {
            throw new IOException("EOF: No request line received");
        }

        String[] parts = requestLine.split(" ");
        if (parts.length != 3) {
            throw new IOException("Invalid request line: " + requestLine);
        }

        this.method = parts[0];
        String[] pathParts = parts[1].split("\\?");
        this.path = pathParts[0];
        if (pathParts.length > 1) {
            parseQueryParameters(pathParts[1]);
        }
    }

    private void parseQueryParameters(String queryString) {
        for (String param : queryString.split("&")) {
            String[] keyValue = param.split("=");
            String key = URLDecoder.decode(keyValue[0], StandardCharsets.UTF_8);
            String value = keyValue.length > 1 ? URLDecoder.decode(keyValue[1], StandardCharsets.UTF_8) : "";
            queryParameters.put(key, value);
        }
    }

    /**
     * Host: localhost:1234
     * Connection: keep-alive
     * Cache-Control: max-age =0*/
    private void parserHeaders(BufferedReader reader) throws IOException {
        String line;
        while (!(line = reader.readLine()).isEmpty()) {
            String[] headerParts = line.split(":");
            // trim() 앞 뒤 공백 제거
            headers.put(headerParts[0].trim(), headerParts[1].trim());
        }
    }

    private void parseBody(BufferedReader reader) throws IOException {
        if (!headers.containsKey("Content-Length")) {
            return; // 메시지 바디가 없으면 리턴
        }
        Integer contentLength = Integer.parseInt(headers.get("Content-Length"));
        char[] chars = new char[contentLength];// 메시지 바디를 읽기 위한 버퍼 생성
        int readChars = reader.read(chars);
        if (readChars != contentLength) {
            throw new IOException("Content-Length mismatch: expected " + contentLength + ", but read " + readChars);
        }
        String body = new String(chars);

        String contentType = headers.get("Content-Type");
        if ("application/x-www-form-urlencoded".equals(contentType)) {
            parseQueryParameters(body);
        } else if ("application/json".equals(contentType)) {
            // 예: JSON.parseObject(body, YourClass.class);
        } else {
            // 다른 컨텐츠 타입 처리 로직 추가 가능
        }

    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getParameter(String name) {
        return queryParameters.get(name);
    }
    public String getHeader(String name) {
        return headers.get(name);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", queryParameters=" + queryParameters +
                ", headers=" + headers +
                '}';
    }
}
