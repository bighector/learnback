package com.hector.learn.reflect;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		MyImplemet t = new MyImplemet("haoren","fuck !");
		
		MyHandler h = new MyHandler(t);
		
		MyInterface m = (MyInterface)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{MyInterface.class}, h);
		m.printName("hehe");
		m.printSay("dsd");
	}

}
