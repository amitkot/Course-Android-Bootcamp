package com.amitkot.android.listview.UI;

import android.os.Bundle;
import android.view.View;

import com.amitkot.android.listview.R;

public class EnhancedFruitListActivity extends FruitListActivity {

	private int exoticFruitsCounter = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enhanced_fruit_list);
	}

	public void addFruitEnd(View view) {
		fruits.add("Exotic Fruit " + exoticFruitsCounter);
		exoticFruitsCounter += 1;
		fruits.notifyDataSetChanged();
	}

	public void addFruitStart(View view) {
		int position = 0;
		fruits.insert("Exotic Fruit " + exoticFruitsCounter, position);
		exoticFruitsCounter += 1;
		fruits.notifyDataSetChanged();
	}

	public void removeFruit(View view) {
		int firstPosition = 0;
		String lastItem = fruits.getItem(firstPosition);
		fruits.remove(lastItem);
		fruits.notifyDataSetChanged();
	}

}
