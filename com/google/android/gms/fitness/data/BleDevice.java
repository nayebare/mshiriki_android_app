package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzanf;
import java.util.Collections;
import java.util.List;

public class BleDevice extends zza implements ReflectedParcelable {
    public static final Creator<BleDevice> CREATOR;
    private final String mName;
    private final int mVersionCode;
    private final String zzaQS;
    private final List<String> zzaQT;
    private final List<DataType> zzaQU;

    static {
        CREATOR = new zzd();
    }

    BleDevice(int i, String str, String str2, List<String> list, List<DataType> list2) {
        this.mVersionCode = i;
        this.zzaQS = str;
        this.mName = str2;
        this.zzaQT = Collections.unmodifiableList(list);
        this.zzaQU = Collections.unmodifiableList(list2);
    }

    private boolean zza(BleDevice bleDevice) {
        return this.mName.equals(bleDevice.mName) && this.zzaQS.equals(bleDevice.zzaQS) && zzanf.zza(bleDevice.zzaQT, this.zzaQT) && zzanf.zza(this.zzaQU, bleDevice.zzaQU);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof BleDevice) && zza((BleDevice) obj));
    }

    public String getAddress() {
        return this.zzaQS;
    }

    public List<DataType> getDataTypes() {
        return this.zzaQU;
    }

    public String getName() {
        return this.mName;
    }

    public List<String> getSupportedProfiles() {
        return this.zzaQT;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.mName, this.zzaQS, this.zzaQT, this.zzaQU);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("name", this.mName).zzg("address", this.zzaQS).zzg("dataTypes", this.zzaQU).zzg("supportedProfiles", this.zzaQT).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
