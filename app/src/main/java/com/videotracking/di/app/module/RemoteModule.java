package com.videotracking.di.app.module;

import android.support.annotation.NonNull;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/18/18.
 */
@Module
public abstract class RemoteModule {

    @NonNull
    @Provides
    @Singleton
    static Gson provideGson(@NonNull GsonBuilder builder) {
        return builder.create();
    }

    @NonNull
    @Provides
    @Singleton
    static GsonBuilder provideGsonBuilder() {
        return new GsonBuilder()
                .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    }

}
