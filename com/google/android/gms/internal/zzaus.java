package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public class zzaus extends zza {
    public static final Creator<zzaus> CREATOR;
    private final String description;
    private final String name;
    private final long timeoutMillis;
    final int versionCode;
    private final byte zzbwK;
    private final zzauj zzbwL;
    private final zzaun zzbwM;
    private final zzauo zzbwN;
    private final zzaup zzbwO;
    private final String zzbwP;
    private final byte zzbwQ;
    private final byte zzbwR;

    static {
        CREATOR = new zzaut();
    }

    zzaus(int i, zzauj com_google_android_gms_internal_zzauj, String str, String str2, byte b, long j, String str3, byte b2, byte b3, IBinder iBinder, IBinder iBinder2, IBinder iBinder3) {
        this.versionCode = i;
        this.zzbwL = (zzauj) zzac.zzw(com_google_android_gms_internal_zzauj);
        this.name = zzac.zzdv(str);
        this.description = (String) zzac.zzw(str2);
        this.zzbwK = b;
        this.timeoutMillis = j;
        this.zzbwQ = b2;
        this.zzbwR = b3;
        this.zzbwP = str3;
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

    public String getToken() {
        return this.zzbwP;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaut.zza(this, parcel, i);
    }

    public byte zzMK() {
        return this.zzbwK;
    }

    public zzauj zzMM() {
        return this.zzbwL;
    }

    public long zzMN() {
        return this.timeoutMillis;
    }

    public byte zzMO() {
        return this.zzbwQ;
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
