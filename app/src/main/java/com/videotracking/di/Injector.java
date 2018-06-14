package com.videotracking.di;

import android.support.annotation.NonNull;

import com.videotracking.app.App;
import com.videotracking.di.app.component.ApplicationComponent;
import com.videotracking.di.app.component.DaggerApplicationComponent;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public final class Injector {
    private static ApplicationComponent sApplicationComponent;

    private Injector() {}


    public static void init(@NonNull App app) {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .application(app)
                .build();
    }


    @NonNull
    public static ApplicationComponent getApplicationComponent() {
        ensureInitialised();
        return sApplicationComponent;
    }


    private static void ensureInitialised() {
        if (sApplicationComponent == null) {
            throw new IllegalStateException("Call {@link Injector#init()} in application onCreate()");
        }
    }
}
