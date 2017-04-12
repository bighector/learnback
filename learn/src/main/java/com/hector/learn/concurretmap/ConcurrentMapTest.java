package com.hector.learn.concurretmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapTest {

	public static void main(String[] args) {
		Map<String,String> m = new ConcurrentHashMap<String,String>();
		
		String returnValue = m.putIfAbsent("name", "hello");
		System.out.println(returnValue);
		System.out.println(m.get("name"));
		
		String returnValue1 = m.putIfAbsent("name", "hello1");
		System.out.println(returnValue1);
		System.out.println(m.get("name"));
		
		String returnValue2 = m.put("name", "hello2");
		System.out.println(returnValue2);
		System.out.println(m.get("name"));
		
		String returnValue3 = m.put("name", "hello3");
		System.out.println(returnValue3);
		System.out.println(m.get("name"));
		
	}

}
