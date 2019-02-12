package com.ederdoski.launcherRecommendations.recommendations;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.ederdoski.launcherRecommendations.R;
import com.ederdoski.launcherRecommendations.models.LauncherRecommended;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import androidx.recommendation.app.ContentRecommendation;

public class UpdateRecommendationsService extends IntentService {

    private static final String TAG = "RecommendationService";
    private NotificationManager mNotifManager;

    public UpdateRecommendationsService() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (mNotifManager == null) {
            mNotifManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        ArrayList<LauncherRecommended> aRecommended;

        Resources res   = getResources();
        int icon        = intent.getIntExtra("cardIcon", R.mipmap.ic_launcher);
        int cardWidth   = intent.getIntExtra("cardWidth", res.getDimensionPixelSize(R.dimen.card_width));
        int cardHeight  = intent.getIntExtra("cardHeight", res.getDimensionPixelSize(R.dimen.card_height));
        aRecommended    = intent.getParcelableArrayListExtra("LauncherRecommended");
        ContentRecommendation.Builder builder = new ContentRecommendation.Builder().setBadgeIcon(icon);

        try {

            for(int i = 0; i < aRecommended.size(); i++) {

                LauncherRecommended video = aRecommended.get(i);

                int id = Long.valueOf(video.getId()).hashCode();

                builder.setIdTag("video" + id)
                        .setTitle(video.getTitle())
                        .setText(video.getDescription());

                        //.setContentIntentData(ContentRecommendation.INTENT_TYPE_ACTIVITY, buildPendingIntent(video, toClass, id), 0, null);

                Bitmap bitmap = Glide.with(getApplication())
                        .asBitmap()
                        .load(video.getImageUrl())
                        .submit(cardWidth, cardHeight)
                        .get();

                builder.setContentImage(bitmap);

                ContentRecommendation rec = builder.build();
                Notification notification = rec.getNotificationObject(getApplicationContext());

                mNotifManager.notify(id, notification);
            }

        } catch (InterruptedException | ExecutionException e) {
            Log.e(TAG, "Could not create recommendation.", e);
        }
    }

    private Intent buildPendingIntent(LauncherRecommended video, Class toClass, int id) {
        //Intent detailsIntent = new Intent(this, VideoDetailsActivity.class);
        Intent detailsIntent = new Intent(this, toClass);
        //detailsIntent.putExtra(MainActivity.VIDEO, video);
        //detailsIntent.putExtra(VideoDetailsActivity.NOTIFICATION_ID, id);
        detailsIntent.setAction(video.getId());

        return detailsIntent;
    }
}
