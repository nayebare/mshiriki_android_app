package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.awareness.fence.FenceQueryRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class zzaeg extends FenceQueryRequest {
    public static final Creator<zzaeg> CREATOR;
    public final int versionCode;
    public final zza zzaHV;

    public static class zza extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final Creator<zza> CREATOR;
        public final int type;
        public final int versionCode;
        public final List<String> zzaHW;

        static {
            CREATOR = new zzaes();
        }

        zza(int i, int i2, List<String> list) {
            this.versionCode = i;
            this.type = i2;
            this.zzaHW = list;
        }

        private zza(int i, List<String> list) {
            this(1, i, list);
        }

        public static zza zza(int i, List<String> list) {
            return new zza(i, list);
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzaes.zza(this, parcel, i);
        }
    }

    static {
        CREATOR = new zzaeh();
    }

    public zzaeg() {
        this(1, zza.zza(1, null));
    }

    zzaeg(int i, zza com_google_android_gms_internal_zzaeg_zza) {
        this.versionCode = i;
        this.zzaHV = com_google_android_gms_internal_zzaeg_zza;
    }

    public zzaeg(Collection<String> collection) {
        this(1, zza.zza(2, new ArrayList(collection)));
    }

    public zzaeg(String... strArr) {
        this(1, zza.zza(2, Arrays.asList(strArr)));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaeh.zza(this, parcel, i);
    }
}
