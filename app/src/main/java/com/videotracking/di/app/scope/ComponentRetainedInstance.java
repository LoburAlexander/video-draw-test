package com.videotracking.di.app.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Marker qualifier for objects that are retained during Android component lifecycle.<br/><br/>
 *
 * For example, ViewModel instances, that are retained between recreated activity instances.
 *
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ComponentRetainedInstance {
}
