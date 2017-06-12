package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public class zzava extends zza {
    public static final Creator<zzava> CREATOR;
    private final String description;
    private final String name;
    final int versionCode;
    private final byte zzbwK;
    private final zzaun zzbwM;
    private final zzauo zzbwN;
    private final zzaup zzbwO;
    private final byte zzbwR;

    static {
        CREATOR = new zzavb();
    }

    zzava(int i, String str, String str2, byte b, byte b2, IBinder iBinder, IBinder iBinder2, IBinder iBinder3) {
        this.versionCode = i;
        this.name = zzac.zzdv(str);
        this.description = (String) zzac.zzw(str2);
        this.zzbwK = b;
        this.zzbwR = b2;
        zzac.zzw(iBinder);
        this.zzbwM = zzaun.zza.zzeu(iBinder);
        zzac.zzw(iBinder2);
        this.zzbwN = zzauo.zza.zzev(iBinder2);
        zzac.zzw(iBinder3);
        this.zzbwO = zzaup.zza.zzew(iBinder3);
    }

    public IBinder getCallbackBinder() {
        return this.zzbwO == null ? null : this.zzbwO.asBinder();
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzavb.zza(this, parcel, i);
    }

    public byte zzMK() {
        return this.zzbwK;
    }

    public byte zzMP() {
        return this.zzbwR;
    }

    public IBinder zzMQ() {
        return this.zzbwM == null ? null : this.zzbwM.asBinder();
    }

    public IBinder zzMR() {
        return this.zzbwN == null ? null : this.zzbwN.asBinder();
    }
}
