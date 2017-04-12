package com.hector.learn.generics;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.TypeVariableImpl;

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
	
	public  static <R,D> User<R,D> getUser(Class<User> u){
//		Type t = u.getClass().getGenericSuperclass();
//		Type t2 =  u.getGenericSuperclass();
//		Type[] params = ((ParameterizedType)t).getActualTypeArguments();
		User user = null; 
		try {
			user = u.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
//		Type t = user.getClass().getGenericSuperclass();
//		Type[] params = ((ParameterizedType)t).getActualTypeArguments();
//		
//		System.out.println(params);
//		u.getFields();
		try {
			Field[] fields =  u.getFields();
			TypeVariableImpl typeVariableImpl = (TypeVariableImpl)u.getField("data").getGenericType();
			typeVariableImpl.getTypeName();
			System.out.println(typeVariableImpl.getTypeName());
			System.out.println(typeVariableImpl.getName());
			System.out.println(typeVariableImpl.toString());
			System.out.println(typeVariableImpl.getClass());
//			Type t = u.getField("data").getType();
//			System.out.println(t.getTypeName());  
			
			Class t  = u.getField("data").getType();
			System.out.println(t);
			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}
	
	public static <R,D> User getUsefulUser(Class u,R r,D d){
		Type t = u.getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType)u.getGenericSuperclass();
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		for(Type actualTypeArgument: actualTypeArguments) {
		    System.out.println(actualTypeArgument);
		}
		User user = null;
		try {
			user =(User)u.newInstance();
			user.setData(d);
			user.setResult(r);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public static  User getUsefulUser(User u){
		//Type t = u.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType)u.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		for(Type actualTypeArgument: actualTypeArguments) {
		    System.out.println(actualTypeArgument);
		}
		Field[] fields = u.getClass().getFields();
		System.out.println(u.getData().getClass());
		
		
		//User user = null;
//		try {
//			user =(User)u.newInstance();
//			user.setData(d);
//			user.setResult(r);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return u;
	}
	
	public static void main(String[] args) {
		//User<Integer,String> u = GenericsSimpleModel.getUser(User.class);
		User<Integer,String> user = new UsefulUser<Integer,String>();
		
//		User<Integer,String> user = GenericsSimpleModel.getUsefulUser(UsefulUser.class,1,"hello");
//		System.out.println(user.getData());
//		System.out.println(user.getResult());
		
		GenericsSimpleModel.getUsefulUser(user);
		
	}
}
