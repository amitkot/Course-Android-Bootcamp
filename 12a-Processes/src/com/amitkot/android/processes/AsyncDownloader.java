package com.amitkot.android.processes;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AsyncDownloader extends
		AsyncTask<String, Integer, Boolean> {

	public static final String TAG = "AsyncDownloader";

	private ProgressBar mProgress;
	private Context mCtx;

	public AsyncDownloader(Context context, ProgressBar progress) {
		mCtx = context;
		mProgress = progress;
	}

	@Override
	protected void onPreExecute() {
		mProgress.setProgress(0);
	}

	@Override
	protected Boolean doInBackground(String... params) {
		String url = params[0];
		try {
			return downloadUrl(url);
		} catch (IOException e) {
		}
		return null;
	}

	private boolean downloadUrl(String myurl) throws IOException {
		InputStream is = null;
		int num = 0;
		int total = 0;
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
			if(response == HttpURLConnection.HTTP_OK) {
				
			}
			int size = conn.getContentLength();
			mProgress.setMax(size);
			Log.d(TAG, "The response is: " + response);
			is = conn.getInputStream();

			byte[] buffer = new byte[1024];
			while (!isCancelled() && (num = is.read(buffer)) != -1) {
				Log.d(TAG, "read " + num + " bytes");
				total += num;
				publishProgress(total);
			}

			// Makes sure that the InputStream is closed after the app is
			// finished using it.
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return !isCancelled() && num == -1;
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		int total = values[0];
		mProgress.setProgress(total);
	}

	@Override
	protected void onPostExecute(Boolean result) {
		Toast.makeText(mCtx, "Download ended. Success - " + result,
				Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onCancelled(Boolean result) {
		Toast.makeText(mCtx, "Task was canceled!", Toast.LENGTH_LONG).show();
	}
}