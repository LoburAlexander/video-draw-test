package com.videotracking.di.app.component;

import android.support.annotation.NonNull;

import com.videotracking.platform.binding.component.BindingComponentBuilder;

import dagger.Subcomponent;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
@Subcomponent()
public interface DataBindingComponent extends android.databinding.DataBindingComponent {
    @Subcomponent.Builder
    interface Builder extends BindingComponentBuilder {
        @NonNull
        DataBindingComponent build();
    }
}
