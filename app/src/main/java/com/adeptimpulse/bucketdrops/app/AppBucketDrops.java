package com.adeptimpulse.bucketdrops.app;

import android.app.Application;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Michael Van Dusen on 4/12/2016.
 */
public class AppBucketDrops extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration configuration = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(configuration);
    }

}
