package net.gavinpower.Utilities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import net.gavinpower.twangr.Activities.ChatActivity;
import net.gavinpower.twangr.Activities.FriendsListActivity;
import net.gavinpower.twangr.R;

@SuppressWarnings("unused")
public class Notifications
{
    public static class FriendRequestAccepted extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            Bundle extras = intent.getExtras();
            String newFriend  = extras.getString("UserName");

            Intent notificationIntent = new Intent(context, FriendsListActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);
            NotificationCompat.Builder noteBuild = new NotificationCompat.Builder(context);
            noteBuild.setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("New Friend Request!")
                    .setContentText(newFriend + " wants to be your friend!")
                    .setContentIntent(contentIntent);

            NotificationManager noteManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            noteManager.notify(0, noteBuild.build());

            try {
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone r = RingtoneManager.getRingtone(context, notification);
                r.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class NewFriendRequest extends BroadcastReceiver
    {

        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            String newFriend = extras.getString("UserName");

            Intent notificationIntent = new Intent(context, FriendsListActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);
            NotificationCompat.Builder noteBuild = new NotificationCompat.Builder(context);
            noteBuild.setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("New Friend Request!")
                    .setContentText(newFriend + " wants to be your friend!")
                    .setContentIntent(contentIntent);

            NotificationManager noteManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            noteManager.notify(0, noteBuild.build());

            try {
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone r = RingtoneManager.getRingtone(context, notification);
                r.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class MessageRecieved extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            String chatId = extras.getString("ChatID");
            String sender = extras.getString("UserName");
            String message = extras.getString("MessageContent");

            Intent notificationIntent = new Intent(context, ChatActivity.class);
            notificationIntent.putExtras(extras);
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);
            NotificationCompat.Builder noteBuild = new NotificationCompat.Builder(context);
            noteBuild.setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Message from " + sender)
                    .setContentText(message)
                    .setContentIntent(contentIntent);

            NotificationManager noteManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            noteManager.notify(0, noteBuild.build());

            try {
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone r = RingtoneManager.getRingtone(context, notification);
                r.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

