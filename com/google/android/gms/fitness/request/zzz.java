package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzaod;
import java.util.Locale;

public class zzz extends zza {
    public static final Creator<zzz> CREATOR;
    private final int versionCode;
    private final zzaod zzaVu;

    static {
        CREATOR = new zzaa();
    }

    zzz(int i, IBinder iBinder) {
        this.versionCode = i;
        this.zzaVu = zzaod.zza.zzcu(iBinder);
    }

    public IBinder getCallbackBinder() {
        return this.zzaVu.asBinder();
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "GetFileUriRequest {%d, %s}", new Object[]{Integer.valueOf(this.versionCode), this.zzaVu});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaa.zza(this, parcel, i);
    }
}
