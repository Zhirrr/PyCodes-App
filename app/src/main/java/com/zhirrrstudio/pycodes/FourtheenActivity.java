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

public class FourtheenActivity extends AppCompatActivity {
	
	
	private LinearLayout bg2;
	private LinearLayout linear5;
	private TextView t1;
	private LinearLayout linear2;
	private TextView b1;
	private TextView textview1;
	private TextView textview5;
	private LinearLayout linear6;
	private TextView textview6;
	private TextView textview7;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.fourtheen);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		bg2 = (LinearLayout) findViewById(R.id.bg2);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		t1 = (TextView) findViewById(R.id.t1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		b1 = (TextView) findViewById(R.id.b1);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview5 = (TextView) findViewById(R.id.textview5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		
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
		
		textview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (textview7.getText().toString().trim().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Empty");
				}
				else {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview7.getText().toString().trim()));
					SketchwareUtil.showMessage(getApplicationContext(), "Copy");
				}
			}
		});
	}
	private void initializeLogic() {
		textview1.setText("import cv2\nimport numpy as np\n\nx,y,k = 200,200,-1\n\ncap = cv2.VideoCapture(0)\n\n\ndef take_inp(event, x1, y1, flag, param):\n    global x, y, k\n    if event == cv2.EVENT_LBUTTONDOWN:\n        x = x1\n        y = y1\n        k = 1\n\ncv2.namedWindow(\"enter_point\")\ncv2.setMouseCallback(\"enter_point\", take_inp)\n\nwhile True:\n     \n    _, inp_img = cap.read()\n    inp_img = cv2.flip(inp_img, 1)\n    gray_inp_img = cv2.cvtColor(inp_img, cv2.COLOR_BGR2GRAY)\n    \n    cv2.imshow(\"enter_point\", inp_img)\n    \n    if k == 1 or cv2.waitKey(30) == 27:\n        cv2.destroyAllWindows()\n        break\n\nstp = 0\n\n\nold_pts = np.array([[x, y]], dtype=np.float32).reshape(-1,1,2)\n\n\nmask = np.zeros_like(inp_img)\n\nwhile True:\n    _, new_inp_img = cap.read()\n    new_inp_img = cv2.flip(new_inp_img, 1)\n    new_gray = cv2.cvtColor(new_inp_img, cv2.COLOR_BGR2GRAY)     \n    new_pts,status,err = cv2.calcOpticalFlowPyrLK(gray_inp_img, \n                         new_gray, \n                         old_pts, \n                         None, maxLevel=1,\n                         criteria=(cv2.TERM_CRITERIA_EPS | cv2.TERM_CRITERIA_COUNT,\n                                                         15, 0.08))\n\n    for i, j in zip(old_pts, new_pts):\n        x,y = j.ravel()\n        a,b = i.ravel()\n        if cv2.waitKey(2) & 0xff == ord('q'):\n            stp = 1\n            \n        elif cv2.waitKey(2) & 0xff == ord('w'):\n            stp = 0\n        \n        elif cv2.waitKey(2) == ord('n'):\n            mask = np.zeros_like(new_inp_img)\n            \n        if stp == 0:\n            mask = cv2.line(mask, (a,b), (x,y), (0,0,255), 6)\n\n        cv2.circle(new_inp_img, (x,y), 6, (0,255,0), -1)\n    \n    new_inp_img = cv2.addWeighted(mask, 0.3, new_inp_img, 0.7, 0)\n    cv2.putText(mask, \"'q' to gap 'w' - start 'n' - clear\", (10,50), \n                cv2.FONT_HERSHEY_PLAIN, 2, (255,255,255))\n    cv2.imshow(\"ouput\", new_inp_img)\n    cv2.imshow(\"result\", mask)\n\n    \n    gray_inp_img = new_gray.copy()\n    old_pts = new_pts.reshape(-1,1,2)\n    \n    if cv2.waitKey(1) & 0xff == 27:\n        break\n    \n\ncv2.destroyAllWindows()\ncap.release()");
		textview7.setText("pip install cv2\npip install numpy");
		_gd(linear2, "#000000", "#000000", 30);
		_gd(linear6, "#000000", "#000000", 30);
		_shadow(linear2, 15);
		_shadow(linear6, 15);
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
