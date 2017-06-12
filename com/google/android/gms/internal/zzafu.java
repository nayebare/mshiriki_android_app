package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

public class zzafu extends zza {
    public static final Creator<zzafu> CREATOR;
    public final int versionCode;
    public final boolean zzaJb;
    public ArrayList<zzadr> zzaJc;

    static {
        CREATOR = new zzafv();
    }

    public zzafu() {
        this(false);
    }

    zzafu(int i, boolean z, ArrayList<zzadr> arrayList) {
        this.versionCode = i;
        this.zzaJb = z;
        this.zzaJc = arrayList;
    }

    public zzafu(boolean z) {
        this.versionCode = 1;
        this.zzaJb = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzafv.zza(this, parcel, i);
    }
}
