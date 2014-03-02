package com.amitkot.android.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.amitkot.android.fragments.fragments.Fruit;
import com.amitkot.android.fragments.fragments.ItemsListFragment.OnFragmentListItemClickListener;

public class StaticLayoutActivity extends Activity implements
		OnFragmentListItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_static_layout);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public void onFragmentListItemClick(Fruit item) {
		Toast.makeText(this, "Clicked: " + item.name, Toast.LENGTH_SHORT)
				.show();
	}

}
