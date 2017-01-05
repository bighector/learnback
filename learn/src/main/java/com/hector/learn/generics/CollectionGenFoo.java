package com.hector.learn.generics;

import java.util.Collection;

public class CollectionGenFoo<T extends Collection> {
	private T t;

	public CollectionGenFoo(T t) {
		this.t = t;
	}
	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	
}
