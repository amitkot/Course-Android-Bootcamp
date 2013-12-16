package com.amitkot.android.uiautomator;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class UiAutomatorTestForYesNoApp extends UiAutomatorTestCase {

	public void testDemo() throws UiObjectNotFoundException {
		getUiDevice().pressHome();

		UiObject allAppsButton = new UiObject(
				new UiSelector().description("Apps"));

		allAppsButton.clickAndWaitForNewWindow();

		UiScrollable appViews = new UiScrollable(
				new UiSelector().scrollable(true));

		UiObject app = appViews.getChildByText(new UiSelector()
				.className(android.widget.TextView.class.getName()),
				"4a-Monkey");
		app.clickAndWaitForNewWindow();

		UiObject appValidation = new UiObject(
				new UiSelector().packageName("com.amitkot.android.monkey"));
		assertTrue("Can't find Monkey", appValidation.exists());
	}
}
