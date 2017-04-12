package com.hector.learn.exception;

public class MyPipe implements Pipe {

	@Override
	public void process() {
//		try{
//			doWork();
//		}catch(InterruptedException e){
//			
//		}
		
		try {
			doWork();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.getMessage();
			System.out.println("Exception");
			e.printStackTrace();
		}catch(Throwable t){
			//t.printStackTrace(s);
			System.out.println("Throwable");
			t.printStackTrace();
		}
	}

	public void doWork() throws InterruptedException,Exception,Throwable{
		System.out.println("hello");
		//throw new Exception("heello");
		throw new Throwable("heello");
	}
	
	public static void main(String[] args) {
		MyPipe MyPipe = new MyPipe();
		MyPipe.process();
		
	}
}
