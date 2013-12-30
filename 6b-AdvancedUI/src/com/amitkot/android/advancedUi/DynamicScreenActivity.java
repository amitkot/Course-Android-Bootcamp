package com.amitkot.android.advancedUi;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class DynamicScreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dynamic_screen);
		
		LinearLayout root = (LinearLayout) findViewById(R.id.root_layout);

		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;

		Button btn;
		btn = new Button(this);
		btn.setLayoutParams(new LayoutParams(width/3, height/4));
		btn.setText("First");
		root.addView(btn);

		btn = new Button(this);
		btn.setLayoutParams(new LayoutParams(width*2/3, height/4));
		btn.setText("Second");
		root.addView(btn);

		btn = new Button(this);
		btn.setLayoutParams(new LayoutParams(width, height/4));
		btn.setText("Third");
		root.addView(btn);
	}

}
