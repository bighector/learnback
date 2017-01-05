package com.hector.learn.generics;

public class GenericsInterfaceModel<T extends GenericsInterfaces > {
	private T t;

	public GenericsInterfaceModel(T t) {
		this.t = t;
	}
	
	public void functionTofF(){
		t.f();
	}
	
}
