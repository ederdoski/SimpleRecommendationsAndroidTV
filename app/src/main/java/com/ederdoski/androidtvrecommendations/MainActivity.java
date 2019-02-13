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
        ArrayList<LauncherRecommended> aVideo = new ArrayList<>();

        aVideo.add(new LauncherRecommended("1", "Titulo de Prueba  1", "Descripcion Prueba 1 ", "http://lorempixel.com/350/210/"));
        aVideo.add(new LauncherRecommended("2", "Titulo de Prueba  2", "Descripcion Prueba 2 ", "http://lorempixel.com/350/220/"));
        aVideo.add(new LauncherRecommended("3", "Titulo de Prueba  3", "Descripcion Prueba 3 ", "http://lorempixel.com/350/230/"));

        Intent recommendationIntent = new Intent(this, UpdateRecommendationsService.class);
        recommendationIntent.putParcelableArrayListExtra("LauncherRecommended", aVideo);
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
