package com.dagger.infox;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CallTextView extends TextView{

	public CallTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
		// TODO Auto-generated constructor stub
	}

	public CallTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
		// TODO Auto-generated constructor stub
	}

	public CallTextView(Context context) {
		super(context);
		init();
		// TODO Auto-generated constructor stub
	}

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                                               "Gotham Nights.ttf");
        setTypeface(tf);
    }
    
}
