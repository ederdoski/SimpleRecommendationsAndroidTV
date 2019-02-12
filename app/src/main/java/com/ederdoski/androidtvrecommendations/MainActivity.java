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

        ArrayList<LauncherRecommended> aVideo = new ArrayList<>();

        aVideo.add(new LauncherRecommended("1", "Titulo de Prueba  1", "Descripcion Prueba 1 ", "http://lorempixel.com/350/210/"));
        aVideo.add(new LauncherRecommended("2", "Titulo de Prueba  2", "Descripcion Prueba 2 ", "http://lorempixel.com/350/220/"));
        aVideo.add(new LauncherRecommended("3", "Titulo de Prueba  3", "Descripcion Prueba 3 ", "http://lorempixel.com/350/230/"));


        Intent recommendationIntent = new Intent(this, UpdateRecommendationsService.class);
        recommendationIntent.putExtra("cardIcon", com.ederdoski.launcherRecommendations.R.mipmap.ic_launcher);
        recommendationIntent.putExtra("cardWidth", getResources().getDimensionPixelSize(com.ederdoski.launcherRecommendations.R.dimen.card_width));
        recommendationIntent.putExtra("cardHeight", getResources().getDimensionPixelSize(com.ederdoski.launcherRecommendations.R.dimen.card_height));
        recommendationIntent.putParcelableArrayListExtra("LauncherRecommended", aVideo);
        startService(recommendationIntent);
    }
}
