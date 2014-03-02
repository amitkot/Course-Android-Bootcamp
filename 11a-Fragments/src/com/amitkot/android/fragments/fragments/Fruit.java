package com.amitkot.android.fragments.fragments;

public class Fruit {

	public String name;
	public int image;

	public Fruit(String nameStr, int imageRes) {
		name = nameStr;
		image = imageRes;
	}

	public String toString() {
		return name;
	};
}
