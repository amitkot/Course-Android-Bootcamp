package com.amitkot.android.testing_sample_app.tests;

import org.mockito.Mockito;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;

import com.amitkot.android.testing_sample_app.DataRepository;
import com.amitkot.android.testing_sample_app.MainSampleActivity;
import com.amitkot.android.testing_sample_app.R;
import com.amitkot.android.testing_sample_app.Util;

public class MainSampleActivityUnitTest extends
		ActivityUnitTestCase<MainSampleActivity> {

	private MainSampleActivity mFirstActivity;
	private EditText mDataEditText;
	private EditText mRepeatEditText;
	private Button mSendButton;
	private Intent mIntent;

	public MainSampleActivityUnitTest() {
		super(MainSampleActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		mIntent = new Intent(getInstrumentation().getTargetContext(),
				MainSampleActivity.class);

		System.setProperty("dexmaker.dexcache", getInstrumentation()
				.getTargetContext().getCacheDir().getPath());
	}

	public void testPreconditions() {
		startActivity(mIntent, null, null);
		mFirstActivity = getActivity();
		mDataEditText = (EditText) mFirstActivity
				.findViewById(R.id.dataEditText);
		mRepeatEditText = (EditText) mFirstActivity
				.findViewById(R.id.repeatEditText);
		mSendButton = (Button) mFirstActivity.findViewById(R.id.sendButton);

		assertNotNull("mFirstActivity is null", mFirstActivity);
		assertNotNull("mDataEditText is null", mDataEditText);
		assertNotNull("mRepeatEditText is null", mRepeatEditText);
		assertNotNull("mSendButton is null", mSendButton);
	}

	@SmallTest
	public void testRepeatText() {
		String data = "dog";
		int num = 3;
		String res = Util.repeatText(data, num);
		assertEquals("dogdogdog", res);
	}

	@SmallTest
	public void testSendIntent() throws Throwable {
		startActivity(mIntent, null, null);
		mFirstActivity = getActivity();
		mDataEditText = (EditText) mFirstActivity
				.findViewById(R.id.dataEditText);
		mRepeatEditText = (EditText) mFirstActivity
				.findViewById(R.id.repeatEditText);
		mSendButton = (Button) mFirstActivity.findViewById(R.id.sendButton);

		getInstrumentation().callActivityOnStart(mFirstActivity);
		getInstrumentation().callActivityOnResume(mFirstActivity);

		mDataEditText.setText("dog");
		mRepeatEditText.setText("3");
		mSendButton.performClick();

		Intent triggeredIntent = getStartedActivityIntent();
		assertNotNull("Intent was null", triggeredIntent);
		String data = triggeredIntent.getExtras().getString(
				MainSampleActivity.DATA_INTENT_KEY);

		assertEquals("Incorrect data passed via the intent", "dogdogdog", data);
	}

	@SmallTest
	public void testTextValidation() {
		startActivity(mIntent, null, null);
		mFirstActivity = getActivity();

		// prepare
		DataRepository repo = Mockito.mock(DataRepository.class);
		Mockito.when(repo.wasTextSent("cat")).thenReturn(false);
		Mockito.when(repo.updateSendingText("cat")).thenReturn(true);
		
		// test
		boolean res = mFirstActivity.validateDataBeforeSending("cat", repo);
		
		// verify
		assertTrue(res);
		Mockito.verify(repo).wasTextSent("cat");
		Mockito.verify(repo).updateSendingText("cat");
		

		// Calling a second time
		Mockito.when(repo.wasTextSent("cat")).thenReturn(true);
		res = mFirstActivity.validateDataBeforeSending("cat", repo);
		assertFalse(res);
		Mockito.verify(repo, Mockito.times(2)).wasTextSent("cat");
	}
}
