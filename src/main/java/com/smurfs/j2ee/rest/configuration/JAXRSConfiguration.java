/*
 * Copyright(c)2016 by AXON IVY AG, CH-6000 Lucerne. http://www.axonivy.com
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * AXON IVY AG. You shall not disclose such confidential information and
 * shall use it only in accordance with the terms of the license
 * agreement you entered into with AXON IVY AG.
 */
package com.smurfs.j2ee.rest.configuration;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.models.auth.ApiKeyAuthDefinition;
import io.swagger.models.auth.In;

@ApplicationPath("api")
public class JAXRSConfiguration extends Application {
	
	public JAXRSConfiguration() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.getSwagger().addSecurityDefinition("api_key", new ApiKeyAuthDefinition("api_key", In.HEADER));
		beanConfig.setVersion("0.0.0.1");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setBasePath("java_rest/api");
		beanConfig.setResourcePackage("com.smurfs.j2ee.rest.api");
		beanConfig.setScan(true);
	}
}	
