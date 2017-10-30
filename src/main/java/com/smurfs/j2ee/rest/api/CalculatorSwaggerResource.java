package com.smurfs.j2ee.rest.api;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.smurfs.j2ee.rest.model.Operator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@Path("swaggers/calculators")
@SwaggerDefinition(info = @Info(description = "This API will be used in Technical Dinner.", version = "V1.0.0", 
							title = " REST API", termsOfService = "private"), 
schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS })
@Api(value = "/calculators", tags = "calculators")
public class CalculatorSwaggerResource {

	@GET
	@Path("/text")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@ApiOperation(value = "Returns list of Operators", 
		notes = "Returns a list of Operators.")
	@ApiResponses(value = {
	        @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "ERROR"),
	        @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK")})
	public Response getOperator(@ApiParam(value = "Accept") @HeaderParam("Accept") String accept){
		return Response.ok().entity("Sum, Substract, Devide, Multiply").type(accept).build();
	}
	
	@GET
	@Path("/object")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@ApiOperation(value = "Returns operator object")
	@ApiResponses(value = {
	        @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "ERROR"),
	        @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK", response=Operator.class)})
	public Response getOperatorObject(@ApiParam(value = "Accept") @HeaderParam("Accept") String accept){
		Operator operator = new Operator(1L, "Sum");
		return Response.ok().entity(operator).type(accept).build();
	}
	
	
	@GET
	@Path("/text/{pathParam}")
	@ApiOperation(value = "Returns list of Operators by path param", 
		notes = "Returns a list of Operators.")
	@ApiImplicitParams(value = {
	        @ApiImplicitParam(name = "param", value ="name of Operator to find",
	        		dataType = "string", paramType = "query")
	})
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Can not find this operator."),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Format is not correct.") })
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response getOperatorByPathParam(
			@ApiParam(value = "pathParam") @PathParam("pathParam") String param,
			@ApiParam(value = "Accept") @HeaderParam("Accept") String accept){
		return Response.ok().entity("Operator " + param).build();
	}
	
	@PUT
	@Path("/text")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response addNew(@ApiParam(value = "pathParam") @QueryParam("pathParam") String param){
		return Response.ok().entity("Operator " + param).build();
	}
	
	@PUT
	@Path("/objects")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response addNew(
			@ApiParam(value = "operatpr", required = true) Operator param){
		return Response.ok().entity(param).build();
	}
	
}
