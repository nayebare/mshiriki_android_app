package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzaos;
import java.util.Collections;
import java.util.List;

public class zzap extends zza {
    public static final Creator<zzap> CREATOR;
    private final int versionCode;
    private final zzaos zzaVG;
    private final List<String> zzaVH;

    static {
        CREATOR = new zzaq();
    }

    zzap(int i, IBinder iBinder, List<String> list) {
        List emptyList;
        this.versionCode = i;
        this.zzaVG = zzaos.zza.zzcJ(iBinder);
        if (list == null) {
            emptyList = Collections.emptyList();
        }
        this.zzaVH = emptyList;
    }

    public IBinder getCallbackBinder() {
        return this.zzaVG.asBinder();
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaq.zza(this, parcel, i);
    }

    public List<String> zzCn() {
        return this.zzaVH;
    }
}
