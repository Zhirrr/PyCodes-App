package com.zhirrrstudio.pycodes;

import androidx.appcompat.app.AppCompatActivity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;
import android.content.ClipData;
import android.content.ClipboardManager;

public class OneActivity extends AppCompatActivity {
	
	
	private String backgroundColor = "";
	
	private LinearLayout bg2;
	private LinearLayout linear3;
	private TextView t1;
	private LinearLayout linear2;
	private TextView b1;
	private TextView textview1;
	private TextView textview2;
	private LinearLayout linear4;
	private TextView textview3;
	private TextView textview4;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.one);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		bg2 = (LinearLayout) findViewById(R.id.bg2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		t1 = (TextView) findViewById(R.id.t1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		b1 = (TextView) findViewById(R.id.b1);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		
		b1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (textview1.getText().toString().trim().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Empty");
				}
				else {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview1.getText().toString().trim()));
					SketchwareUtil.showMessage(getApplicationContext(), "Copy");
				}
			}
		});
		
		textview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (textview4.getText().toString().trim().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Empty");
				}
				else {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview4.getText().toString().trim()));
					SketchwareUtil.showMessage(getApplicationContext(), "Copy");
				}
			}
		});
	}
	private void initializeLogic() {
		textview1.setText("import phonenumbers\nfrom phonenumbers import carrier\nfrom phonenumbers import geocoder\n\na = input(\"Input You Numbers: \")\nphone_number = phonenumbers.parse(a)\n\nprint(geocoder.description_for_number(phone_number, 'en'))\n\nprint(carrier.name_for_number(phone_number, \"en\"))");
		textview4.setText("pip install phonenumbers");
		_gd(linear2, "#000000", "#000000", 30);
		_gd(linear4, "#000000", "#000000", 30);
		_shadow(linear2, 15);
		_shadow(linear4, 15);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private void _gd (final View _view, final String _c, final String _sc, final double _r) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_c));
		gd.setCornerRadius((float)_r);
		gd.setStroke(2, Color.parseColor(_sc));
		
		_view.setBackground(gd);
	}
	
	
	private void _ColorShadow_SDK28 (final View _view, final String _color, final double _number) {
		_view.setElevation((float)_number);
		
		_view.setOutlineAmbientShadowColor(Color.parseColor(_color));
		_view.setOutlineSpotShadowColor(Color.parseColor(_color));
	}
	
	
	private void _shadow (final View _view, final double _bayangan) {
		android.graphics.drawable.GradientDrawable round = new android.graphics.drawable.GradientDrawable(); _view.setElevation((int)_bayangan);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
