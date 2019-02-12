# Android Simple Recommendations Row of AndroidTV

![Example](img/simpleCartesianPlotter.gif) 

## Introduction

AndroidTV allows you to communicate through an API to the TV launcher providing easy access to content of your application without having to enter it. This project is a simple interface to facilitate the use of the AndroidTV Recommendations Row, I hope it saves you time of programming :).

## Install

You can download library files from JCenter or GitHub.

**[LatestVersion is 1.0.1](https://bintray.com/ederdoski/Maven/simple-cartesian-plotter)**

Add the following in your app's build.gradle file:

```
repositories {
  jcenter()
}

dependencies {
    
}
```

## Usage

* **In Manifest**

<manifest>
    ...
     <application>
        ....

       <receiver
            android:name=".RecommendationReceiver"
            android:enabled="true"
            android:exported="false">
            <intent-filter>
                <action android:name="android.intent.action.BOOT_COMPLETED" />
            </intent-filter>
        </receiver>

        <service
            android:name=".UpdateRecommendationsService"
            android:enabled="true" />

    </application>

</manifest>

* **In Java**


        ArrayList<LauncherRecommended> aVideo = new ArrayList<>();

        aVideo.add(new LauncherRecommended("1111", "OPEN HERE", "DESCRIPTION PRUEBA", "https://e.radio-studio92.io/normal/2018/05/15/080108_610158.jpg"));

        Intent recommendationIntent = new Intent(this, UpdateRecommendationsService.class);
        recommendationIntent.putParcelableArrayListExtra("LauncherRecommended", aVideo);
        recommendationIntent.putExtra("cardIcon", R.mipmap.ic_launcher);
        recommendationIntent.putExtra("cardWidth", getResources().getDimensionPixelSize(R.dimen.card_width));
        recommendationIntent.putExtra("cardHeight", getResources().getDimensionPixelSize(R.dimen.card_height));
        recommendationIntent.putExtra("toClass", MainActivity.class);
        startService(recommendationIntent);


1) Create and insert data into an ArrayList where you will place the content you want to display in the Launcher.

```
   ArrayList<LauncherRecommended> aRecommendedContent = new ArrayList<>();
   aRecommendedContent.add(new LauncherRecommended("INSERT_ID", "INSERT_TITLE", "INSERT_DESCRIPTION", "INSERT_URL_IMG"));
```

2) Create an intent that references the UpdateRecommendationsService and sends the previously created ArrayList by parameters, additionally add the name of a class to which you want to redirect the user when you click on the card.

```
    Intent recommendationIntent = new Intent(this, UpdateRecommendationsService.class);
        recommendationIntent.putParcelableArrayListExtra("LauncherRecommended", aRecommendedContent);
        recommendationIntent.putExtra("toClass", MainActivity.class);
        startService(recommendationIntent);
```
## Adtional Methods


## References

Recommendations in Android N and earlier | Android Developers](https://developer.android.com/training/tv/discovery/recommendations-row)

## License

This code is open-sourced software licensed under the [MIT license.](https://opensource.org/licenses/MIT)

