package com.amitkot.android.advancedUi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ResourceInProgrammaticActivity extends Activity {

	public static final String INTENT_KEY_NUMBER_OF_PAIRS = "com.amitkot.android.number_of_pairs";
	public static final int DEFAULT_NUMBER_OF_PAIRS = 1;

	public static final String INTENT_KEY_USER_DATA = "com.amitkot.android.user_data";

	private static final int MAGIC = 17;
	private static final int MAGIC2 = 31;

	private int mNumOfPairs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final LinearLayout vertical = new LinearLayout(this);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		vertical.setLayoutParams(params);
		vertical.setOrientation(LinearLayout.VERTICAL);

		final Intent intent = getIntent();
		mNumOfPairs = intent.getIntExtra(INTENT_KEY_NUMBER_OF_PAIRS, DEFAULT_NUMBER_OF_PAIRS); 

		View editText;
		for (int i = 0; i < mNumOfPairs; i++) {
			View pair = getLayoutInflater().inflate(R.layout.pair, vertical);
			editText = pair.findViewById(R.id.data_edit_text);
			editText.setId(getMagicId(i));
		}
		
		Button done = new Button(this);
		done.setLayoutParams(params);
		done.setText("Done");
		done.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent data = getIntent();
				String userData[] = new String[mNumOfPairs];
				EditText et;
				for (int i = 0; i < mNumOfPairs; i++) {
					et = (EditText) vertical.findViewById(getMagicId(i));
					userData[i] = et.getText().toString();
				}
				data.putExtra(INTENT_KEY_USER_DATA, userData);
				setResult(RESULT_OK, data);
				finish();
			}
		});
		vertical.addView(done);

		setContentView(vertical);

	}

	private int getMagicId(int i) {
		return MAGIC * i + MAGIC2;
	}
}
