package com.radiantblue.todoapp;

import static spark.Spark.*;

import java.util.ArrayList;

public class HelloSpark {

    public static ArrayList<String> things = new ArrayList<String>();

    public static void main(String[] args) {
    	
//        get("/", new Route() {
//            @Override
//            public Object handle(Request request, Response response) {
//                return "Hello World!!";
//            }
//        });
        
		get("/", (request, response) -> "Hello World");
    	
//        get("/list", new Route() {
//        	@Override
//        	public Object handle(Request request, Response response) {
//        		StringBuilder html = new StringBuilder();
//        		
//        		if (HelloSpark.things.isEmpty()) {
//        			html.append("<b>Try adding some things to your list</b>");
//        		} else {
//        			html.append("<ul>");
//        			for (String thing : HelloSpark.things) {
//                        html.append("<li>").append(thing).append("</p>");
//                    }
//                    html.append("</ul>");
//        		}
//        		
//        		return html.toString();
//        	}
//        });
        
        get("/list", (request, response) -> {
    		StringBuilder html = new StringBuilder();
    		
    		if (HelloSpark.things.isEmpty()) {
    			html.append("<b>Try adding some things to your list</b>");
    		} else {
    			html.append("<ul>");
    			for (String thing : HelloSpark.things) {
                    html.append("<li>").append(thing).append("</p>");
                }
                html.append("</ul>");
    		}
    		
    		return html.toString();
        });

        
//        post("/add/:item", new Route() {
//            @Override
//            public Object handle(Request request, Response response) {
//                HelloSpark.things.add(request.params(":item"));
//                response.status(200);
//                return response;
//            }
//        });
        
        post("/add/:item", (request, response) -> {
            HelloSpark.things.add(request.params(":item"));
            response.status(200);
            return response;
        });
    }
}