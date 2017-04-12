package com.hector.learn.camel;

import org.apache.camel.builder.RouteBuilder;

public class HttpRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		//from("direct:start").to("http://127.0.0.1:8080");
		//from("direct:start").to("http://127.0.0.1:9999/strategyTransaction/test?bridgeEndpoint=true");
		from("direct:start").to("http://127.0.0.1:8080?bridgeEndpoint=true");
	}

}
