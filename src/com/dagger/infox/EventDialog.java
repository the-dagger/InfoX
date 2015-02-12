package com.dagger.infox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.dagger.infox.R;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("Recycle")
public class EventDialog extends FragmentActivity implements OnClickListener {

	TextView title, description;
	String name, detail;
	Button remind, close, reg, next, prev;
	int evtType, evtNum;
	List<List<String>> events;
	List<List<String>> abst;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event);
		Bundle gotBasket = getIntent().getExtras();
		evtType = gotBasket.getInt("typeEvent");
		evtNum = gotBasket.getInt("key");

		title = (TextView) findViewById(R.id.tvTitle);
		description = (TextView) findViewById(R.id.tvDescription);
		remind = (Button) findViewById(R.id.bSetRem);
		close = (Button) findViewById(R.id.bCloseEventDialog);
		reg = (Button) findViewById(R.id.bReg);
		next = (Button) findViewById(R.id.bNextEvent);
		prev = (Button) findViewById(R.id.bPrevEvent);

		remind.setOnClickListener(this);
		close.setOnClickListener(this);
		reg.setOnClickListener(this);
		prev.setOnClickListener(this);
		next.setOnClickListener(this);
		
		Resources res = getResources();
		
		events = new ArrayList<List<String>>();
		TypedArray evts = res.obtainTypedArray(R.array.eventTypesIdArr);
		for (int i = 0; i < evts.length(); i++) {
			int tres = evts.getResourceId(i, 0);
			String[] tarr = res.getStringArray(tres);
			events.add(Arrays.asList(tarr));
		}
		
		abst = new ArrayList<List<String>>();
		TypedArray absts = res.obtainTypedArray(R.array.eventAbstIdArr);
		for (int i = 0; i < absts.length(); i++) {
			int tres = absts.getResourceId(i, 0);
			String[] tarr = res.getStringArray(tres);
			abst.add(Arrays.asList(tarr));
		}

		name=detail="N/A";
		setNameAndDetail(evtType, evtNum);
	}

	protected void setNameAndDetail(int evtType, int evtNum) {
		if (evtNum <= 0) {prev.setVisibility(View.INVISIBLE);}
		else {prev.setVisibility(View.VISIBLE);}
		name = events.get(evtType).get(evtNum);
		detail = abst.get(evtType).get(evtNum);
		if (evtNum >= events.get(evtType).size()-1) {next.setVisibility(View.INVISIBLE);}
		else {next.setVisibility(View.VISIBLE);}
		title.setText(name);
		description.setText("    " + detail);
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSetRem:
			Calendar beginTime = Calendar.getInstance();
			beginTime.set(2015, 2, 20, 5, 30);
			Calendar endTime = Calendar.getInstance();
			endTime.set(2015, 2, 22, 23, 30);
			Intent set = new Intent(Intent.ACTION_INSERT)
					.setData(Events.CONTENT_URI)
					.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
							beginTime.getTimeInMillis())
					.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
							endTime.getTimeInMillis())
					.putExtra(Events.TITLE, name)
					.putExtra(Events.DESCRIPTION, detail)
					.putExtra(Events.EVENT_LOCATION, "USICT Dwarka")
					.putExtra(Events.AVAILABILITY, Events.AVAILABILITY_BUSY)
					.putExtra(Intent.EXTRA_EMAIL, "contactus@infox.in");
			startActivity(set);
			break;
		case R.id.bCloseEventDialog:
			finish();
			break;
		case R.id.bReg:
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://infox.in/register")));
			break;
		case R.id.bPrevEvent:
			setNameAndDetail(evtType, --evtNum);
			break;
		case R.id.bNextEvent:
			setNameAndDetail(evtType, ++evtNum);
			break;
		}
	}
}
