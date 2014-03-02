package com.amitkot.android.fragments.fragments;

import com.amitkot.android.fragments.FragmentDialogActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class FruitDialogFragment extends DialogFragment {

	public static FruitDialogFragment newInstance() {
		return new FruitDialogFragment();
	}

	public FruitDialogFragment() {
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final String[] items = { "Apple", "Banana", "Cucumber" };
		return new AlertDialog.Builder(getActivity())
				.setTitle("Please pick a fruit:")
				.setItems(items, new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						String selectedFruit = items[which];
						((FragmentDialogActivity) getActivity())
								.fruitSelected(selectedFruit);
					}
				}).create();
	}
}
