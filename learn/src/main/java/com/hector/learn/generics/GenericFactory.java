package com.hector.learn.generics;

public class GenericFactory <T>{
	public T getInstance(Class<T> generiClazz){
		T fruit = null;
		try {
			fruit = generiClazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return fruit;
	}
}
