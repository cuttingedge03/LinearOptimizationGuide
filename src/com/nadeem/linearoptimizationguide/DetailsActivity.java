package com.nadeem.linearoptimizationguide;

import android.content.res.Configuration;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class DetailsActivity extends SherlockFragmentActivity {

    @Override
	public void onCreate(Bundle savedInstanceState) {
    	//Log.v(MainActivity.TAG, "in DetailsActivity onCreate");
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
           
            finish();
            return;
        }

        if(getIntent() != null) {
             
            DetailsFragment details =
        	    DetailsFragment.newInstance(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                .add(android.R.id.content, details)
                .commit();
        }
    }
}
