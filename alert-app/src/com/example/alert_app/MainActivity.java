package com.example.alert_app;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
public class MainActivity extends Activity {
public Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		click();
		}
	private void click() {
		// TODO Auto-generated method stub
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setCancelable(false);
				builder.setTitle("ALERT");
				builder.setMessage("Do you want to exit?");
				builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
					finish();
				}
				});
			builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
						arg0.cancel();		}});
					builder.show(); 
					}});
				}
			@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
