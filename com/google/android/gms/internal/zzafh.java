package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class zzafh extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<zzafh> CREATOR;
    public final int versionCode;
    public final ArrayList<zza> zzaId;

    public static class zza extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final Creator<zza> CREATOR;
        public final int type;
        public final int versionCode;
        public final zzce zzaIQ;
        public final String zzaIR;

        static {
            CREATOR = new zzafj();
        }

        zza(int i, int i2, zzce com_google_android_gms_internal_zzce, String str) {
            this.versionCode = i;
            this.type = i2;
            this.zzaIQ = com_google_android_gms_internal_zzce;
            this.zzaIR = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzafj.zza(this, parcel, i);
        }
    }

    static {
        CREATOR = new zzafi();
    }

    public zzafh() {
        this.versionCode = 1;
        this.zzaId = new ArrayList();
    }

    zzafh(int i, ArrayList<zza> arrayList) {
        this.versionCode = i;
        this.zzaId = arrayList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzafi.zza(this, parcel, i);
    }
}
