package com.tnt_development.speedreading.DI.Component;

import com.tnt_development.speedreading.DI.Module.ApplicationModule;
import com.tnt_development.speedreading.DI.Scope.ApplicationScope;

import dagger.Component;

/**
 * Created by tadejvengust1 on 6. 06. 17.
 */

@ApplicationScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

}
