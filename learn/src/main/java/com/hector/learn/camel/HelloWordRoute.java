package com.hector.learn.camel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http.HttpMessage;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.ModelCamelContext;

public class HelloWordRoute extends RouteBuilder {
	
	public static void main(String[] args) throws Exception {
		ModelCamelContext  camelContext = new DefaultCamelContext();
		camelContext.start();
		camelContext.addRoutes(new HelloWordRoute());
		camelContext.addRoutes(new HttpRoute());
		
		synchronized (HelloWordRoute.class) {
			HelloWordRoute.class.wait();
		}
	}
	
	@Override
	public void configure() throws Exception {
		//from("jetty:http://0.0.0.0:8282").to("direct:start");//http://127.0.0.1:8080?bridgeEndpoint=true
		System.out.println("configure1");
		System.out.println("configure2");
		from("jetty:http://0.0.0.0:8282").process(new HttpProcessor()).to("http://127.0.0.1:9999/strategyTransaction/test?bridgeEndpoint=true");//http://127.0.0.1:9999/strategyTransaction/test?bridgeEndpoint=true
//        .process(new HttpProcessor())
//        .to("log:helloworld?showExchangeId=true");
		System.out.println("configure end ");
	}

	private class HttpProcessor implements Processor{

		@Override
		public void process(Exchange exchange) throws Exception {
			HttpMessage message = (HttpMessage)exchange.getIn();
            InputStream bodyStream =  (InputStream)message.getBody();
            String inputContext = this.analysisMessage(bodyStream);
            bodyStream.close();

            // 存入到exchange的out区域
            if(exchange.getPattern() == ExchangePattern.InOut) {
                Message outMessage = exchange.getOut();
                outMessage.setBody(inputContext);
            }
			
		}
		
		
		private String analysisMessage(InputStream bodyStream) throws IOException {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] contextBytes = new byte[4096];
            int realLen;
            while((realLen = bodyStream.read(contextBytes , 0 ,4096)) != -1) {
                outStream.write(contextBytes, 0, realLen);
            }

            // 返回从Stream中读取的字串
            try {
                return new String(outStream.toByteArray() , "UTF-8");
            } finally {
                outStream.close();
            }
        }
	}
	
	private class MyProcessor implements Processor{

		@Override
		public void process(Exchange exchange) throws Exception {
			exchange.getIn().setHeader(Exchange.HTTP_URI, "http://127.0.0.1:8080");
		}
		
	}
	
	
}
