package com.google.android.gms.instantapps;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;

public class LaunchData extends zza {
    public static final Creator<LaunchData> CREATOR;
    private final Intent intent;
    private final String packageName;
    private final int versionCode;
    private final String zzbhE;
    final BitmapTeleporter zzbhF;
    private final Bitmap zzbhG;

    static {
        CREATOR = new zza();
    }

    LaunchData(int i, Intent intent, String str, String str2, BitmapTeleporter bitmapTeleporter) {
        this.versionCode = i;
        this.intent = intent;
        this.packageName = str;
        this.zzbhE = str2;
        this.zzbhF = bitmapTeleporter;
        this.zzbhG = bitmapTeleporter != null ? bitmapTeleporter.zzwz() : null;
    }

    @Nullable
    public Bitmap getApplicationIcon() {
        return this.zzbhG;
    }

    @Nullable
    public String getApplicationLabel() {
        return this.zzbhE;
    }

    @Nullable
    public Intent getIntent() {
        return this.intent;
    }

    @Nullable
    public String getPackageName() {
        return this.packageName;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
