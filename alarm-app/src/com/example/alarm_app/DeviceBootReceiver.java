package com.example.alarm_app;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
public class DeviceBootReceiver extends BroadcastReceiver {
@Override
public void onReceive(Context arg0, Intent arg1) {
// TODO Auto-generated method stub
if(arg1.getAction().equals("android.intent.action.BOOT _COMPLETED")){Intent alarmintent=new Intent(arg0,AlarmReceiver.class);
PendingIntent pi=PendingIntent.getBroadcast(arg0, 0, alarmintent, 0);
AlarmManager
m=(AlarmManager)arg0.getSystemService(Context.ALARM_SERVICE);
int interval=8000;
m.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pi);
 Toast.makeText(arg0, "ALARM SET", Toast.LENGTH_SHORT).show();
}
}
}