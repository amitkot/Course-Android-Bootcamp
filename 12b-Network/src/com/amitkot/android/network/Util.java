package com.amitkot.android.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

public class Util {

	// no instantiation
	private Util() {
	}

	public static void addActivityButton(final Context context, String s,
			final Class<? extends Activity> c, ViewGroup root) {
		Button btn = new Button(context);
		LayoutParams btnLayoutParams = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		btn.setLayoutParams(btnLayoutParams);
		btn.setText(s);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, c);
				context.startActivity(intent);
			}
		});
		root.addView(btn);
	}

}
