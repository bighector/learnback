package com.hector.learn.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsTest {

	public static void main(String[] args) {
		//testGenericsSimpleModel();
		//testCustomTpyeGenericsSimpleModel();
		testCollectionGenFoo();
		
		
	}
	
	
	public static void testGenericsSimpleModel(){
		GenericsSimpleModel<Integer> genericsSimpleModel = new GenericsSimpleModel<Integer>(222);
		genericsSimpleModel.printType();
	}
	
	public static void testCustomTpyeGenericsSimpleModel(){
		MyType myType = new MyType();
		myType.setName("test1");
		myType.setType("String");
		GenericsSimpleModel<MyType> genericsSimpleModel = new GenericsSimpleModel<MyType>(myType);
		genericsSimpleModel.printType();
	}
	
	
	public static void testCollectionGenFoo(){
		List arryList = new ArrayList();
		CollectionGenFoo collectionGenFoo = new CollectionGenFoo<List>(arryList);
		
		Collection collection= collectionGenFoo.getT();
		
		collection.add("abc");
		collection.add(231);
	}
}
