# Android Simple Recommendations Row of AndroidTV

![Example](img/simpleCartesianPlotter.gif) 

## Introduction

AndroidTV allows you to communicate through an API to the TV launcher, which allows you to easily access the content of your application without having to enter. This project is a simple interface to facilitate the use of the Row of Android TV Recommendations, trying to show content cards in the launcher of AndroidTV devices making a minimum configuration, I hope it saves you programming time :).

## Install

You can download library files from JCenter or GitHub.

**[LatestVersion is 1.0](https://bintray.com/ederdoski/Maven/simple-launcher-recommendations)**

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
```
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
```

* **In Java**

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
## Aditional Methods

* Set a personalized image bottom for the card.
```
recommendationIntent.putExtra("cardIcon", R.mipmap.ic_launcher);
```

* Set a personalized width for the card.
```
recommendationIntent.putExtra("cardWidth", getResources().getDimensionPixelSize(R.dimen.card_width));
```

* Set a personalized height for the card.
```
recommendationIntent.putExtra("cardWidth", getResources().getDimensionPixelSize(R.dimen.card_height));
```

* Send a string, which you can retrieve when you click on the card
```
recommendationIntent.putExtra("extra", "string_extra");
```

* Send an array of String[], which you can recover by clicking on the card
```
recommendationIntent.putExtra("array-extra", aExtra);
```

* This method obtains the string set on a card when clicking
```
 private String getIntent(Activity act) {
        if(act.getIntent() != null) {
            return act.getIntent().getStringExtra("extra");
        }else{
            return "null";
        }
    }
```

* This method obtains the String [] set on a card when clicking
```
 private String[] getIntentArray(Activity act) {
        if(act.getIntent() != null){
            return act.getIntent().getStringArrayExtra("array-extra");
        }else{
            return new String[0];
        }
    }
```


## References

Recommendations in Android N and earlier | Android Developers](https://developer.android.com/training/tv/discovery/recommendations-row)

## License

This code is open-sourced software licensed under the [MIT license.](https://opensource.org/licenses/MIT)

