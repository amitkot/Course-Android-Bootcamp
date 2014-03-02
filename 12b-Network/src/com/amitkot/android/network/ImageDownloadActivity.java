package com.amitkot.android.network;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageDownloadActivity extends Activity {

	private static final String IMG_URL_MEXICO = "https://farm3.staticflickr.com/2854/11075039705_06f212cbd7_o_d.jpg";
	private static final String IMG_URL_BERLIN = "https://farm4.staticflickr.com/3792/11248931365_a7f69ffd98_o_d.jpg";
	private ImageView mImage;
	private LinearLayout mLoading;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_download);

		mImage = (ImageView) findViewById(R.id.imageView);
		mLoading = (LinearLayout) findViewById(R.id.loading);

		ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo == null || !networkInfo.isConnected()) {
			new AlertDialog.Builder(this)
					.setMessage("No connectivity. Try again later!")
					.setCancelable(false)
					.setPositiveButton("OK", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							finish();
						}
					}).show();
		}

	}

	public void loadMexico(View view) {
		AsyncDownloader task = new AsyncDownloader(mImage, mLoading);
		task.execute(IMG_URL_MEXICO);
	}

	public void loadBerlin(View view) {
		AsyncDownloader task = new AsyncDownloader(mImage, mLoading);
		task.execute(IMG_URL_BERLIN);
	}
}
