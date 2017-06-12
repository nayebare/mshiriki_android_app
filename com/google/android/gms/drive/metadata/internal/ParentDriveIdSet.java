package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParentDriveIdSet extends zza implements ReflectedParcelable {
    public static final Creator<ParentDriveIdSet> CREATOR;
    final int mVersionCode;
    final List<zzo> zzaNy;

    static {
        CREATOR = new zzm();
    }

    public ParentDriveIdSet() {
        this(1, new ArrayList());
    }

    ParentDriveIdSet(int i, List<zzo> list) {
        this.mVersionCode = i;
        this.zzaNy = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    public Set<DriveId> zzK(long j) {
        Set<DriveId> hashSet = new HashSet();
        for (zzo zzL : this.zzaNy) {
            hashSet.add(zzL.zzL(j));
        }
        return hashSet;
    }

    public void zza(zzo com_google_android_gms_drive_metadata_internal_zzo) {
        this.zzaNy.add(com_google_android_gms_drive_metadata_internal_zzo);
    }
}
