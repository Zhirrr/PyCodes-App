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

public class FiftheenActivity extends AppCompatActivity {
	
	
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
		setContentView(R.layout.fiftheen);
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
		textview1.setText("import cv2\nimport numpy as np\n\nix, iy, k = 200, 200, -1\ndef mouse(event, x, y, flags, param):\n    global ix, iy, k\n    if event == cv2.EVENT_LBUTTONDOWN:\n        ix, iy = x, y\n        k = 1\n        \n\ncv2.namedWindow(\"draw\")\ncv2.setMouseCallback(\"draw\", mouse)\n\ncap = cv2.VideoCapture(0)\n\n\nwhile True:\n    _, frm = cap.read()\n\n    frm = cv2.flip(frm, 1)\n\n    cv2.imshow(\"draw\", frm)\n\n    if cv2.waitKey(1) == 27 or k == 1:\n        old_gray = cv2.cvtColor(frm, cv2.COLOR_BGR2GRAY)\n        mask = np.zeros_like(frm)\n        break\n\ncv2.destroyAllWindows()\n\nold_pts = np.array([[ix, iy]], dtype=np.float32).reshape(-1,1,2)\n\ncolor = (0,255,0)\nc=0\nwhile True:\n\n    _, new_frm = cap.read()\n\n    new_frm = cv2.flip(new_frm, 1)\n\n    new_gray = cv2.cvtColor(new_frm ,cv2.COLOR_BGR2GRAY)\n\n    new_pts,status,err = cv2.calcOpticalFlowPyrLK(old_gray, \n                         new_gray, \n                         old_pts, \n                         None, maxLevel=1,\n                         criteria=(cv2.TERM_CRITERIA_EPS | cv2.TERM_CRITERIA_COUNT,\n                                                         15, 0.08))\n\n    key = cv2.waitKey(1)\n\n    if key == ord('e'):\n        mask = np.zeros_like(new_frm)\n\n    elif key == ord('c'):\n        color = (0,0,0)\n        lst = list(color)\n        c+=1\n        lst[c%3] = 255\n        color = tuple(lst)\n\n    elif key == ord('g'):\n        pass\n    else:\n        for i, j in zip(old_pts, new_pts):\n            x,y = j.ravel()\n            a, b = i.ravel()\n\n            cv2.line(mask, (a,b), (x, y), color, 15)\n\n    cv2.circle(new_frm, (x,y), 3, (255,255,0), 2)\n\n\n    \n    new_frm = cv2.addWeighted(new_frm ,0.8, mask, 0.2, 0.1)\n\n    cv2.imshow(\"\", new_frm)\n    cv2.imshow(\"drawing\", mask)\n\n    old_gray = new_gray.copy()\n\n    old_pts = new_pts.reshape(-1,1,2)\n\n    if key == 27:\n        break\n\n\ncv2.destroyAllWindows()\ncap.release()");
		textview4.setText("pip install cv2\npip install numpy");
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
