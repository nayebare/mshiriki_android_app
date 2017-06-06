package com.xpwallet.mobileshiriki.firebaseclasses;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.xpwallet.mobileshiriki.Activities.LoginScreen;
import com.xpwallet.mobileshiriki.Activities.MainActivity;
import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.commonbasisclasses.Constant;
import com.xpwallet.mobileshiriki.commonbasisclasses.SharedPrefrences;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by arjun on 18/01/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
    Intent intent;
    public static int Notification_id = 0;
    SharedPrefrences sharedPrefrences;
    Context context;
    static ArrayList<String> notifications = new ArrayList<>();

    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {


        sharedPrefrences = new SharedPrefrences(this);

        //.....................send notification................//
        sendNotification(remoteMessage.getData());


    }

    private void sendNotification(Map<String, String> data) {

        //.....................get data from notification................//

        Constant.Notification_title = data.get("title");
        Constant.Notification_count = data.get("count");
        Constant.Notification_type = data.get("type");
        Constant.Notification_login_id = data.get("user_id");
        Constant.Notification_count1 = Integer.parseInt(Constant.Notification_count);
        Constant.Notification_count2 = Integer.parseInt(Constant.Notification_count);

        //.....................on notification click action................//
        if (SharedPrefrences.get_user_id().equals("")) {
            intent = new Intent(this, LoginScreen.class);
        } else {
            intent = new Intent(this, MainActivity.class);
        }

        //.....................set the notification alert................//

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.app_icon)
                .setContentTitle("MShiriki")
                .setStyle(new NotificationCompat.BigTextStyle().bigText(Constant.Notification_title))
                .setContentText(Constant.Notification_title)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationCompat.InboxStyle inboxStyle =
                new NotificationCompat.InboxStyle();
        // Sets a title for the Inbox in expanded layout
        inboxStyle.setBuilder(notificationBuilder);

        if (notifications.size() == 0) {

        } else {
            inboxStyle.setSummaryText("You have " + notifications.size() + "more Notifications.");
        }

        // Moves events into the expanded layout
        notifications.add(Constant.Notification_title);

        for (int i = 0; i < notifications.size(); i++) {
            inboxStyle.addLine(notifications.get(i));
        }
//        // Moves the expanded layout object into the notification object.
        notificationBuilder.setStyle(inboxStyle);
//

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());

    }
}