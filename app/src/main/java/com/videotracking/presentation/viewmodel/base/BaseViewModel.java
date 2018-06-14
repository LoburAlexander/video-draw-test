package com.videotracking.presentation.viewmodel.base;

import android.support.annotation.NonNull;

import by.mvvmwrapper.viewdata.ViewData;
import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import dagger.MembersInjector;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public abstract class BaseViewModel<TViewData extends ViewData>
        extends SimpleViewModelImpl<TViewData> {
    public BaseViewModel() {
        super();
    }

    public BaseViewModel(@NonNull TViewData viewData) {
        super(viewData);
    }

    @SuppressWarnings({"unchecked", "RawUseOfParameterizedType"})
    public BaseViewModel(@NonNull TViewData viewData, @NonNull MembersInjector injector) {
        this(viewData);
        injector.injectMembers(this);
    }
}