package com.dagger.infox;

import com.dagger.infox.R;
import com.actionbarsherlock.app.SherlockFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentFluxus extends SherlockFragment implements OnClickListener {
	static ImageView ivFluxus;
	TextView tvFluxus1;
	TextView tvFluxus2;
	Button flux, iiti;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.fragment_fluxus, container, false);
		setupVars(view);
		return view;
	}

	protected void setupVars(View view) {
		ivFluxus = (ImageView) view.findViewById(R.id.ivFluxus);
		tvFluxus1 = (TextView) view.findViewById(R.id.tvFluxus1);
		tvFluxus2 = (TextView) view.findViewById(R.id.tvFluxus2);
		flux = (Button) view.findViewById(R.id.bFluxus);
		iiti = (Button) view.findViewById(R.id.bIITI);

		tvFluxus1.setTextColor(getResources().getColor(R.color.bluetext));
		tvFluxus1.setText("USICT's Technical Fest");
		tvFluxus2.setText(getResources().getString(R.string.summary));

		ivFluxus.setOnClickListener(this);
		flux.setOnClickListener(this);
		iiti.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.ivFluxus:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.infox.in/")));
			break;
		case R.id.bFluxus:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.infox.in/")));
			break;
		case R.id.bIITI:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://infox.in/register")));
			break;
		}
	}

}
