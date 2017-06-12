package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzaoe;
import java.util.ArrayList;
import java.util.List;

public class GoalsReadRequest extends zza {
    public static final Creator<GoalsReadRequest> CREATOR;
    private final int versionCode;
    private final List<Integer> zzaSq;
    private final List<Integer> zzaVA;
    private final zzaoe zzaVy;
    private final List<DataType> zzaVz;

    public static class Builder {
        private final List<Integer> zzaSq;
        private final List<Integer> zzaVA;
        private final List<DataType> zzaVz;

        public Builder() {
            this.zzaVz = new ArrayList();
            this.zzaVA = new ArrayList();
            this.zzaSq = new ArrayList();
        }

        public Builder addActivity(String str) {
            int zzdY = FitnessActivities.zzdY(str);
            zzac.zza(zzdY != 4, (Object) "Attempting to add an unknown activity");
            zzanh.zza(Integer.valueOf(zzdY), this.zzaSq);
            return this;
        }

        public Builder addDataType(DataType dataType) {
            zzac.zzb((Object) dataType, (Object) "Attempting to use a null data type");
            if (!this.zzaVz.contains(dataType)) {
                this.zzaVz.add(dataType);
            }
            return this;
        }

        public Builder addObjectiveType(int i) {
            boolean z = true;
            if (!(i == 1 || i == 2 || i == 3)) {
                z = false;
            }
            zzac.zza(z, (Object) "Attempting to add an invalid objective type");
            if (!this.zzaVA.contains(Integer.valueOf(i))) {
                this.zzaVA.add(Integer.valueOf(i));
            }
            return this;
        }

        public GoalsReadRequest build() {
            zzac.zza(!this.zzaVz.isEmpty(), (Object) "At least one data type should be specified.");
            return new GoalsReadRequest();
        }
    }

    static {
        CREATOR = new zzah();
    }

    GoalsReadRequest(int i, IBinder iBinder, List<DataType> list, List<Integer> list2, List<Integer> list3) {
        this.versionCode = i;
        this.zzaVy = iBinder == null ? null : zzaoe.zza.zzcv(iBinder);
        this.zzaVz = list;
        this.zzaVA = list2;
        this.zzaSq = list3;
    }

    private GoalsReadRequest(Builder builder) {
        this(null, builder.zzaVz, builder.zzaVA, builder.zzaSq);
    }

    public GoalsReadRequest(GoalsReadRequest goalsReadRequest, zzaoe com_google_android_gms_internal_zzaoe) {
        this(com_google_android_gms_internal_zzaoe, goalsReadRequest.getDataTypes(), goalsReadRequest.zzCl(), goalsReadRequest.zzBD());
    }

    private GoalsReadRequest(zzaoe com_google_android_gms_internal_zzaoe, List<DataType> list, List<Integer> list2, List<Integer> list3) {
        this(1, com_google_android_gms_internal_zzaoe == null ? null : com_google_android_gms_internal_zzaoe.asBinder(), list, list2, list3);
    }

    private boolean zzb(GoalsReadRequest goalsReadRequest) {
        return zzaa.equal(this.zzaVz, goalsReadRequest.zzaVz) && zzaa.equal(this.zzaVA, goalsReadRequest.zzaVA) && zzaa.equal(this.zzaSq, goalsReadRequest.zzaSq);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof GoalsReadRequest) && zzb((GoalsReadRequest) obj));
    }

    public List<String> getActivityNames() {
        if (this.zzaSq.isEmpty()) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (Integer intValue : this.zzaSq) {
            arrayList.add(FitnessActivities.getName(intValue.intValue()));
        }
        return arrayList;
    }

    public IBinder getCallbackBinder() {
        return this.zzaVy.asBinder();
    }

    public List<DataType> getDataTypes() {
        return this.zzaVz;
    }

    public List<Integer> getObjectiveTypes() {
        return this.zzaVA.isEmpty() ? null : this.zzaVA;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaVz, this.zzaVA, getActivityNames());
    }

    public String toString() {
        return zzaa.zzv(this).zzg("dataTypes", this.zzaVz).zzg("objectiveTypes", this.zzaVA).zzg("activities", getActivityNames()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzah.zza(this, parcel, i);
    }

    public List<Integer> zzBD() {
        return this.zzaSq;
    }

    public List<Integer> zzCl() {
        return this.zzaVA;
    }
}
