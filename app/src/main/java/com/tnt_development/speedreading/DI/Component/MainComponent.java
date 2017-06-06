package com.tnt_development.speedreading.DI.Component;

import com.tnt_development.speedreading.DI.Module.MainModule;
import com.tnt_development.speedreading.DI.Scope.ActivityScope;
import com.tnt_development.speedreading.Modules.Main.MainActivity;
import com.tnt_development.speedreading.Util.Sprintz;
import com.tnt_development.speedreading.Util.TextParser;

import dagger.Component;

/**
 * Created by tadejvengust1 on 6. 06. 17.
 */

@ActivityScope
@Component(modules = MainModule.class)
public interface MainComponent {
    void injectMainActivity(MainActivity activity);

    TextParser getTextParser();

    Sprintz getSprintz();
}
