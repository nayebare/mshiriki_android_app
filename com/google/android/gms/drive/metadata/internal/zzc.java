package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class zzc extends zza {
    public static final Creator<zzc> CREATOR;
    final String mValue;
    final int mVersionCode;
    final CustomPropertyKey zzaNt;

    static {
        CREATOR = new zzd();
    }

    zzc(int i, CustomPropertyKey customPropertyKey, String str) {
        this.mVersionCode = i;
        zzac.zzb((Object) customPropertyKey, (Object) "key");
        this.zzaNt = customPropertyKey;
        this.mValue = str;
    }

    public zzc(CustomPropertyKey customPropertyKey, String str) {
        this(1, customPropertyKey, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        zzc com_google_android_gms_drive_metadata_internal_zzc = (zzc) obj;
        return zzaa.equal(this.zzaNt, com_google_android_gms_drive_metadata_internal_zzc.zzaNt) && zzaa.equal(this.mValue, com_google_android_gms_drive_metadata_internal_zzc.mValue);
    }

    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaNt, this.mValue);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public CustomPropertyKey zzAF() {
        return this.zzaNt;
    }
}
