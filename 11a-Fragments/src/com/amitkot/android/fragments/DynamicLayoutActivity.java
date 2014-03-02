package com.amitkot.android.fragments;

import android.app.Activity;
import android.os.Bundle;

import com.amitkot.android.fragments.fragments.Fruit;
import com.amitkot.android.fragments.fragments.ItemFragment;
import com.amitkot.android.fragments.fragments.ItemsListFragment;
import com.amitkot.android.fragments.fragments.ItemsListFragment.OnFragmentListItemClickListener;

public class DynamicLayoutActivity extends Activity implements
		OnFragmentListItemClickListener {

	private ItemsListFragment mItemsListFragment;
	private ItemFragment mItemFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dynamic_layout);

		mItemsListFragment = ItemsListFragment.newInstance();
		mItemFragment = ItemFragment.newInstance();
		getFragmentManager().beginTransaction()
				.add(R.id.content, mItemsListFragment)
				.add(R.id.content, mItemFragment).commit();

		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public void onFragmentListItemClick(Fruit item) {
		mItemFragment.setImage(item.image);
	}

}
