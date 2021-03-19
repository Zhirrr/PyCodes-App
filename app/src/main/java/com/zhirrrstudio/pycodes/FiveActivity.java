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

public class FiveActivity extends AppCompatActivity {
	
	
	private LinearLayout bg2;
	private LinearLayout linear4;
	private TextView t1;
	private LinearLayout linear2;
	private TextView b1;
	private TextView textview1;
	private TextView textview10;
	private LinearLayout linear5;
	private TextView textview11;
	private TextView textview12;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.five);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		bg2 = (LinearLayout) findViewById(R.id.bg2);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		t1 = (TextView) findViewById(R.id.t1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		b1 = (TextView) findViewById(R.id.b1);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview10 = (TextView) findViewById(R.id.textview10);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		textview11 = (TextView) findViewById(R.id.textview11);
		textview12 = (TextView) findViewById(R.id.textview12);
		
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
		
		textview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (textview12.getText().toString().trim().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Empty");
				}
				else {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview12.getText().toString().trim()));
					SketchwareUtil.showMessage(getApplicationContext(), "Copy");
				}
			}
		});
	}
	private void initializeLogic() {
		textview1.setText("\nimport zipfile\n\n\ncount = 1\n\nwith open('passwords.txt','rb') as text:\n    for entry in text.readlines():\n        password = entry.strip()\n        try:\n            with zipfile.ZipFile('locked1.zip','r') as zf:\n                zf.extractall(pwd=password)\n\n                data = zf.namelist()[0]\n\n                data_size = zf.getinfo(data).file_size\n\n                print('''******************************\n[+] Password Found It! ~ %s\n ~%s\n ~%s\n******************************''' \n                    % (password.decode('utf8'), data, data_size))\n                break\n\n        except:\n            number = count\n            print('[%s] [-] Password Failed! - %s' % (number,password.decode('utf8')))\n            count += 1\n            pass");
		textview12.setText("pip install zipfile");
		_gd(linear2, "#000000", "#000000", 30);
		_gd(linear5, "#000000", "#000000", 30);
		_shadow(linear2, 15);
		_shadow(linear5, 15);
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
