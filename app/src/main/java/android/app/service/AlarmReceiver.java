package android.app.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.R;
import android.app.activity.HomeActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;


import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static android.app.App.CHANNEL_ID;


public class AlarmReceiver extends BroadcastReceiver {

    private NotificationManagerCompat notificationManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("TAG", "Bao thuc thanh cong");
        notificationManager = NotificationManagerCompat.from(context);

        String title = "Phân tích thiết kế hệ thống";

        Intent activityIntent = new Intent(context, HomeActivity.class);
        String message = "6h45 học rồi, "+ intent.getStringExtra("ghi_chu");

        PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, activityIntent, 0);


        PendingIntent actionIntent = PendingIntent.getBroadcast(context,
                0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.WHITE)
                .setContentIntent(actionIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher, "Xem lịch", contentIntent)
                .build();
        notificationManager.notify(1, notification);

    }
}