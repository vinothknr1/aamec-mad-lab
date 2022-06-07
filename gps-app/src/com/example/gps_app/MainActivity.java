package com.example.gps_app;

import p1.GPStrace;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button; 
import android.widget.Toast;

public class MainActivity extends Activity {
	Button btnShowLocation;
	GPStrace gps;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnShowLocation=(Button)findViewById(R.id.btn1);
		btnShowLocation.setOnClickListener(new View.OnClickListener() {
			
		public void onClick(View v) {
			// TODO Auto-generated method stub
			gps=new GPStrace(MainActivity.this);
			if(gps.canGetLocation()){
			double latitude=gps.getLatitude();
			double longitude=gps.getLongtiude();
			Toast.makeText(getApplicationContext(),"Your Location is\nLat:"+latitude+"\nLong:"+longitude, Toast.LENGTH_LONG).show();
	            
		}
		else
		{
		gps.showSettingAlert();
		}
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
