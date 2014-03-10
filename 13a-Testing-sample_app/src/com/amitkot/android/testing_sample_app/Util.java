package com.amitkot.android.testing_sample_app;

public class Util {

	private void Util() {
	}

	public static String repeatText(String text, int repeat) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < repeat; i++) {
			sb.append(text);
		}
		return sb.toString();
	}

}