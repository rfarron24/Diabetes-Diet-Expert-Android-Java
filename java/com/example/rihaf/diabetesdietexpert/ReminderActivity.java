 package com.example.rihaf.diabetesdietexpert;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

 public class ReminderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        findViewById(R.id.sarapanbtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,7);
                calendar.set(Calendar.MINUTE,30);
                calendar.set(Calendar.SECOND,1);


                Intent intent = new Intent(getApplicationContext(),Notification_reciever.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);

                Toast.makeText(ReminderActivity.this,"Pengingat Sarapan Anda Telah Diaktifkan", Toast.LENGTH_LONG).show();

            }



        });


        findViewById(R.id.lunchbtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,12);
                calendar.set(Calendar.MINUTE,10);
                calendar.set(Calendar.SECOND,1);


                Intent intent = new Intent(getApplicationContext(),Notification_reciever2.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),200,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);

                Toast.makeText(ReminderActivity.this,"Pengingat Makan Siang Anda Telah Diaktifkan", Toast.LENGTH_LONG).show();


            }



        });



        findViewById(R.id.dinnerbtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,18);
                calendar.set(Calendar.MINUTE,10);
                calendar.set(Calendar.SECOND,1);


                Intent intent = new Intent(getApplicationContext(),Notification_reciever3.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),300,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);

                Toast.makeText(ReminderActivity.this,"Pengingat Makan Malam Anda Telah Diaktifkan", Toast.LENGTH_LONG).show();


            }



        });
    }
}
