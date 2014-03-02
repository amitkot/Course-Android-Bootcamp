package com.amitkot.android.fragments.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.amitkot.android.fragments.R;

public class EditTextFragment extends Fragment {

	public static EditTextFragment newInstance(String hint) {
		EditTextFragment fragment = new EditTextFragment();
		Bundle args = new Bundle();
		args.putString("hint", hint);
		fragment.setArguments(args);
		return fragment;
	}

	public EditTextFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		EditText editText = (EditText) inflater.inflate(
				R.layout.fragment_edit_text, container, false);
		String hint = getArguments().getString("hint");
		editText.setHint(hint);
		return editText;
	}
}
