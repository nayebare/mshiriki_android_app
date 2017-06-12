package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzany;

public class zzd extends zza {
    public static final Creator<zzd> CREATOR;
    private final int versionCode;
    private DataType zzaQI;
    private final zzany zzaUT;
    private final boolean zzaUU;

    static {
        CREATOR = new zze();
    }

    zzd(int i, IBinder iBinder, DataType dataType, boolean z) {
        this.versionCode = i;
        this.zzaUT = zzany.zza.zzcp(iBinder);
        this.zzaQI = dataType;
        this.zzaUU = z;
    }

    public zzd(zzany com_google_android_gms_internal_zzany, DataType dataType, boolean z) {
        this.versionCode = 3;
        this.zzaUT = com_google_android_gms_internal_zzany;
        this.zzaQI = dataType;
        this.zzaUU = z;
    }

    public IBinder getCallbackBinder() {
        return this.zzaUT.asBinder();
    }

    public DataType getDataType() {
        return this.zzaQI;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public String toString() {
        String str = "DailyTotalRequest{%s}";
        Object[] objArr = new Object[1];
        objArr[0] = this.zzaQI == null ? "null" : this.zzaQI.zzBv();
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public boolean zzBY() {
        return this.zzaUU;
    }
}
