package com.saya.sharedpreferences;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText et1, et2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et1 = (EditText) findViewById(R.id.editText1);	
		et2 = (EditText) findViewById(R.id.editText2);
		
		
		SharedPreferences sp = getSharedPreferences("MYPREFS", 0);
		
		et1.setText(sp.getString("name", ""));
		et2.setText(sp.getString("email", ""));
		
		
	}

	@Override
	protected void onStop() {
		
		super.onStop();
		
		SharedPreferences sp = getSharedPreferences("MYPREFS", 0);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString("name", et1.getText().toString());
		editor.putString("email", et2.getText().toString());
		editor.commit();
		
		
	}

}
