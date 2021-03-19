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

public class TwelveActivity extends AppCompatActivity {
	
	
	private LinearLayout bg2;
	private LinearLayout linear4;
	private TextView t1;
	private LinearLayout linear2;
	private TextView b1;
	private TextView textview1;
	private TextView textview9;
	private LinearLayout linear5;
	private TextView textview10;
	private TextView textview11;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.twelve);
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
		textview9 = (TextView) findViewById(R.id.textview9);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		textview10 = (TextView) findViewById(R.id.textview10);
		textview11 = (TextView) findViewById(R.id.textview11);
		
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
		
		textview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (textview11.getText().toString().trim().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Empty");
				}
				else {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview11.getText().toString().trim()));
					SketchwareUtil.showMessage(getApplicationContext(), "Copy");
				}
			}
		});
	}
	private void initializeLogic() {
		textview1.setText("import cv2\nimport numpy as np\nimport sys\n\nfrom PyQt5 import QtCore\nfrom PyQt5 import QtWidgets\nfrom PyQt5 import QtGui\nfrom PyQt5.QtGui import QImage\n\n\nclass RecordVideo(QtCore.QObject):\n    image_data = QtCore.pyqtSignal(np.ndarray)\n\n    def __init__(self, camera_port, parent=None):\n        super().__init__(parent)\n        self.camera = cv2.VideoCapture(camera_port)\n        self.camera.set(cv2.CAP_PROP_FRAME_WIDTH, 640)\n        self.camera.set(cv2.CAP_PROP_FRAME_HEIGHT, 480)\n        self.timer = QtCore.QTimer()\n        self.timer.timeout.connect(self.timerEvent)\n        self.timer.start(0)\n\n    def timerEvent(self):\n        read, data = self.camera.read()\n        if read:\n            self.image_data.emit(data)\n\n\nclass FaceDetectionWidget(QtWidgets.QWidget):\n    def __init__(self, cascade_filepath, parent=None):\n        super().__init__(parent)\n        self.classifier = cv2.CascadeClassifier(cascade_filepath)\n        self.image = QImage()\n        self._border = (0, 255, 0)\n        self._width = 2\n\n    def detect_faces(self, image):\n        gray_image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)\n        gray_image = cv2.equalizeHist(gray_image)\n        faces = self.classifier.detectMultiScale(gray_image, 1.3, 5)\n        return faces\n\n    def image_data_slot(self, image_data):\n        if (self.width() > self.height()) != (image_data.shape[1] > image_data.shape[0]):\n            # Need to rotate image data, the screen / camera is rotated\n            image_data = cv2.rotate(image_data, cv2.ROTATE_90_COUNTERCLOCKWISE)\n        faces = self.detect_faces(image_data)\n        for (x, y, w, h) in faces:\n            cv2.rectangle(image_data, (x, y), (x + w, y + h), self._border, self._width)\n        self.image = self.get_qimage(image_data)\n        self.update()\n\n    def get_qimage(self, image):\n        height, width, colors = image.shape\n        image = QImage(image.data, width, height, 3 * width, QImage.Format_RGB888).rgbSwapped()\n        return image\n\n    def paintEvent(self, event):\n        painter = QtGui.QPainter(self)\n\n        w = self.width()\n        h = self.height()\n        cw = self.image.width()\n        ch = self.image.height()\n\n        # Keep aspect ratio\n        if ch != 0 and cw != 0:\n            w = min(cw * h / ch, w)\n            h = min(ch * w / cw, h)\n            w, h = int(w), int(h)\n\n        painter.drawImage(QtCore.QRect(0, 0, w, h), self.image)\n        self.image = QImage()\n\n\nclass MainWidget(QtWidgets.QWidget):\n    def __init__(self, haarcascade_filepath, parent=None):\n        super().__init__(parent)\n        fp = haarcascade_filepath\n        self.face_detection_widget = FaceDetectionWidget(fp)\n        # 1 is used for frontal camera\n        self.record_video = RecordVideo(1)\n        self.record_video.image_data.connect(self.face_detection_widget.image_data_slot)\n        layout = QtWidgets.QVBoxLayout()\n        layout.addWidget(self.face_detection_widget)\n        self.setLayout(layout)\n\n\napp = QtWidgets.QApplication(sys.argv)\nhaar_cascade_filepath = cv2.data.haarcascades + '/haarcascade_frontalface_default.xml'\nmain_window = QtWidgets.QMainWindow()\nmain_widget = MainWidget(haar_cascade_filepath)\nmain_window.setCentralWidget(main_widget)\nmain_window.show()\nsys.exit(app.exec_())");
		textview11.setText("pip install cv2\npip install numpy\npip install sys\npip install PyQt5");
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
