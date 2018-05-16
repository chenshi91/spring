package com.quanhu.base;

import java.util.ArrayList;

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
		ArrayList<Object> list = new ArrayList<>();
		for (Object o : list) {
			System.out.println(o.toString());
		}
		System.out.println("hello");
	}
}
