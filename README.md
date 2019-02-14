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
            android:name="com.ederdoski.launcherRecommendations.recommendations.RecommendationReceiver"
            android:enabled="true"
            android:exported="false">
            <intent-filter>
                <action android:name="android.intent.action.BOOT_COMPLETED" />
            </intent-filter>
        </receiver>

        <service
            android:name="com.ederdoski.launcherRecommendations.recommendations.UpdateRecommendationsService"
            android:enabled="true" />

    </application>

</manifest>
```

* **In Java**

1) Create and insert data into an ArrayList where you will place the content you want to display in the Launcher,
For your comfort there are 3 different constructors, use the one that best suits your needs.

![Warning](img/warning.png) **the ID field should only contain numbers** ![Warning](img/warning.png)

* Constructor 1: It's the simplest one just needs a series of basic data to work.
```
   ArrayList<LauncherRecommended> aRecommendedContent = new ArrayList<>();
   aRecommendedContent.add(new LauncherRecommended("INSERT_ID_ONLY_NUMBER", "INSERT_TITLE", "INSERT_DESCRIPTION", "INSERT_URL_IMG"));

```

* Constructor 2: You can add an Extra String parameter, and then obtain it when the user presses the corresponding card.
```
   ArrayList<LauncherRecommended> aRecommendedContent = new ArrayList<>();
   aRecommendedContent.add(new LauncherRecommended("INSERT_ID_ONLY_NUMBER", "INSERT_TITLE", "INSERT_DESCRIPTION", "INSERT_URL_IMG", "RANDOM_STRING_EXTRA"));
```


* Constructor 3: You can add an extra String parameter and an extra ArrayList <String>, designed to handle a larger amount of data, and then obtain it when the user presses the corresponding card.
```
   ArrayList<LauncherRecommended> aRecommendedContent = new ArrayList<>();
   aRecommendedContent.add(new LauncherRecommended("INSERT_ID_ONLY_NUMBER", "INSERT_TITLE", "INSERT_DESCRIPTION", "INSERT_URL_IMG", "RANDOM_STRING_EXTRA", "ARRAY_LIST_EXTRA_STRING"));
```

2) Create an intent that references the UpdateRecommendationsService and sends the previously created ArrayList by parameters, additionally add the name of a class to which you want to redirect the user when you click on the card.

```
    Intent recommendationIntent = new Intent(this, UpdateRecommendationsService.class);
        recommendationIntent.putExtra("LauncherRecommended", aRecommendedContent);
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

* This method obtains the string set on a card when clicking.
```
  private String getIntent(Activity act, String field) {
        if(act.getIntent() != null) {
            return act.getIntent().getStringExtra(field);
        }else{
            return Constants.NULL;
        }
    }
```

* This method obtains the ArrayList<String> set on a card when clicking.
  
```
 private ArrayList<String> getIntentArrayList(Activity act, String field) {
        if(act.getIntent() != null){
            return (ArrayList<String>) act.getIntent().getSerializableExtra(field);
        }else{
            return new ArrayList<>();
        }
    }
```

## NOTE: 

* To retrieve the extra String parameter, you must use the key: recommendation_extra
* To retrieve the ArrayList <String> extra parameter, you must use the key: recommendation_array_extra

## References

[Recommendations in Android N and earlier | Android Developers](https://developer.android.com/training/tv/discovery/recommendations-row)

## License

This code is open-sourced software licensed under the [MIT license.](https://opensource.org/licenses/MIT)

