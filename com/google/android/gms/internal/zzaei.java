package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.awareness.fence.FenceState;

public class zzaei extends FenceState {
    public static final Creator<zzaei> CREATOR;
    public final int versionCode;
    public final int zzaHX;
    public final long zzaHY;
    public final String zzaHZ;
    public final int zzaIa;

    static {
        CREATOR = new zzaej();
    }

    zzaei(int i, int i2, long j, String str, int i3) {
        this.versionCode = i;
        this.zzaHX = i2;
        this.zzaHY = j;
        this.zzaHZ = str;
        this.zzaIa = i3;
    }

    public zzaei(int i, long j, String str, int i2) {
        this(1, i, j, str, i2);
    }

    public static FenceState extract(Intent intent) {
        return new zzaei(intent.getIntExtra("context_fence_current_state", 0), intent.getLongExtra("context_fence_last_updated_time", 0), intent.getStringExtra("context_fence_key"), intent.getIntExtra("context_fence_previous_state", 0));
    }

    public int getCurrentState() {
        return this.zzaHX;
    }

    public String getFenceKey() {
        return this.zzaHZ;
    }

    public long getLastFenceUpdateTimeMillis() {
        return this.zzaHY;
    }

    public int getPreviousState() {
        return this.zzaIa;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaej.zza(this, parcel, i);
    }
}
