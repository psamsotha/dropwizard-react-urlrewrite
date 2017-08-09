package com.example;


import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("example")
public class ExampleResource {

    @GET
    public String get() {
        return "Hello World!";
    }
}

