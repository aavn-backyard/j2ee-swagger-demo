package com.smurfs.j2ee.rest.configuration;

import java.io.IOException;

import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;


@Provider
@RequestScoped
@Priority(Priorities.AUTHORIZATION)
public class AuthenticationResourceFilter implements ContainerRequestFilter {
	
	public static final String AUTHENTICATION_HEADER = "Authorization";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String authCredentials = requestContext.getHeaderString(AUTHENTICATION_HEADER);
		requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		AuthenticationService authenticationService = new AuthenticationService();

		boolean authenticationStatus = authenticationService
				.authenticate(authCredentials);
		
		if (!authenticationStatus) {
			ErrorMessage msg = new ErrorMessage("403", "Not allowed");
			requestContext.abortWith(Response.status(Status.FORBIDDEN).entity(msg).build());
		}
		
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String authCredentials = httpServletRequest
					.getHeader(AUTHENTICATION_HEADER);

			// better injected
			AuthenticationService authenticationService = new AuthenticationService();

			boolean authenticationStatus = authenticationService
					.authenticate(authCredentials);

			if (authenticationStatus) {
				filter.doFilter(request, response);
			} else {
				if (response instanceof HttpServletResponse) {
					HttpServletResponse httpServletResponse = (HttpServletResponse) response;
					httpServletResponse
							.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}
		}
	}

}
