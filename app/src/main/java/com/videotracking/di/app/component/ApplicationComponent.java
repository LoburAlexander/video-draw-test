package com.videotracking.di.app.component;

import android.app.Application;

import com.videotracking.app.App;
import com.videotracking.di.app.module.ActivityModule;
import com.videotracking.di.app.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
@Singleton
@Component( modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityModule.class,
})
public interface ApplicationComponent {
    void inject(App app);


    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}
