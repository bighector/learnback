package com.hector.learn.generics;

public class GenericsSimpleModel<T> {
	private T type;
	
	public GenericsSimpleModel(T type){
		this.type = type;
	}
	
	public void printType(){
		if(type instanceof String){
			System.out.println("T is String");
		}
		if(type instanceof MyType){
			System.out.println("T is MyType");
		}
		System.out.println(type.toString());
	}
	
	public <B,C> void  print(String name ,B b,C c){
		System.out.println(name);
		
		// B c =  new B();
		//T t = new T();
		 
	}
}
