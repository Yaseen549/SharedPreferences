package com.saya.webview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends Activity {
	
	NumberPicker np;
	Button btn;
	WebView wv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String[] array = { "MyPage", "Google", "Bing", "Yahoo" };
		np = (NumberPicker) findViewById(R.id.numberPicker1);
		np.setDisplayedValues(array);
		np.setMinValue(0);
		np.setMaxValue(array.length-1);
		
		wv = (WebView) findViewById(R.id.webView1);
		btn =(Button) findViewById(R.id.button1);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				int choice = np.getValue();
				if(choice == 0)
					wv.loadUrl("file:///android_asset/mypage.html");
				else if(choice == 1) {
					
					wv.setWebViewClient(new WebViewClient());
					wv.loadUrl("https://www.google.com");
					
				}
				else if(choice == 2)
					wv.loadUrl("https://www.bing.com");
				else if(choice == 3)
					wv.loadUrl("https://www.yahoo.com");
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
