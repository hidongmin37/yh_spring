package com.basic.was.v7;

import com.basic.was.httpServer.HttpRequest;
import com.basic.was.httpServer.HttpResponse;
import com.basic.was.httpServer.servlet.annotaion.Mapping;

public class SearchControllerV7 {

    @Mapping("/search")
    public void search(HttpRequest request, HttpResponse response) {
        String query = request.getParameter("q");
        if (query == null || query.isEmpty()) {
            response.writeBody("<h1>검색어가 없습니다.</h1>");
        } else {
            response.writeBody("<h1>검색 결과</h1>");
            response.writeBody("<p>검색어: " + query + "</p>");
            // 여기에 검색 결과를 추가로 처리할 수 있습니다.
        }
    }

}
