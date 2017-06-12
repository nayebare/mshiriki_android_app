package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BleDevicesResult extends zza implements Result {
    public static final Creator<BleDevicesResult> CREATOR;
    private final int mVersionCode;
    private final List<BleDevice> zzaWn;
    private final Status zzahq;

    static {
        CREATOR = new zza();
    }

    BleDevicesResult(int i, List<BleDevice> list, Status status) {
        this.mVersionCode = i;
        this.zzaWn = Collections.unmodifiableList(list);
        this.zzahq = status;
    }

    public BleDevicesResult(List<BleDevice> list, Status status) {
        this.mVersionCode = 3;
        this.zzaWn = Collections.unmodifiableList(list);
        this.zzahq = status;
    }

    public static BleDevicesResult zzac(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    private boolean zzb(BleDevicesResult bleDevicesResult) {
        return this.zzahq.equals(bleDevicesResult.zzahq) && zzaa.equal(this.zzaWn, bleDevicesResult.zzaWn);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof BleDevicesResult) && zzb((BleDevicesResult) obj));
    }

    public List<BleDevice> getClaimedBleDevices() {
        return this.zzaWn;
    }

    public List<BleDevice> getClaimedBleDevices(DataType dataType) {
        List arrayList = new ArrayList();
        for (BleDevice bleDevice : this.zzaWn) {
            if (bleDevice.getDataTypes().contains(dataType)) {
                arrayList.add(bleDevice);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzahq;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzahq, this.zzaWn);
    }

    public String toString() {
        return zzaa.zzv(this).zzg(Games.EXTRA_STATUS, this.zzahq).zzg("bleDevices", this.zzaWn).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
