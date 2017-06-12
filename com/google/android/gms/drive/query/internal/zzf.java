package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Locale;

public class zzf extends zza {
    public static final Creator<zzf> CREATOR;
    final int mVersionCode;
    final String zzaNl;
    final boolean zzaOP;

    static {
        CREATOR = new zzg();
    }

    zzf(int i, String str, boolean z) {
        this.mVersionCode = i;
        this.zzaNl = str;
        this.zzaOP = z;
    }

    public zzf(String str, boolean z) {
        this(1, str, z);
    }

    public String toString() {
        Locale locale = Locale.US;
        String str = "FieldWithSortOrder[%s %s]";
        Object[] objArr = new Object[2];
        objArr[0] = this.zzaNl;
        objArr[1] = this.zzaOP ? "ASC" : "DESC";
        return String.format(locale, str, objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
