package com.tnt_development.speedreading.DI.Module;

import com.tnt_development.speedreading.DI.Scope.ActivityScope;
import com.tnt_development.speedreading.Modules.Main.MainView;
import com.tnt_development.speedreading.Util.Sprintz;
import com.tnt_development.speedreading.Util.TextParser;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tadejvengust1 on 6. 06. 17.
 */

@ActivityScope
@Module
public class MainModule {
    MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }


    @Provides
    @ActivityScope
    MainView mainView() {
        return view;
    }

    @Provides
    @ActivityScope
    Sprintz sprintz(){
        return new Sprintz();
    }

    @Provides
    @ActivityScope
    TextParser textParser(){
        return new TextParser();
    }
}
