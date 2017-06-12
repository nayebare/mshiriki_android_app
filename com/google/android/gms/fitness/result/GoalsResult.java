package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.Goal;
import java.util.Collections;
import java.util.List;

public class GoalsResult extends zza implements Result {
    public static final Creator<GoalsResult> CREATOR;
    private final int versionCode;
    private final List<Goal> zzaWy;
    private final Status zzagv;

    static {
        CREATOR = new zzn();
    }

    GoalsResult(int i, Status status, List<Goal> list) {
        this.versionCode = i;
        this.zzagv = status;
        this.zzaWy = list;
    }

    public GoalsResult(Status status, List<Goal> list) {
        this(1, status, list);
    }

    public static GoalsResult zzaf(Status status) {
        return new GoalsResult(status, Collections.emptyList());
    }

    public List<Goal> getGoals() {
        return this.zzaWy;
    }

    public Status getStatus() {
        return this.zzagv;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}
