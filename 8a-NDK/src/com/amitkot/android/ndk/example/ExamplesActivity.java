package com.amitkot.android.ndk.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ExamplesActivity extends Activity {

	static {
		System.loadLibrary("MoreExamples");
	}

	private String mSecretAnimal;
	private EditText mFirst;
	private EditText mSecond;
	private TextView mConcatRes;

	public native String concatenate(String first, String second);

	public native int sum(int first, int second);

	public native int sumArray(int[] array);

	public native void processAnimal();
	
	public native void nativeShowAnimalAsToast();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_examples);

		mFirst = (EditText) findViewById(R.id.editTextConcatFirst);
		mSecond = (EditText) findViewById(R.id.editTextConcatSecond);
		mConcatRes = (TextView) findViewById(R.id.textViewConcatenated);
	}

	private void showToast(String txt) {
		Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
	}

	public void concatenateClicked(View view) {
		String first = mFirst.getText().toString();
		String second = mSecond.getText().toString();
		String res = concatenate(first, second);
		mConcatRes.setText(res);
	}

	public void sumClicked(View view) {
		int first = Integer.valueOf(mFirst.getText().toString());
		int second = Integer.valueOf(mSecond.getText().toString());
		int res = sum(first, second);
		mConcatRes.setText(String.valueOf(res));
	}

	public void sumArrayClicked(View view) {
		int first = Integer.valueOf(mFirst.getText().toString());
		int second = Integer.valueOf(mSecond.getText().toString());
		int arr[] = { first, second };
		int res = sumArray(arr);
		mConcatRes.setText(String.valueOf(res));
	}

	public void resetClicked(View view) {
		mFirst.setText(null);
		mSecond.setText(null);
		mConcatRes.setText(null);
	}

	public void storeSecretAnimal(View view) {
		String first = mFirst.getText().toString();
		mSecretAnimal = first;
		mFirst.setText(null);
	}

	public void processSecretAnimal(View view) {
		processAnimal();
		new AlertDialog.Builder(this).setTitle("Secret Animal Name")
				.setMessage(mSecretAnimal).show();
	}

	public void showAsToastClicked(View view) {
		nativeShowAnimalAsToast();
	}
}
