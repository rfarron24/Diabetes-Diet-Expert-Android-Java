package com.example.rihaf.diabetesdietexpert;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by rihaf on 12/30/2016.
 */
public class Notification_reciever3 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);

        Intent repeating_intent = new Intent(context,dietplan2Activity.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,300,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.dietexpert)
                .setContentTitle("Pengingat Makan Malam")
                .setContentText("Update jurnal makan malam anda")
                .setAutoCancel(true);

        notificationManager.notify(300,builder.build());

    }
}
