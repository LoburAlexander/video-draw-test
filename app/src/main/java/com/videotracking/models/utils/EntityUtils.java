package com.videotracking.models.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/18/18.
 */
public final class EntityUtils {
    private EntityUtils() {}

    @NonNull
    public static String toStringField(@NonNull String title, @Nullable Object field, boolean isLast) {
        // Need new builder instance every call because this method can be executed recursively
        StringBuilder builder = new StringBuilder();

        builder.append(title)
                .append(": ")
                .append(field != null ? field.toString() : "null");

        if (!isLast) {
            builder.append(", ");
        }

        return builder.toString();
    }

    public static boolean areEqual(Object obj1, Object obj2) {
        return obj1 == obj2 || (obj1 != null && obj1.equals(obj2));
    }

    public static int hashCode(@Nullable Object value) {
        return value == null ? 0 : value.hashCode();
    }
}
