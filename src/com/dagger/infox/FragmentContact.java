package com.dagger.infox;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dagger.infox.R;
import com.actionbarsherlock.app.SherlockFragment;

@SuppressLint("ResourceAsColor")
public class FragmentContact extends SherlockFragment {
	LinearLayout ll;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_contact, container,
				false);
		setupVars(view);
		return view;
	}
	
	private class ContactGroup{
		String title;
		String[] names;
		public ContactGroup(String a,String[] n){
			title=a;
			names=n;
		}
	}

	@SuppressLint("ResourceAsColor")
	protected void setupVars(View view) {
		ll = (LinearLayout) view.findViewById(R.id.llContact);
		MyTextView mt;
		List<ContactGroup> contacts = new ArrayList<ContactGroup>();
		contacts.add(new ContactGroup("Overall Coordinators",new String[]{"Name +91 99 68 195 588","Name +91 89 82 887 047"}));
		contacts.add(new ContactGroup("Technical Head",new String[]{"Name +91 73 89 154 845","Name +91 89 62 111 713"}));
		//contacts.add(new ContactGroup("Cultural Head",new String[]{"Kaushik Barodiya +91 89 62 627 344","Deepak Sattiraju +91 74 15 133 281"}));
		//contacts.add(new ContactGroup("Social Coordinator",new String[]{"Deepak Raj +91 81 09 245 899"}));
		contacts.add(new ContactGroup("PR Manager",new String[]{"Name +91 73 89 101 000"}));
		contacts.add(new ContactGroup("Faculty Coordinators",new String[]{"Name","Name"}));
		for (int i = 0; i < contacts.size(); i++) {
			mt = new MyTextView(getSherlockActivity());
			mt.setText(contacts.get(i).title);
			mt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
			mt.setTextSize(30);
			mt.setTextColor(getResources().getColor(R.color.bluetext));
			ll.addView(mt);
			for (int j = 0; j < contacts.get(i).names.length; j++) {
				mt = new MyTextView(getSherlockActivity());
				mt.setAutoLinkMask(Linkify.ALL);
				mt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
				mt.setPadding(20, 0, 0, 0);
				mt.setTextSize(22);
				mt.setText(contacts.get(i).names[j]);
				ll.addView(mt);
			}
		}
	}
}
