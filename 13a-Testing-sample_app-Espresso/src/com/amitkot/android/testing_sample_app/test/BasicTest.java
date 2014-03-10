package com.amitkot.android.testing_sample_app.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onData;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.pressBack;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.closeSoftKeyboard;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import android.test.ActivityInstrumentationTestCase2;

import com.amitkot.android.testing_sample_app.MainSampleActivity;
import com.amitkot.android.testing_sample_app.R;

public class BasicTest extends
		ActivityInstrumentationTestCase2<MainSampleActivity> {

	public BasicTest() {
		super(MainSampleActivity.class);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		// we must launch our activity via getActivity()
		getActivity();
	}

	public void testSimpleClickAndCheckText() {
		onView(withId(R.id.dataEditText)).perform(typeText("pig"));
		onView(withId(R.id.repeatEditText)).perform(typeText("3"));
		onView(withId(R.id.sendButton)).perform(click());

		onView(withId(R.id.resultTextView)).check(matches(withText("pigpigpig")));
	}

}
