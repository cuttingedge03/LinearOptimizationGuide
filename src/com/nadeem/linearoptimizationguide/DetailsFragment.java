package com.nadeem.linearoptimizationguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

public class DetailsFragment extends SherlockFragment {

	private int mIndex = 0;

	public String a, b, c, d, e;
	public TextView text;
	public ImageView image1;

	public static DetailsFragment newInstance(int index) {
		// Log.v(MainActivity.TAG, "in DetailsFragment newInstance(" + index +
		// ")");

		DetailsFragment df = new DetailsFragment();

		// Supply index input as an argument.
		Bundle args = new Bundle();
		args.putInt("index", index);
		df.setArguments(args);
		return df;
	}

	public static DetailsFragment newInstance(Bundle bundle) {
		int index = bundle.getInt("index", 0);
		return newInstance(index);
	}

	@Override
	public void onCreate(Bundle myBundle) {
		// Log.v(MainActivity.TAG,
		// "in DetailsFragment onCreate. Bundle contains:");
		super.onCreate(myBundle);

		mIndex = getArguments().getInt("index", 0);

	}

	public int getShownIndex() {
		return mIndex;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Log.v(MainActivity.TAG,
		// "in DetailsFragment onCreateView. container = "
		// + container);

		// Don't tie this fragment to anything through the inflater. Android
		// takes care of attaching fragments for us. The container is only
		// passed in so we can know about the container where this View
		// hierarchy is going to go.
		// Content con=new Content();

		a = getResources().getString(R.string.standard_form);
		b = getResources().getString(R.string.pivoting);
		c = getResources().getString(R.string.primal_simplex);
		d = getResources().getString(R.string.dual_simplex);
		e = getResources().getString(R.string.two_phase_simplex);
		String details[] = { a, b, c, d, e };

		View v = inflater.inflate(R.layout.details, container, false);
		WebView webView = (WebView) v.findViewById(R.id.text1);
		text=(TextView)v.findViewById(R.id.text2);
		image1=(ImageView)v.findViewById(R.id.image1);
		// text1.setText(con.DIALOGUE[mIndex]);
		text.setText(R.string.example_text);
		if(mIndex==2)
		{
			image1.setBackgroundResource(R.drawable.primal);
			webView.loadDataWithBaseURL(null, details[mIndex], "text/html",
					"utf-8", null);
		}
		else if(mIndex==3)
		{
			image1.setBackgroundResource(R.drawable.dual);
			webView.loadDataWithBaseURL(null, details[mIndex], "text/html",
					"utf-8", null);
		}
		else if(mIndex==4)
		{
			image1.setBackgroundResource(R.drawable.two_phase);
			webView.loadDataWithBaseURL(null, details[mIndex], "text/html",
					"utf-8", null);
		}
		else
		{
			text.setVisibility(View.GONE);
			image1.setVisibility(View.GONE);
			webView.loadDataWithBaseURL(null, details[mIndex], "text/html",
					"utf-8", null);
		}
		
		return v;
	}

}
