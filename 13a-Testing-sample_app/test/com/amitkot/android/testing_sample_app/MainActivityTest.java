package com.amitkot.android.testing_sample_app;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.robolectric.Robolectric.shadowOf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

	private EditText mDataEditText;
	private EditText mRepeatEditText;
	private Button mSendButton;
	private MainSampleActivity mActivity;

	@Test
	public void shouldHaveHappySmiles() throws Exception {
		String hello = new MainSampleActivity().getResources().getString(
				R.string.hello_world);
		assertThat(hello, equalTo("Hello world!"));
	}

	@Before
	public void setUp() throws Exception {
		mActivity = Robolectric.buildActivity(MainSampleActivity.class)
				.create().visible().get();

		mDataEditText = (EditText) mActivity.findViewById(R.id.dataEditText);
		mRepeatEditText = (EditText) mActivity
				.findViewById(R.id.repeatEditText);
		mSendButton = (Button) mActivity.findViewById(R.id.sendButton);
	}

	@Test
	public void testHint() throws Exception {
		assertThat((String) mDataEditText.getHint(), equalTo("Text to be sent"));
	}

	@Test
	public void testDataPassingBetweenActivities() throws Exception {
		mDataEditText.setText("dog");
		mRepeatEditText.setText("2");
		mSendButton.performClick();

		ShadowActivity shadowActivity = shadowOf(mActivity);
		Intent startedIntent = shadowActivity.getNextStartedActivity();
		ShadowIntent shadowIntent = shadowOf(startedIntent);
		assertThat(shadowIntent.getComponent().getClassName(),
				equalTo(SecondActivity.class.getName()));
		assertThat(
				shadowIntent.getStringExtra(MainSampleActivity.DATA_INTENT_KEY),
				equalTo("dogdog"));
	}

}
