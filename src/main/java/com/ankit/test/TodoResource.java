package com.ankit.test;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/todo")
public class TodoResource {

    // This method is called if XML is requested
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Todo getXML() {
        Todo todo = new Todo();
        todo.setSummary("Application XML Todo Summary");
        todo.setDescription("Application XML Todo Description");
        return todo;
    }

    // This method is called if JSON is requested
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Todo getJSON() {
        Todo todo = new Todo();
        todo.setSummary("Application JSON Todo Summary");
        todo.setDescription("Application JSON Todo Description");
        return todo;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Todo getJSONPost(@FormParam("name") String name) {
    	Todo todo = new Todo();
    	if(name == null) {
    		todo.setSummary("Please enter your name !");
    	} else {
			todo.setSummary("Hello " + name + " !");
		    todo.setDescription("How you doing ?");
    	}
    	return todo;
    }
    

    // This can be used to test the integration with the browser
    @GET
    @Produces({ MediaType.TEXT_XML })
    public Todo getHTML() {
        Todo todo = new Todo();
        todo.setSummary("XML Todo Summary");
        todo.setDescription("XML Todo Description");
        return todo;
    }

}