package com.amitkot.android.listview.UI;

import java.util.ArrayList;

import android.app.ListActivity;

import com.amitkot.android.listview.Fruit;
import com.amitkot.android.listview.FruitArrayAdapter;
import com.amitkot.android.listview.R;

public class CustomViewFruitListActivity extends ListActivity {

	protected FruitArrayAdapter fruitAdapter;

	@Override
	protected void onStart() {
		super.onStart();

		initList();
	}

	private void initList() {
		ArrayList<Fruit> data = new ArrayList<Fruit>();
		
		for (int i=0; i<500; i++) {
			data.add(new Fruit("Apple", "Tasty round fruit", R.drawable.img_apple));
			data.add(new Fruit("Banana", "Yellow and sweet", R.drawable.img_banana));
			data.add(new Fruit("Apricot", "Has a short season", R.drawable.img_apricot));
			data.add(new Fruit("Orange", "Juicy and refreshing", R.drawable.img_orange));
			data.add(new Fruit("Watermelon", "Sweet and has edible seeds", R.drawable.img_watermelon));
			data.add(new Fruit("Kiwi", "Sweet and sour, full with vitamin C", R.drawable.img_kiwi));
			data.add(new Fruit("Raspberry", "Fancy fruit from the forest", R.drawable.img_raspberry));
			data.add(new Fruit("Pineapple", "Very sweet, very acidic", R.drawable.img_pineapple));
			data.add(new Fruit("Lychee", "Incredibly tasty when eaten straight from the tree", R.drawable.img_lychee));
			data.add(new Fruit("Tomato", "Can be sweet, also considered a vegetable", R.drawable.img_tomato));
		}

		fruitAdapter = new FruitArrayAdapter(this, data);
		
		setListAdapter(fruitAdapter);

	}

}
