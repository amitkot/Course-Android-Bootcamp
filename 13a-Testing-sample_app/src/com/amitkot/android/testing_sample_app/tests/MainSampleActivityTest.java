package com.amitkot.android.testing_sample_app.tests;

import junit.framework.TestCase;

import android.test.suitebuilder.annotation.SmallTest;

import com.amitkot.android.testing_sample_app.Util;

public class MainSampleActivityTest extends TestCase {

	public MainSampleActivityTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@SmallTest
	public void testRepeatText() {
		String data = "dog";
		int num = 3;
		String res = Util.repeatText(data, num);
		assertEquals("dogdogdog", res);
	}

}
