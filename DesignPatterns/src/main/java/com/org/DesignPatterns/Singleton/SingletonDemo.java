package com.org.DesignPatterns.Singleton;

public class SingletonDemo {
//	Eager Loading
//	private final static SingletonDemo singleton = new SingletonDemo();

	private SingletonDemo() {
	}
	
//	Lazy loading
	private static class Helper{
		private final static SingletonDemo singleton = new SingletonDemo();
	}
	
	public static SingletonDemo getInstance() {
		return Helper.singleton; 
	}
}
