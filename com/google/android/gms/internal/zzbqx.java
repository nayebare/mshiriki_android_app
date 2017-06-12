package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.internal.zzac;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class zzbqx {
    @NonNull
    public static String zzjJ(@Nullable String str) throws UnsupportedEncodingException {
        return TextUtils.isEmpty(str) ? BuildConfig.FLAVOR : zzjK(URLEncoder.encode(str, "UTF8"));
    }

    @NonNull
    public static String zzjK(@NonNull String str) {
        zzac.zzw(str);
        return str.replace("%2F", "/");
    }

    @NonNull
    public static String zzjL(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return BuildConfig.FLAVOR;
        }
        if (!str.startsWith("/") && !str.endsWith("/") && !str.contains("//")) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : str.split("/")) {
            if (!TextUtils.isEmpty(str2)) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("/").append(str2);
                } else {
                    stringBuilder.append(str2);
                }
            }
        }
        return stringBuilder.toString();
    }
}
