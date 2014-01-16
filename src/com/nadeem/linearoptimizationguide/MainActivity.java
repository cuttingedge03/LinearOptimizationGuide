package com.nadeem.linearoptimizationguide;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity {
	public static final String TAG = "Shakespeare";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		//Log.v(TAG, "in MainActivity onCreate");
		super.onCreate(savedInstanceState);
		FragmentManager.enableDebugLogging(true);
		setContentView(R.layout.main);
	}

	public boolean isMultiPane() {
		return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
	}

	/**
	 * Helper function to show the details of a selected item, either by
	 * displaying a fragment in-place in the current UI, or starting a whole new
	 * activity in which it is displayed.
	 */
	public void showDetails(int index) {
		//Log.v(TAG, "in MainActivity showDetails(" + index + ")");

		if (isMultiPane()) {
			// Check what fragment is shown, replace if needed.
			DetailsFragment details = (DetailsFragment) getSupportFragmentManager()
					.findFragmentById(R.id.details);
			if (details == null || details.getShownIndex() != index) {
				// Make new fragment to show this selection.
				details = DetailsFragment.newInstance(index);

				// Execute a transaction, replacing any existing
				// fragment with this one inside the frame.
				//Log.v(TAG, "about to run FragmentTransaction...");
				FragmentTransaction ft = getSupportFragmentManager()
						.beginTransaction();
				// ft.setCustomAnimations(R.animator.fragment_open_enter,
				// R.animator.fragment_open_exit);
				ft.setCustomAnimations(android.R.anim.fade_in,
						android.R.anim.fade_out);
				// ft.setCustomAnimations(R.animator.fade_in,
				// R.animator.fade_out);
				 ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.replace(R.id.details, details);
				// ft.addToBackStack(TAG);
				ft.commit();
				// getSupportFragmentManager().executePendingTransactions();
			}
		} else {
			// Otherwise we need to launch a new activity to display
			// the dialog fragment with selected text.
			Intent intent = new Intent();
			intent.setClass(this, DetailsActivity.class);
			intent.putExtra("index", index);
			startActivity(intent);
		}
	}
}