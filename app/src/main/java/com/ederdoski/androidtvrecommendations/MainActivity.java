package com.ederdoski.androidtvrecommendations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ederdoski.launcherRecommendations.models.LauncherRecommended;
import com.ederdoski.launcherRecommendations.recommendations.UpdateRecommendationsService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         String[] aExtra = {"extra_1", "extra_2", "extra_3"};
        ArrayList<LauncherRecommended> aLauncherRecommended = new ArrayList<>();

        aLauncherRecommended.add(new LauncherRecommended("1", "Recommended 1", "DESCRIPTION 1", "https://loremflickr.com/320/240"));
        aLauncherRecommended.add(new LauncherRecommended("2", "Recommended 2", "DESCRIPTION 2", "https://loremflickr.com/320/250"));
        aLauncherRecommended.add(new LauncherRecommended("3", "Recommended 3", "DESCRIPTION 3", "https://loremflickr.com/320/260"));
        aLauncherRecommended.add(new LauncherRecommended("4", "Recommended 4", "DESCRIPTION 4", "https://loremflickr.com/320/270"));
        aLauncherRecommended.add(new LauncherRecommended("5", "Recommended 5", "DESCRIPTION 5", "https://loremflickr.com/320/280"));
        aLauncherRecommended.add(new LauncherRecommended("6", "Recommended 6", "DESCRIPTION 6", "https://loremflickr.com/320/290"));
        aLauncherRecommended.add(new LauncherRecommended("7", "Recommended 7", "DESCRIPTION 7", "https://loremflickr.com/320/210"));
        aLauncherRecommended.add(new LauncherRecommended("8", "Recommended 8", "DESCRIPTION 8", "https://loremflickr.com/320/220"));


        Intent recommendationIntent = new Intent(this, UpdateRecommendationsService.class);
        recommendationIntent.putParcelableArrayListExtra("LauncherRecommended", aLauncherRecommended);
        recommendationIntent.putExtra("cardIcon", R.mipmap.ic_launcher);
        recommendationIntent.putExtra("cardWidth", getResources().getDimensionPixelSize(R.dimen.card_width));
        recommendationIntent.putExtra("cardHeight", getResources().getDimensionPixelSize(R.dimen.card_height));
        recommendationIntent.putExtra("extra", "string_extra");
        recommendationIntent.putExtra("array-extra", aExtra);
        recommendationIntent.putExtra("toClass", MainActivity.class);
        startService(recommendationIntent);

    }

    private String getIntent(Activity act) {
        if(act.getIntent() != null) {
            return act.getIntent().getStringExtra("extra");
        }else{
            return "null";
        }
    }

    private String[] getIntentArray(Activity act) {
        if(act.getIntent() != null){
            return act.getIntent().getStringArrayExtra("array-extra");
        }else{
            return new String[0];
        }
    }

}
