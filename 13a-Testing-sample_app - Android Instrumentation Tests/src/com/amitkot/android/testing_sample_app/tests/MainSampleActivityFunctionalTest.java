package com.amitkot.android.testing_sample_app.tests;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.amitkot.android.testing_sample_app.MainSampleActivity;
import com.amitkot.android.testing_sample_app.R;
import com.amitkot.android.testing_sample_app.SecondActivity;
import com.amitkot.android.testing_sample_app.Util;

public class MainSampleActivityFunctionalTest extends
		ActivityInstrumentationTestCase2<MainSampleActivity> {

	private MainSampleActivity mFirstActivity;
	private EditText mDataEditText;
	private EditText mRepeatEditText;
	private Button mSendButton;

	public MainSampleActivityFunctionalTest() {
		super(MainSampleActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		mFirstActivity = getActivity();
		mDataEditText = (EditText) mFirstActivity
				.findViewById(R.id.dataEditText);
		mRepeatEditText = (EditText) mFirstActivity
				.findViewById(R.id.repeatEditText);
		mSendButton = (Button) mFirstActivity.findViewById(R.id.sendButton);

		setActivityInitialTouchMode(false);

		getInstrumentation().getTargetContext().getCacheDir();
	}

	@SmallTest
	public void testPreconditions() {
		assertNotNull("mFirstActivity is null", mFirstActivity);
		assertNotNull("mDataEditText is null", mDataEditText);
		assertNotNull("mRepeatEditText is null", mRepeatEditText);
		assertNotNull("mSendButton is null", mSendButton);
	}

	@MediumTest
	public void testRepeatText() {
		String data = "dog";
		int num = 3;
		String res = Util.repeatText(data, num);
		assertEquals("dogdogdog", res);
	}

	@MediumTest
	public void testSendIntent() throws Throwable {

		// Set up an ActivityMonitor
		ActivityMonitor secondActivityMonitor = getInstrumentation()
				.addMonitor(SecondActivity.class.getName(), null, false);

		getInstrumentation().runOnMainSync(new Runnable() {

			@Override
			public void run() {
				mDataEditText.requestFocus();
			}
		});
		getInstrumentation().waitForIdleSync();
		getInstrumentation().sendStringSync("dog");
		getInstrumentation().waitForIdleSync();
		assertEquals("dog", mDataEditText.getText().toString());

		getInstrumentation().runOnMainSync(new Runnable() {

			@Override
			public void run() {
				mRepeatEditText.requestFocus();
			}
		});
		getInstrumentation().waitForIdleSync();
		getInstrumentation().sendStringSync("3");
		getInstrumentation().waitForIdleSync();
		assertEquals("3", mRepeatEditText.getText().toString());

//		TouchUtils.clickView(this, mSendButton);

		// Validate that ReceiverActivity is started
		TouchUtils.clickView(this, mSendButton);
		SecondActivity secondActivity = (SecondActivity) secondActivityMonitor
				.waitForActivityWithTimeout(2000);
		assertNotNull("SecondActivity is null", secondActivity);
		assertEquals("Monitor for SecondActivity has not been called", 1,
				secondActivityMonitor.getHits());
		assertEquals("Activity is of wrong type", SecondActivity.class,
				secondActivity.getClass());

		TextView textView = (TextView) secondActivity
				.findViewById(R.id.resultTextView);

		// check that the TextView is on the screen
		ViewAsserts.assertOnScreen(secondActivity.getWindow().getDecorView(),
				textView);
		// validate the text on the TextView
		assertEquals("dogdogdog", textView.getText().toString());

		// Remove the ActivityMonitor
		getInstrumentation().removeMonitor(secondActivityMonitor);
	}

}
