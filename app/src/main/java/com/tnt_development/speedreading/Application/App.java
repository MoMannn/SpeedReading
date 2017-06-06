package com.tnt_development.speedreading.Application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.tnt_development.speedreading.DI.Component.ApplicationComponent;
import com.tnt_development.speedreading.DI.Component.DaggerApplicationComponent;

/**
 * Created by tadejvengust1 on 6. 06. 17.
 */

public class App extends Application {

    ApplicationComponent component;
    static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder().build();
        context = getApplicationContext();
    }

    public static App get (Activity activity)
    {
        return (App)activity.getApplication();
    }

    public ApplicationComponent component() {
        return component;
    }

    public static Context context(){
        return context;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
