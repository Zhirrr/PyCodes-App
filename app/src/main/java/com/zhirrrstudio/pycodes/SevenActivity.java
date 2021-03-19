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

public class SevenActivity extends AppCompatActivity {
	
	
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
		setContentView(R.layout.seven);
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
		textview1.setText("import requests, json, os\nfrom bs4 import BeautifulSoup\nimport re as RegExp\n\nmy_headers = {}\nmy_headers['user-agent'] = 'Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36'\n\nclass AnimeScraper:\n    def __init__(self, url):\n        animeSoup = BeautifulSoup(requests.get(url, headers=my_headers).text, 'html.parser')\n        animeID = animeSoup.find(id='movie_id')['value']\n        animeAlias = animeSoup.find(id='alias_anime')['value']\n        animeLastEp = animeSoup.find(id='episode_page').find_all('a')[-1]['ep_end']\n        #------------------------------\n        ajax_url = f'https://ajax.gogocdn.net/ajax/load-list-episode?ep_start=0&ep_end={animeLastEp}&id={animeID}&default_ep=0&alias={animeAlias}'\n        self.dataDict = {}\n        #re.sub('[<>?\":/|]', '', x)\n        self.dataDict['anime-title'] = RegExp.sub('[<>?\":/|]', '', animeSoup.title.text.replace('at Gogoanime', '').replace('Watch ', '').strip())\n        self.dataDict['anime-url'] = url\n        ajaxSoup = BeautifulSoup(requests.get(ajax_url, headers=my_headers).text, 'html.parser')\n        self.episode_count = len(ajaxSoup.find_all('a'))\n        #------------------------------\n        self.dataDict['episodes'] = []\n        for li in reversed(ajaxSoup.find_all('li')):\n        	episodeDict = {}\n        	#re.sub('[<>?\":/|]', '', x)\n        	#episodeDict['episode-title'] = self.dataDict['anime-title'] + ' - ' + ' '.join(li.text.split())\n        	episodeDict['episode-title'] = RegExp.sub('[<>?\":/|]', '', '{} - {}'.format(self.dataDict['anime-title'], ' '.join(li.text.split())))\n        	episodeDict['episode-url'] = 'https://www.gogoanime.io{}'.format(li.find('a')['href'].strip())\n        	self.dataDict['episodes'].append(episodeDict)\n\n    def scrapeEpisodes(self, start=1, end=1):\n    	self.dataDict['scraped-episodes'] = []\n    	for episodeDict in self.dataDict['episodes'][start-1:end]:\n    		scraped_episodeDict = episodeDict\n    		soup = BeautifulSoup(requests.get(episodeDict['episode-url'], headers=my_headers).text, 'html.parser')\n    		serversList = soup.find('div', {'class':'anime_muti_link'}).find_all('li')[1:]\n    		scraped_episodeDict['embed-servers'] = {}\n    		for li in serversList:\n    			embedUrl = li.find('a')['data-video']\n    			if not 'https:' in embedUrl:\n    				embedUrl = f'https:{embedUrl}'\n    			scraped_episodeDict['embed-servers'][li['class'][0]] = embedUrl\n    		#------\n    		self.dataDict['scraped-episodes'].append(scraped_episodeDict)\n    		print('- Collected:', scraped_episodeDict['episode-title'])\n\n    def saveJSON(self, filename='anime.json'):\n    	open(filename, 'w', encoding='utf-8').write(json.dumps(self.dataDict, indent=4, sort_keys=True, ensure_ascii=False))\n\n    # STATIC METHOD\n    def searchAnime(query='anime name'):\n        response_text = requests.get('https://www.gogoanime.io/search.html?keyword={}'.format(query.replace(' ', '%20'))).text\n        p_results = BeautifulSoup(response_text, 'html.parser').find('ul', class_='items').find_all('p', class_='name')[:4]\n        paired_results = [(p.find('a')['title'], 'https://www.gogoanime.io{}'.format(p.find('a')['href'])) for p in p_results]\n        return paired_results # (title, url) pair list is returned\n\ndef main():\n	anime_scraper = AnimeScraper(input('Input Anime URL:  '))\n	anime_scraper.scrapeEpisodes(start=1, end=1)\n	anime_scraper.saveJSON()\n	print('- JSON File Is Saved!')\n\nif __name__ == '__main__':\n    main()");
		textview11.setText("pip install requests\npip install json\npip install os\npip install bs4\npip install re");
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
