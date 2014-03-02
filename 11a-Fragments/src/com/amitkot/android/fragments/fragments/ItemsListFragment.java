package com.amitkot.android.fragments.fragments;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.amitkot.android.fragments.R;

public class ItemsListFragment extends Fragment implements OnItemClickListener {

	private ListView mListView;

	private ListAdapter mAdapter;
	private ArrayList<Fruit> mData;

	private OnFragmentListItemClickListener mListener;

	public static ItemsListFragment newInstance() {
		ItemsListFragment fragment = new ItemsListFragment();
		return fragment;
	}

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public ItemsListFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mData = new ArrayList<Fruit>();
		for (int i = 0; i < 50; i++) {
			mData.add(new Fruit("Apple", R.drawable.img_apple));
			mData.add(new Fruit("Banana", R.drawable.img_banana));
			mData.add(new Fruit("Apricot", R.drawable.img_apricot));
			mData.add(new Fruit("Orange", R.drawable.img_orange));
			mData.add(new Fruit("Watermelon", R.drawable.img_watermelon));
			mData.add(new Fruit("Kiwi", R.drawable.img_kiwi));
			mData.add(new Fruit("Raspberry", R.drawable.img_raspberry));
			mData.add(new Fruit("Pineapple", R.drawable.img_pineapple));
			mData.add(new Fruit("Lychee", R.drawable.img_lychee));
			mData.add(new Fruit("Tomato", R.drawable.img_tomato));
		}

		mAdapter = new ArrayAdapter<Fruit>(getActivity(),
				android.R.layout.simple_list_item_1, android.R.id.text1, mData);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_item_list, container,
				false);

		// Set the adapter
		mListView = (ListView) view.findViewById(android.R.id.list);
		((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

		// Set OnItemClickListener so we can be notified on item clicks
		mListView.setOnItemClickListener(this);
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnFragmentListItemClickListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	@Override
	public void onItemClick(AdapterView<?> l, View v, int position, long id) {
		if (null != mListener) {
			// Notify the active callbacks interface (the activity, if the
			// fragment is attached to one) that an item has been selected.
			mListener.onFragmentListItemClick(mData.get(position));
		}
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated to
	 * the activity and potentially other fragments contained in that activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnFragmentListItemClickListener {
		public void onFragmentListItemClick(Fruit item);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_list, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.fragment_list_hi:
			Toast.makeText(getActivity(), "Hi from list fragment!",
					Toast.LENGTH_SHORT).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
