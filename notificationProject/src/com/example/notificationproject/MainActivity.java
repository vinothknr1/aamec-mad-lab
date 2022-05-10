package com.example.notificationproject;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Context;
import android.content.Intent;
import android.app.PendingIntent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bt=(Button)findViewById(R.id.button1);
		bt.setOnClickListener(new OnClickListener() 
		{
		public void onClick(View argo)
			{
			NotificationManager
			nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
			Notification notification = new Notification(android.R.drawable.stat_notify_more,"you have a got a new Message",System.currentTimeMillis());
			Context context=MainActivity.this;
			Intent intent=new Intent(context,MainActivity.class);
			PendingIntent pending=PendingIntent.getActivity(getApplicationContext(),0,intent,0);
			notification.setLatestEventInfo(context, "email from FB","you have a new friend request",null);
			nm.notify(0,notification);
			}
		});
	}}

	

