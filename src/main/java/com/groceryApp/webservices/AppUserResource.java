package com.groceryApp.webservices;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.groceryApp.dao.AppUserDao;
import com.groceryApp.entity.AppUser;



@Path("/AppUser")
public class AppUserResource implements ContainerResponseFilter{
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addAppUser(AppUser user) {
		System.out.println(user.getDob()+"***************************************");
	return	new AppUserDao().signUp(user)?"success":"failed";
	}
	
	 @GET
	    @Produces(MediaType.TEXT_PLAIN)
	    public String getIt() {
	        return "Got it!";
	    }
	 
	@Override
	public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
		MultivaluedMap<String, Object> headers = response.getHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");			
		headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");
		
	}
}
