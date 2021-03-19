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
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.net.Uri;
import android.widget.AdapterView;
import android.graphics.Typeface;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private double n1 = 0;
	private HashMap<String, Object> cacheMap = new HashMap<>();
	private HashMap<String, Object> Listmap = new HashMap<>();
	private String mainlist = "";
	
	private ArrayList<HashMap<String, Object>> itemsList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> cache = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<String> temp_search = new ArrayList<>();
	private ArrayList<String> list = new ArrayList<>();
	
	private LinearLayout linear3;
	private ListView listview1;
	private TextView textview2;
	private ImageView imageview1;
	
	private TimerTask tmr;
	private Intent intent = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		listview1 = (ListView) findViewById(R.id.listview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					intent.setClass(getApplicationContext(), OneActivity.class);
					startActivity(intent);
				}
				if (_position == 1) {
					intent.setClass(getApplicationContext(), TwoActivity.class);
					startActivity(intent);
				}
				if (_position == 2) {
					intent.setClass(getApplicationContext(), ThreeActivity.class);
					startActivity(intent);
				}
				if (_position == 3) {
					intent.setClass(getApplicationContext(), FiveActivity.class);
					startActivity(intent);
				}
				if (_position == 4) {
					intent.setClass(getApplicationContext(), SixActivity.class);
					startActivity(intent);
				}
				if (_position == 5) {
					intent.setClass(getApplicationContext(), SevenActivity.class);
					startActivity(intent);
				}
				if (_position == 6) {
					intent.setClass(getApplicationContext(), NineActivity.class);
					startActivity(intent);
				}
				if (_position == 7) {
					intent.setClass(getApplicationContext(), TenActivity.class);
					startActivity(intent);
				}
				if (_position == 8) {
					intent.setClass(getApplicationContext(), ElevenActivity.class);
					startActivity(intent);
				}
				if (_position == 9) {
					intent.setClass(getApplicationContext(), TwelveActivity.class);
					startActivity(intent);
				}
				if (_position == 10) {
					intent.setClass(getApplicationContext(), ThirteenActivity.class);
					startActivity(intent);
				}
				if (_position == 11) {
					intent.setClass(getApplicationContext(), FourtheenActivity.class);
					startActivity(intent);
				}
				if (_position == 12) {
					intent.setClass(getApplicationContext(), FiftheenActivity.class);
					startActivity(intent);
				}
				if (_position == 13) {
					intent.setClass(getApplicationContext(), SixteenActivity.class);
					startActivity(intent);
				}
			}
		});
	}
	private void initializeLogic() {
		intent.setClass(getApplicationContext(), SplashScreenActivity.class);
		startActivity(intent);
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("list", "");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("list", "");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("list", "");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("list", "");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("list", "");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("list", "");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("list", "");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("list", "");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("list", "");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("list", "");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("list", "");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("list", "");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("list", "");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("list", "");
			listmap.add(_item);
		}
		
		_Elevation(linear3, 7);
		_gd(linear3, 4, "#000000");
		listview1.setAdapter(new Listview1Adapter(listmap));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private void _Elevation (final View _view, final double _number) {
		
		_view.setElevation((int)_number);
	}
	
	
	private void _gd (final View _view, final double _numb, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_numb);
		_view.setBackground(gd);
	}
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _view, ViewGroup _viewGroup) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _view;
			if (_v == null) {
				_v = _inflater.inflate(R.layout.custom, null);
			}
			
			final LinearLayout linear2 = (LinearLayout) _v.findViewById(R.id.linear2);
			final LinearLayout linear3 = (LinearLayout) _v.findViewById(R.id.linear3);
			final ImageView imageview2 = (ImageView) _v.findViewById(R.id.imageview2);
			final TextView textview1 = (TextView) _v.findViewById(R.id.textview1);
			
			if (_position == 0) {
				textview1.setText("PhoneTracker");
				
				_Elevation(linear2, 7);
				_gd(linear2, 4, "#FFFFFF");
				_Elevation(linear3, 7);
				_gd(linear3, 4, "#FFFFFF");
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
			}
			if (_position == 1) {
				textview1.setText("Instagram Downloader");
				
				_Elevation(linear2, 7);
				_gd(linear2, 4, "#FFFFFF");
				_Elevation(linear3, 7);
				_gd(linear3, 4, "#FFFFFF");
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
			}
			if (_position == 2) {
				textview1.setText("YouTube Downloader");
				
				_Elevation(linear2, 7);
				_gd(linear2, 4, "#FFFFFF");
				_Elevation(linear3, 7);
				_gd(linear3, 4, "#FFFFFF");
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
			}
			if (_position == 3) {
				textview1.setText("BruteForce ZIP File");
				
				_Elevation(linear2, 7);
				_gd(linear2, 4, "#FFFFFF");
				_Elevation(linear3, 7);
				_gd(linear3, 4, "#FFFFFF");
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
			}
			if (_position == 4) {
				textview1.setText("Auto Write On Book With Rest API");
				
				_Elevation(linear2, 7);
				_gd(linear2, 4, "#FFFFFF");
				_Elevation(linear3, 7);
				_gd(linear3, 4, "#FFFFFF");
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
			}
			if (_position == 5) {
				textview1.setText("GogoAnime Scraper");
				
				_Elevation(linear2, 7);
				_gd(linear2, 4, "#FFFFFF");
				_Elevation(linear3, 7);
				_gd(linear3, 4, "#FFFFFF");
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
			}
			if (_position == 6) {
				textview1.setText("Instagram Profile Downloader");
				
				_Elevation(linear2, 7);
				_gd(linear2, 4, "#FFFFFF");
				_Elevation(linear3, 7);
				_gd(linear3, 4, "#FFFFFF");
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
			}
			if (_position == 7) {
				textview1.setText("Images Enhancer");
				
				_Elevation(linear2, 7);
				_gd(linear2, 4, "#FFFFFF");
				_Elevation(linear3, 7);
				_gd(linear3, 4, "#FFFFFF");
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
			}
			if (_position == 8) {
				textview1.setText("Images Filter");
				
				_Elevation(linear2, 7);
				_gd(linear2, 4, "#FFFFFF");
				_Elevation(linear3, 7);
				_gd(linear3, 4, "#FFFFFF");
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
			}
			if (_position == 9) {
				textview1.setText("Face Detection A.I With OpenCV");
				
				_Elevation(linear2, 7);
				_gd(linear2, 4, "#FFFFFF");
				_Elevation(linear3, 7);
				_gd(linear3, 4, "#FFFFFF");
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
			}
			if (_position == 10) {
				textview1.setText("Get System Info");
				
				_Elevation(linear2, 7);
				_gd(linear2, 4, "#FFFFFF");
				_Elevation(linear3, 7);
				_gd(linear3, 4, "#FFFFFF");
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
			}
			if (_position == 11) {
				textview1.setText("Draw In Air With OpenCV");
				
				_Elevation(linear2, 7);
				_gd(linear2, 4, "#FFFFFF");
				_Elevation(linear3, 7);
				_gd(linear3, 4, "#FFFFFF");
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
			}
			if (_position == 12) {
				textview1.setText("Draw In Air With OpenCV Version 2");
				
				_Elevation(linear2, 7);
				_gd(linear2, 4, "#FFFFFF");
				_Elevation(linear3, 7);
				_gd(linear3, 4, "#FFFFFF");
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
			}
			if (_position == 13) {
				textview1.setText("Scrape All Links Web");
				
				_Elevation(linear2, 7);
				_gd(linear2, 4, "#FFFFFF");
				_Elevation(linear3, 7);
				_gd(linear3, 4, "#FFFFFF");
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
			}
			
			return _v;
		}
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
