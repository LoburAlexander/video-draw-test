package com.videotracking.platform.binding.utils;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.Nullable;

import by.mvvmwrapper.wrapper.BindableGeneric;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public final class ObservableUtils {
    private ObservableUtils() {}


    public static <T> T getValue(@Nullable ObservableField<T> observable) {
        return observable != null ? observable.get() : null;
    }

    public static <T> T getValue(@Nullable BindableGeneric<T> bindable) {
        return bindable != null ? bindable.getValue() : null;
    }

    public static int getValue(@Nullable ObservableInt observable) {
        return observable != null ? observable.get() : 0;
    }

    public static boolean getValue(@Nullable ObservableBoolean observable) {
        return observable != null && observable.get();
    }


    public static <T> void setValue(@Nullable ObservableField<T> observable, @Nullable T value) {
        if(observable != null) {
            observable.set(value);
        }
    }

    public static <T> void setValue(@Nullable BindableGeneric<T> bindable, @Nullable T value) {
        if(bindable != null) {
            bindable.set(value);
        }
    }

    public static void setValue(@Nullable ObservableInt observable, int value) {
        if(observable != null) {
            observable.set(value);
        }
    }

    public static void setValue(@Nullable ObservableBoolean observable, boolean value) {
        if(observable != null) {
            observable.set(value);
        }
    }
}
