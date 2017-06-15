package com.hector.learn.reflect;

public class MyImplemet implements MyInterface {
	private String name;
	private String content;
	
	
	public MyImplemet(String name, String content) {
		this.name = name;
		this.content = content;
	}

	@Override
	public void printName(String name) {
		System.out.println("my name = " + this.name);
	}

	@Override
	public void printSay(String content) {
		System.out.println("say content = " + this.content);
	}

}
