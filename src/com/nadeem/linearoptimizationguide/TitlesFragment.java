package com.nadeem.linearoptimizationguide;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;

public class TitlesFragment extends SherlockListFragment {
	private MainActivity myActivity = null;
	int mCurCheckPosition = 0;

	

	@Override
	public void onAttach(Activity myActivity) {
		//Log.v(MainActivity.TAG, "in TitlesFragment onAttach; activity is: "
				//+ myActivity);
		super.onAttach(myActivity);
		this.myActivity = (MainActivity) myActivity;
	}

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		if (icicle != null) {
			// Restore last state for checked position.
			mCurCheckPosition = icicle.getInt("curChoice", 0);
		}
	}

	@Override
	public View onCreateView(LayoutInflater myInflater, ViewGroup container,
			Bundle icicle) {
		//Log.v(MainActivity.TAG, "in TitlesFragment onCreateView. container is "
				//+ container);
		return super.onCreateView(myInflater, container, icicle);
	}

	@Override
	public void onActivityCreated(Bundle icicle) {
		//Log.v(MainActivity.TAG,
				//"in TitlesFragment onActivityCreated. savedState contains:");
		
		super.onActivityCreated(icicle);

		// Populate list with our static array of titles.
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, Content.TITLES));

		ListView lv = getListView();
		lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		//lv.setSelection(mCurCheckPosition);

		//myActivity.showDetails(mCurCheckPosition);
	}

	@Override
	public void onSaveInstanceState(Bundle icicle) {
		Log.v(MainActivity.TAG, "in TitlesFragment onSaveInstanceState");
		super.onSaveInstanceState(icicle);
		icicle.putInt("curChoice", mCurCheckPosition);
	}

	@Override
	public void onListItemClick(ListView l, View v, int pos, long id) {
		//Log.v(MainActivity.TAG, "in TitlesFragment onListItemClick. pos = "
				//+ pos);
		myActivity.showDetails(pos);
		mCurCheckPosition = pos;
	}

	
}
