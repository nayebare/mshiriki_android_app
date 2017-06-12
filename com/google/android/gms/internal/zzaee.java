package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.awareness.fence.AwarenessFence;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Collection;

public class zzaee extends AwarenessFence {
    public static final Creator<zzaee> CREATOR;
    public final int versionCode;
    private zzbts zzaHT;
    private byte[] zzaHU;

    static {
        CREATOR = new zzaef();
    }

    zzaee(int i, byte[] bArr) {
        this.versionCode = i;
        this.zzaHT = null;
        this.zzaHU = bArr;
        zzzg();
    }

    public zzaee(zzbts com_google_android_gms_internal_zzbts) {
        this.versionCode = 1;
        this.zzaHT = (zzbts) zzac.zzw(com_google_android_gms_internal_zzbts);
        this.zzaHU = null;
        zzzg();
    }

    public static zzaee zza(zzadx com_google_android_gms_internal_zzadx) {
        zzac.zzw(com_google_android_gms_internal_zzadx);
        zzbts zzdx = zzdx(7);
        zzdx.zzcqL = com_google_android_gms_internal_zzadx.zzzi();
        return new zzaee(zzdx);
    }

    public static zzaee zza(zzady com_google_android_gms_internal_zzady) {
        zzac.zzw(com_google_android_gms_internal_zzady);
        zzbts zzdx = zzdx(11);
        zzdx.zzcqP = com_google_android_gms_internal_zzady.zzzl();
        return new zzaee(zzdx);
    }

    public static zzaee zza(zzaea com_google_android_gms_internal_zzaea) {
        zzac.zzw(com_google_android_gms_internal_zzaea);
        zzbts zzdx = zzdx(12);
        zzdx.zzcqQ = com_google_android_gms_internal_zzaea.zzzm();
        return new zzaee(zzdx);
    }

    public static zzaee zza(zzaee com_google_android_gms_internal_zzaee) {
        zzac.zzw(com_google_android_gms_internal_zzaee);
        Collection arrayList = new ArrayList();
        arrayList.add(com_google_android_gms_internal_zzaee);
        zzbts zzdx = zzdx(3);
        zzdx.zzcqH = zzi(arrayList);
        return new zzaee(zzdx);
    }

    public static zzaee zza(zzaer com_google_android_gms_internal_zzaer) {
        zzac.zzw(com_google_android_gms_internal_zzaer);
        zzbts zzdx = zzdx(5);
        zzdx.zzcqJ = com_google_android_gms_internal_zzaer.zzzq();
        return new zzaee(zzdx);
    }

    public static zzaee zza(zzaet com_google_android_gms_internal_zzaet) {
        zzac.zzw(com_google_android_gms_internal_zzaet);
        zzbts zzdx = zzdx(4);
        zzdx.zzcqI = com_google_android_gms_internal_zzaet.zzzr();
        return new zzaee(zzdx);
    }

    private static zzbts zzdx(int i) {
        zzbts com_google_android_gms_internal_zzbts = new zzbts();
        com_google_android_gms_internal_zzbts.type = i;
        return com_google_android_gms_internal_zzbts;
    }

    public static zzaee zzg(Collection<zzaee> collection) {
        zzac.zzw(collection);
        zzac.zzas(!collection.isEmpty());
        zzbts zzdx = zzdx(1);
        zzdx.zzcqH = zzi(collection);
        return new zzaee(zzdx);
    }

    public static zzaee zzh(Collection<zzaee> collection) {
        zzac.zzw(collection);
        zzac.zzas(!collection.isEmpty());
        zzbts zzdx = zzdx(2);
        zzdx.zzcqH = zzi(collection);
        return new zzaee(zzdx);
    }

    private static zzbts[] zzi(Collection<zzaee> collection) {
        zzbts[] com_google_android_gms_internal_zzbtsArr = new zzbts[collection.size()];
        int i = 0;
        for (zzaee zzzo : collection) {
            int i2 = i + 1;
            com_google_android_gms_internal_zzbtsArr[i] = zzzo.zzzo();
            i = i2;
        }
        return com_google_android_gms_internal_zzbtsArr;
    }

    private void zzze() {
        if (!zzzf()) {
            try {
                this.zzaHT = zzbts.zzab(this.zzaHU);
                this.zzaHU = null;
            } catch (zzbus e) {
                zzcd.zza("ContextFenceStub", "Could not deserialize context fence bytes.", e);
                throw new IllegalStateException(e);
            }
        }
        zzzg();
    }

    private boolean zzzf() {
        return this.zzaHT != null;
    }

    private void zzzg() {
        if (this.zzaHT == null && this.zzaHU != null) {
            return;
        }
        if (this.zzaHT != null && this.zzaHU == null) {
            return;
        }
        if (this.zzaHT != null && this.zzaHU != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.zzaHT == null && this.zzaHU == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public String toString() {
        zzze();
        return this.zzaHT.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaef.zza(this, parcel, i);
    }

    public byte[] zzzn() {
        return this.zzaHU != null ? this.zzaHU : zzbut.zzf(this.zzaHT);
    }

    public zzbts zzzo() {
        zzze();
        return this.zzaHT;
    }
}
