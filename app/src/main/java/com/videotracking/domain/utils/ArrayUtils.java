package com.videotracking.domain.utils;

import android.support.annotation.Nullable;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/18/18.
 */
public final class ArrayUtils {
    private ArrayUtils() {}


    public static <T> boolean containsIndex(T[] array, int index) {
        return array != null && (index >= 0 && index < array.length);
    }

    public static boolean containsIndex(float[] array, int index) {
        return array != null && (index >= 0 && index < array.length);
    }
}
