package com.ederdoski.androidtvrecommendations;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ederdoski.launcherRecommendations.models.LauncherRecommended;
import com.ederdoski.launcherRecommendations.recommendations.UpdateRecommendationsService;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateListOfRecommendedForAndroidTV();
        listenerClickOfRecommendations();
    }

    private void updateListOfRecommendedForAndroidTV(){

        ArrayList<String> aExtra = new ArrayList<>(Arrays.asList("ARRAY_ITEM_EXTRA", "ARRAY_ITEM_EXTRA_2"));
        ArrayList<LauncherRecommended> aLauncherRecommended = new ArrayList<>();

        aLauncherRecommended.add(new LauncherRecommended("1", "Recommended 1", "DESCRIPTION 1", "https://loremflickr.com/320/240"));
        aLauncherRecommended.add(new LauncherRecommended("2", "Recommended 2", "DESCRIPTION 2", "https://loremflickr.com/320/250", "ITEM_EXTRA"));
        aLauncherRecommended.add(new LauncherRecommended("3", "Recommended 3", "DESCRIPTION 3", "https://loremflickr.com/320/260", "ITEM_EXTRA 2",  aExtra));

        Intent recommendationIntent = new Intent(this, UpdateRecommendationsService.class);
        recommendationIntent.putExtra("LauncherRecommended", aLauncherRecommended);
        recommendationIntent.putExtra("cardIcon", R.mipmap.ic_launcher);
        recommendationIntent.putExtra("cardWidth", getResources().getDimensionPixelSize(R.dimen.card_width));
        recommendationIntent.putExtra("cardHeight", getResources().getDimensionPixelSize(R.dimen.card_height));
        recommendationIntent.putExtra("toClass", MainActivity.class);
        startService(recommendationIntent);
    }

    private void listenerClickOfRecommendations() {

        if (getIntent(this, Constants.RECOM_EXTRA) != null) {
            if (!getIntent(this, Constants.RECOM_EXTRA).equals(Constants.NULL)) {
                Log.d("MainActivity: extra = ", getIntent(MainActivity.this, Constants.RECOM_EXTRA));
            }
        }

        if (getIntentArrayList(this, Constants.RECOM_ARRAY_EXTRA) != null) {
            if (getIntentArrayList(this, Constants.RECOM_ARRAY_EXTRA).size() > 0) {
                Log.d("MainActivity: array = ", getIntentArrayList(MainActivity.this, Constants.RECOM_ARRAY_EXTRA).toString());
            }
        }
    }


    private String getIntent(Activity act, String field) {
        if(act.getIntent() != null) {
            return act.getIntent().getStringExtra(field);
        }else{
            return Constants.NULL;
        }
    }

    private ArrayList<String> getIntentArrayList(Activity act, String field) {
        if(act.getIntent() != null){
            return (ArrayList<String>) act.getIntent().getSerializableExtra(field);
        }else{
            return new ArrayList<>();
        }
    }

}
