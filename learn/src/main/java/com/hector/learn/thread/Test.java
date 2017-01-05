package com.hector.learn.thread;

public final class Test {

	public static void main(String[] args) {
		System.out.println("my first start !");
		
		new Test().getDispaly();
		new Test.Inclass();
		
	}

	public  void getDispaly(){
		Inclass inClass = new Inclass();
		inClass.getInclass();
		inClass.doInWork();
		
	}
	
	
	private static class Inclass{
		private Inclass(){
			
		}
		
		private Inclass getInclass(){
			return new Inclass();
		}
		private void doInWork(){
			System.out.println("in class do working!");
		}
	}
}
