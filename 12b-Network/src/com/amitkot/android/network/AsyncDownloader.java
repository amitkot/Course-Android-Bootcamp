package com.amitkot.android.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class AsyncDownloader extends AsyncTask<String, Void, Bitmap> {

	public static final String TAG = "AsyncDownloader";

	private ImageView mImageView;
	private View mLoading;

	public AsyncDownloader(ImageView imageView, View loading) {
		mImageView = imageView;
		mLoading = loading;
	}

	@Override
	protected void onPreExecute() {
		mImageView.setVisibility(View.INVISIBLE);
		mLoading.setVisibility(View.VISIBLE);
	}
	
	@Override
	protected Bitmap doInBackground(String... params) {
		String url = params[0];
		try {
			return downloadUrl(url);
		} catch (IOException e) {
		}
		return null;
	}

	private Bitmap downloadUrl(String myurl) throws IOException {
		InputStream is = null;
		Bitmap bitmap = null;
		try {
			URL url = new URL(myurl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(10000 /* milliseconds */);
			conn.setConnectTimeout(15000 /* milliseconds */);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			// Starts the query
			conn.connect();
			int response = conn.getResponseCode();
			Log.d(TAG, "The response is: " + response);
			if (response == HttpURLConnection.HTTP_OK) {
				is = conn.getInputStream();
				bitmap = BitmapFactory.decodeStream(is);
			}

			// Makes sure that the InputStream is closed after the app is
			// finished using it.
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return bitmap;
	}

	@Override
	protected void onPostExecute(Bitmap bitmap) {
		mImageView.setImageBitmap(bitmap);
		mLoading.setVisibility(View.INVISIBLE);
		mImageView.setVisibility(View.VISIBLE);
	}
}