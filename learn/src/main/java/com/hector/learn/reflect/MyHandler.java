package com.hector.learn.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
	private MyInterface o;
	
	
	
	public MyHandler(MyInterface o) {
		this.o = o;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("a log..");
		method.invoke(o, args);
		return "ok";
	}

}
