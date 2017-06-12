package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.plus.PlusShare;
import java.util.List;

@zzmb
public class zzdo extends zza {
    public static final Creator<zzdo> CREATOR;
    @Nullable
    public final String url;
    public final int version;
    public final String zzyA;
    public final Bundle zzyB;
    public final boolean zzyC;
    public final long zzyx;
    public final String zzyy;
    public final String zzyz;

    static {
        CREATOR = new zzdp();
    }

    zzdo(int i, @Nullable String str, long j, String str2, String str3, String str4, Bundle bundle, boolean z) {
        this.version = i;
        this.url = str;
        this.zzyx = j;
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        this.zzyy = str2;
        if (str3 == null) {
            str3 = BuildConfig.FLAVOR;
        }
        this.zzyz = str3;
        if (str4 == null) {
            str4 = BuildConfig.FLAVOR;
        }
        this.zzyA = str4;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzyB = bundle;
        this.zzyC = z;
    }

    @Nullable
    public static zzdo zzJ(String str) {
        return zze(Uri.parse(str));
    }

    @Nullable
    public static zzdo zze(Uri uri) {
        Throwable e;
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                zzpy.zzbe("Expected 2 path parts for namespace and id, found :" + pathSegments.size());
                return null;
            }
            String str = (String) pathSegments.get(0);
            String str2 = (String) pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter(PlusShare.KEY_CALL_TO_ACTION_URL);
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long parseLong = queryParameter2 == null ? 0 : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            for (String queryParameter22 : zzv.zzcL().zzh(uri)) {
                if (queryParameter22.startsWith("tag.")) {
                    bundle.putString(queryParameter22.substring("tag.".length()), uri.getQueryParameter(queryParameter22));
                }
            }
            return new zzdo(1, queryParameter, parseLong, host, str, str2, bundle, equals);
        } catch (NullPointerException e2) {
            e = e2;
            zzpy.zzc("Unable to parse Uri into cache offering.", e);
            return null;
        } catch (NumberFormatException e3) {
            e = e3;
            zzpy.zzc("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzdp.zza(this, parcel, i);
    }
}
