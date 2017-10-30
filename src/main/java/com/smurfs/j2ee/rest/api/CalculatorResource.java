package com.smurfs.j2ee.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/calculators")
@Produces(MediaType.APPLICATION_JSON)
public class CalculatorResource {

	@GET
	public Response getOperator(){
		return Response.ok().entity("Hello").build();
	}
	
	@PUT
	public Response addNew(@QueryParam("pathParam") String param){
		return Response.ok().entity("Hello " + param).build();
	}
	
}
