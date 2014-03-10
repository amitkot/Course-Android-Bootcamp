package com.amitkot.android.testing_sample_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainSampleActivity extends Activity {

	public static final String DATA_INTENT_KEY = "com.amitkot.android.testing.data_key";

	DataRepository mValidator = new DataRepository();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_sample);

		final EditText dataEditText = (EditText) findViewById(R.id.dataEditText);
		final EditText repeatEditText = (EditText) findViewById(R.id.repeatEditText);

		Button send = (Button) findViewById(R.id.sendButton);
		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainSampleActivity.this,
						SecondActivity.class);

				String text = dataEditText.getText().toString();
				if (validateDataBeforeSending(text, mValidator)) {
					int repeat = Integer.valueOf(repeatEditText.getText()
							.toString());
					String data = Util.repeatText(text, repeat);

					intent.putExtra(DATA_INTENT_KEY, data);
					startActivity(intent);
				}
			}
		});
	}

	/**
	 * Verify that the text wasn't sent already and that it is not over 4 chars
	 * 
	 * @param text
	 *            the text to be validated
	 * @param repository
	 *            the storage of the texts that were already sent
	 * @return true if the
	 */
	public boolean validateDataBeforeSending(String text,
			DataRepository repository) {
		if (repository.wasTextSent(text)) {
			return false;
		}
		if (text.length() > 4) {
			return false;
		}
		return repository.updateSendingText(text);
	}

}
