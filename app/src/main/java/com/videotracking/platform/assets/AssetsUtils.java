package com.videotracking.platform.assets;

import android.net.Uri;
import android.support.annotation.NonNull;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public final class AssetsUtils {
    private final static String ASSETS_FILE_SCHEME = "asset://";

    private AssetsUtils() {}


    @NonNull
    public static Uri getAssetsUri(@NonNull String filePath) {
        return Uri.parse(ASSETS_FILE_SCHEME + filePath);
    }
}
