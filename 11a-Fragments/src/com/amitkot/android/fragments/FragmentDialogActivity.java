package com.amitkot.android.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.amitkot.android.fragments.fragments.FruitDialogFragment;

public class FragmentDialogActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_dialog);
	}

	public void fruitSelected(String selectedFruit) {
		Toast.makeText(this, "Selected fruit is " + selectedFruit,
				Toast.LENGTH_SHORT).show();
	}

	public void showAsDialog(View v) {
		FruitDialogFragment fruitDialog = FruitDialogFragment.newInstance();
		fruitDialog.show(getFragmentManager(), "dialog");
	}
}
