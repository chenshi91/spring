package com.quanhu.base;

/**
 * Hello world!
 *
 */
public class App {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "App [" + (name != null ? "name=" + name : "") + "]";
	}

	private String name;

	/**
	 * 
	 */
	public App() {
		super();
	}

	/**
	 * @param name
	 */
	public App(String name) {
		super();
		this.name = name;
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
