package com.amitkot.android.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.amitkot.android.fragments.fragments.Fruit;
import com.amitkot.android.fragments.fragments.ItemFragment;
import com.amitkot.android.fragments.fragments.ItemsListFragment;
import com.amitkot.android.fragments.fragments.ItemsListFragment.OnFragmentListItemClickListener;

public class ActionBarActivity extends Activity implements
		OnFragmentListItemClickListener {

	private ItemsListFragment mItemsListFragment;
	private ItemFragment mItemFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dynamic_layout);

		mItemsListFragment = ItemsListFragment.newInstance();
		mItemsListFragment.setHasOptionsMenu(true);
		mItemFragment = ItemFragment.newInstance();
		mItemFragment.setHasOptionsMenu(true);

		getFragmentManager().beginTransaction()
				.add(R.id.content, mItemsListFragment)
				.add(R.id.content, mItemFragment).commit();

		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public void onFragmentListItemClick(Fruit item) {
		mItemFragment.setImage(item.image);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.action_bar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_activity_hi:
			Toast.makeText(this, "Hi from Activity!", Toast.LENGTH_SHORT)
					.show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}