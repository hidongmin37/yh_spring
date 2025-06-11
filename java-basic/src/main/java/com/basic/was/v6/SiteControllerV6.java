package com.basic.was.v6;

import com.basic.was.httpServer.HttpRequest;
import com.basic.was.httpServer.HttpResponse;

public class SiteControllerV6 {

    public void site1(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>Site 1</h1>");
    }

    public void site2(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>Site 2</h1>");
    }


}
