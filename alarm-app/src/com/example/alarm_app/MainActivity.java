package com.example.alarm_app;

import java.util.Calendar;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
public class MainActivity extends Activity {
private PendingIntent pendingintent;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
Intent alarmIntent=new Intent(MainActivity.this,AlarmReceiver.class);
pendingintent =PendingIntent.getBroadcast(MainActivity.this,0,alarmIntent,0);
findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {@Override
public void onClick(View arg0) {
// TODO Auto-generated method stub
start();
}
});
findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View arg0) {
// TODO Auto-generated method stub
cancel();
}
});
 findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View arg0) {
// TODO Auto-generated method stub
startAt10();
}
});
}
public void start()
 {
 AlarmManager m=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
int interval=8000;
 m.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingintent);
 Toast.makeText(this, "ALARM SET", Toast.LENGTH_SHORT).show();
 }
public void cancel()
 {
 AlarmManager m=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
 m.cancel(pendingintent);
 Toast.makeText(this, "ALARM CANCELLED",Toast.LENGTH_SHORT).show();
 }
public void startAt10()
 {
 AlarmManager m=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
int interval=1000*60*20;
 Calendar cal=Calendar.getInstance();
 cal.setTimeInMillis(System.currentTimeMillis());
 cal.set(Calendar.HOUR_OF_DAY, 10);
 cal.set(Calendar.MINUTE, 30);
 m.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 1000*60*20,
pendingintent);
 }
@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.main, menu);
return true;
}
}
