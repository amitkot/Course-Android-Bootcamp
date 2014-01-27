package com.amitkot.android.listview.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amitkot.android.listview.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
 
	public void openListView(View view) {
		Intent intent = new Intent(this, ActivityWithListView.class);
		startActivity(intent);
	}
	
	public void openListActivity(View view) {
		Intent intent = new Intent(this, FruitListActivity.class);
		startActivity(intent);
	}
	
	public void openMultipleSelectionListActivity(View view) {
		Intent intent = new Intent(this, FruitMultipleSelectionListActivity.class);
		startActivity(intent);
	}
	
	public void openSelectionListActivity(View view) {
		Intent intent = new Intent(this, FruitSelectionListActivity.class);
		startActivity(intent);
	}
	
	public void openGridActivity(View view) {
		Intent intent = new Intent(this, DrawableGridActivity.class);
		startActivity(intent);
	}
	
	public void openEnhancedListActivity(View view) {
		Intent intent = new Intent(this, EnhancedFruitListActivity.class);
		startActivity(intent);
	}
	
	public void openSimpleCustomViewFruitListActivity(View view) {
		Intent intent = new Intent(this, SimpleCustomViewFruitListActivity.class);
		startActivity(intent);
	}

	public void openCustomBindingListActivity(View view) {
		Intent intent = new Intent(this, CustomViewFruitListActivity.class);
		startActivity(intent);
	}

	public void openHolderPatternCustomBindingListActivity(View view) {
		Intent intent = new Intent(this, HolderPatternCustomViewFruitListActivity.class);
		startActivity(intent);
	}
}
