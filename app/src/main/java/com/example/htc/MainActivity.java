package com.example.htc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jason.mytestapp.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//			writeToSD();
			MyHttpClient.connect("");
	}

	private void writeToSD()   {
		File sd = Environment.getExternalStorageDirectory();
		// /sdcard
		if (sd.canWrite()) {
			String logFileName = "mylog.log";
			try{
				BufferedWriter out = new BufferedWriter(new FileWriter(sd.getPath().
						concat(File.separator).concat(logFileName),true));
				out.append("test " + Calendar.getInstance().getTime());
				out.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
