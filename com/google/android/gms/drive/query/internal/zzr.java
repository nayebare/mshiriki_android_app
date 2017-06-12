package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

public class zzr extends zza {
    public static final Creator<zzr> CREATOR;
    final int mVersionCode;
    private List<Filter> zzaOG;
    final zzx zzaOM;
    final List<FilterHolder> zzaPb;

    static {
        CREATOR = new zzs();
    }

    zzr(int i, zzx com_google_android_gms_drive_query_internal_zzx, List<FilterHolder> list) {
        this.mVersionCode = i;
        this.zzaOM = com_google_android_gms_drive_query_internal_zzx;
        this.zzaPb = list;
    }

    public zzr(zzx com_google_android_gms_drive_query_internal_zzx, Filter filter, Filter... filterArr) {
        this.mVersionCode = 1;
        this.zzaOM = com_google_android_gms_drive_query_internal_zzx;
        this.zzaPb = new ArrayList(filterArr.length + 1);
        this.zzaPb.add(new FilterHolder(filter));
        this.zzaOG = new ArrayList(filterArr.length + 1);
        this.zzaOG.add(filter);
        for (Filter filter2 : filterArr) {
            this.zzaPb.add(new FilterHolder(filter2));
            this.zzaOG.add(filter2);
        }
    }

    public zzr(zzx com_google_android_gms_drive_query_internal_zzx, Iterable<Filter> iterable) {
        this.mVersionCode = 1;
        this.zzaOM = com_google_android_gms_drive_query_internal_zzx;
        this.zzaOG = new ArrayList();
        this.zzaPb = new ArrayList();
        for (Filter filter : iterable) {
            this.zzaOG.add(filter);
            this.zzaPb.add(new FilterHolder(filter));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzs.zza(this, parcel, i);
    }

    public <T> T zza(zzj<T> com_google_android_gms_drive_query_internal_zzj_T) {
        List arrayList = new ArrayList();
        for (FilterHolder filter : this.zzaPb) {
            arrayList.add(filter.getFilter().zza(com_google_android_gms_drive_query_internal_zzj_T));
        }
        return com_google_android_gms_drive_query_internal_zzj_T.zzb(this.zzaOM, arrayList);
    }
}
