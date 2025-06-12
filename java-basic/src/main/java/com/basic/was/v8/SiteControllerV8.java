package com.basic.was.v8;

import com.basic.was.httpServer.HttpResponse;
import com.basic.was.httpServer.servlet.annotaion.Mapping;

public class SiteControllerV8 {

   @Mapping("/")
    public void home(HttpResponse response) {
       response.writeBody("\r\n");
       response.writeBody("<h1>Home Page</h1>");
       response.writeBody("<ul>");
       response.writeBody("<li><a href=\"/site1\">Site 1</a></li>");
       response.writeBody("<li><a href=\"/site2\">Site 2</a></li>");
       response.writeBody("<li><a href=\"/search?q=장동민\">Search</a></li>");
       response.writeBody("</ul>");
    }

    @Mapping("/site1")
    public void site1(HttpResponse response) {
        response.writeBody("<h1>Site 1</h1>");
    }

    @Mapping("/site2")
    public void site2(HttpResponse response) {
        response.writeBody("<h1>Site 2</h1>");
    }

//    @Mapping("/site2")
//    public void s2(HttpResponse response) {
//        response.writeBody("<h1>Site 2</h1>");
//    }

}
