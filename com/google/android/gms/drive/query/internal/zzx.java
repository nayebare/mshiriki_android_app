package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzx extends zza {
    public static final Creator<zzx> CREATOR;
    public static final zzx zzaPd;
    public static final zzx zzaPe;
    public static final zzx zzaPf;
    public static final zzx zzaPg;
    public static final zzx zzaPh;
    public static final zzx zzaPi;
    public static final zzx zzaPj;
    public static final zzx zzaPk;
    public static final zzx zzaPl;
    final String mTag;
    final int mVersionCode;

    static {
        CREATOR = new zzy();
        zzaPd = new zzx("=");
        zzaPe = new zzx("<");
        zzaPf = new zzx("<=");
        zzaPg = new zzx(">");
        zzaPh = new zzx(">=");
        zzaPi = new zzx("and");
        zzaPj = new zzx("or");
        zzaPk = new zzx("not");
        zzaPl = new zzx("contains");
    }

    zzx(int i, String str) {
        this.mVersionCode = i;
        this.mTag = str;
    }

    private zzx(String str) {
        this(1, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        zzx com_google_android_gms_drive_query_internal_zzx = (zzx) obj;
        return this.mTag == null ? com_google_android_gms_drive_query_internal_zzx.mTag == null : this.mTag.equals(com_google_android_gms_drive_query_internal_zzx.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzy.zza(this, parcel, i);
    }
}
