package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzagm extends zza {
    public static final Creator<zzagm> CREATOR;
    private final int mVersionCode;
    private final List<String> zzaKR;

    static {
        CREATOR = new zzagn();
    }

    zzagm(int i, List<String> list) {
        this.mVersionCode = i;
        this.zzaKR = list;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzagn.zza(this, parcel, i);
    }

    public List<String> zzAg() {
        return this.zzaKR;
    }
}
