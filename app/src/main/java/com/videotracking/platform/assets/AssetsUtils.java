package com.videotracking.platform.assets;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;

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

    @NonNull
    public static String readTextFileFromAssets(@NonNull Context context, @NonNull String filePath) {
        StringBuilder result = new StringBuilder();

        BufferedReader reader = null;
        try {
            String line;
            reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filePath)));

            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Ignore
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }

        return result.toString();
    }
}
