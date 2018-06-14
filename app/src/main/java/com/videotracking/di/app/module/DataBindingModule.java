package com.videotracking.di.app.module;

import android.support.annotation.NonNull;

import com.videotracking.di.app.component.DataBindingComponent;
import com.videotracking.platform.binding.component.BindingComponentBuilder;

import dagger.Binds;
import dagger.Module;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
@Module(subcomponents = {
        DataBindingComponent.class
})
public abstract class DataBindingModule {
    @Binds
    abstract BindingComponentBuilder bindComponentBuilder(@NonNull DataBindingComponent.Builder builder);
}
