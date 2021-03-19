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

public class TwoActivity extends AppCompatActivity {
	
	
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
		setContentView(R.layout.two);
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
		textview1.setText("from datetime import datetime\nfrom tqdm import tqdm\nimport requests\nimport re\nimport sys\n\ndef connection(url='http://www.google.com/', timeout=5):\n    try:\n        req = requests.get(url, timeout=timeout)\n        req.raise_for_status()\n        print(\"You Connected To Internet\n\")\n        return True\n    except requests.HTTPError as e:\n        print(\"Checking internet connection failed, status code {0}.\".format(\n        e.response.status_code))\n    except requests.ConnectionError:\n        print(\"No Internet Connected.\")\n    return False\n\ndef download_image_video():\n\n    url = input(\"Input Video And Pictures URL Instagram: \")\n    x = re.match(r'^(https:)[/][/]www.([^/]+[.])*instagram.com', url)\n\n    try:\n        if x:\n            request_image = requests.get(url)\n            src = request_image.content.decode('utf-8')\n            check_type = re.search(r'<meta name=\"medium\" content=[\\'\"]?([^\\'\" >]+)', src)\n            check_type_f = check_type.group()\n            final = re.sub('<meta name=\"medium\" content=\"', '', check_type_f)\n\n            if final == \"image\":\n                print(\"\nDownloading the image...\")\n                extract_image_link = re.search(r'meta property=\"og:image\" content=[\\'\"]?([^\\'\" >]+)', src)\n                image_link = extract_image_link.group()\n                final = re.sub('meta property=\"og:image\" content=\"', '', image_link)\n                _response = requests.get(final).content\n                file_size_request = requests.get(final, stream=True)\n                file_size = int(file_size_request.headers['Content-Length'])\n                block_size = 1024 \n                filename = datetime.strftime(datetime.now(), '%Y-%m-%d-%H-%M-%S')\n                t=tqdm(total=file_size, unit='B', unit_scale=True, desc=filename, ascii=True)\n                with open(filename + '.jpg', 'wb') as f:\n                    for data in file_size_request.iter_content(block_size):\n                        t.update(len(data))\n                        f.write(data)\n                t.close()\n                print(\"Image Downloaded Successfully\")\n\n            if final == \"video\": \n                msg = input(\"You Are Downloading Video. You Want To Continue? (Y/n): \".lower())\n\n                if msg == \"y\":\n                    print(\"Downloading The Video...\")\n                    extract_video_link = re.search(r'meta property=\"og:video\" content=[\\'\"]?([^\\'\" >]+)', src)\n                    video_link = extract_video_link.group()\n                    final = re.sub('meta property=\"og:video\" content=\"', '', video_link)\n                    _response = requests.get(final).content\n                    file_size_request = requests.get(final, stream=True)\n                    file_size = int(file_size_request.headers['Content-Length'])\n                    block_size = 1024 \n                    filename = datetime.strftime(datetime.now(), '%Y-%m-%d-%H-%M-%S')\n                    t=tqdm(total=file_size, unit='B', unit_scale=True, desc=filename, ascii=True)\n                    with open(filename + '.mp4', 'wb') as f:\n                        for data in file_size_request.iter_content(block_size):\n                            t.update(len(data))\n                            f.write(data)\n                    t.close()\n                    print(\"Video Downloaded Successfully\")\n\n                if msg == \"n\":\n                    exit()  \n        else:\n            print(\"Please Input URL Instagram.com\")\n    except AttributeError:\n        print(\"Unknown URL\")\n\ndef pp_download():\n    \n    url = input(\"Input Profile URL Instagram: \")\n    x = re.match(r'^(https:)[/][/]www.([^/]+[.])*instagram.com', url)\n    \n    if x:\n        check_url1 = re.match(r'^(https:)[/][/]www.([^/]+[.])*instagram.com[/].*\\?hl=[a-z-]{2,5}', url)\n        check_url2 = re.match(r'^(https:)[/][/]www.([^/]+[.])*instagram.com$|^(https:)[/][/]www.([^/]+[.])*instagram.com/$', url)\n        check_url3 = re.match(r'^(https:)[/][/]www.([^/]+[.])*instagram.com[/][a-zA-Z0-9_]{1,}$', url)\n        check_url4 = re.match(r'^(https:)[/][/]www.([^/]+[.])*instagram.com[/][a-zA-Z0-9_]{1,}[/]$', url)\n\n        if check_url3:\n            final_url = url + '/?__a=1'\n\n        if check_url4:\n            final_url = url + '?__a=1'\n\n        if check_url2:\n            final_url = print(\"Please Input URL Instagram.com\")\n            exit()\n\n        if check_url1:\n            alpha = check_url1.group()\n            final_url = re.sub('\\\\?hl=[a-z-]{2,5}', '?__a=1', alpha)\n            \n    try:\n        if check_url3 or check_url4 or check_url2 or check_url1:\n            req = requests.get(final_url)\n            get_status = requests.get(final_url).status_code\n            get_content = req.content.decode('utf-8')\n\n            if get_status == 200:\n                print(\"\nDownloading the image...\")\n                find_pp = re.search(r'profile_pic_url_hd\\\":\\\"([^\\'\\\" >]+)', get_content)\n                pp_link = find_pp.group()\n                pp_final = re.sub('profile_pic_url_hd\":\"', '', pp_link)\n                file_size_request = requests.get(pp_final, stream=True)\n                file_size = int(file_size_request.headers['Content-Length'])\n                block_size = 1024 \n                filename = datetime.strftime(datetime.now(), '%Y-%m-%d-%H-%M-%S')\n                t=tqdm(total=file_size, unit='B', unit_scale=True, desc=filename, ascii=True)\n                with open(filename + '.jpg', 'wb') as f:\n                    for data in file_size_request.iter_content(block_size):\n                        t.update(len(data))\n                        f.write(data)\n                t.close()\n                print(\"Profile picture downloaded successfully\")\n\n    except Exception:\n        print('error')\n\nif connection() == True:\n    try:\n        while True:\n            a = \"Input 'A' To Download Instagram Profile.\nInput 'B' To Download Video And Pictures Instagram.\nInput 'Q' To Exit.\"\n            print(a)\n            select = str(input(\"\nInstaDown > \")).upper()\n            try:\n                if select == 'A':\n                    pp_download()\n                if select == 'B':\n                    download_image_video()\n                if select == 'Q':\n                    sys.exit()\n                else:\n                    sys.exit()\n            except (KeyboardInterrupt):\n                 print(\"Program Mati\")\n    except(KeyboardInterrupt):\n        print(\"\nProgram Mati\")\nelse:\n    sys.exit()");
		textview4.setText("pip install datetime\npip install requests\npip install sys\npip install tqdm");
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
