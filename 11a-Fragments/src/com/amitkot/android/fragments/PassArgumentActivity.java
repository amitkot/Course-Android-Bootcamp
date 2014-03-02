package com.amitkot.android.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

import com.amitkot.android.fragments.fragments.EditTextFragment;

public class PassArgumentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pass_argument);

		final String[] items = { "Name", "Age", "Phone number" };
		new AlertDialog.Builder(this)
				.setTitle("Please choose hint:")
				.setItems(items, new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						String hint = items[which];
						EditTextFragment fragment = EditTextFragment
								.newInstance(hint);
						FragmentManager fm = getFragmentManager();
						fm.beginTransaction().add(R.id.content, fragment)
								.commit();
					}
				})
				.show();
	}

}
