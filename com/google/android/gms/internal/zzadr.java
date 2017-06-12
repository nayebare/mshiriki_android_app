package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

public class zzadr extends zza {
    public static final Creator<zzadr> CREATOR;
    public static final int[] zzaHG;
    private final int mVersionCode;
    private zzbtq zzaHH;
    private byte[] zzaHI;

    static {
        zzaHG = new int[]{0, 1};
        CREATOR = new zzadt();
    }

    zzadr(int i, byte[] bArr) {
        this.mVersionCode = i;
        this.zzaHH = null;
        this.zzaHI = bArr;
        zzzg();
    }

    private void zzze() {
        if (!zzzf()) {
            try {
                this.zzaHH = zzbtq.zzaa(this.zzaHI);
                this.zzaHI = null;
            } catch (zzbus e) {
                Log.e("ContextData", "Could not deserialize context bytes.", e);
                throw new IllegalStateException(e);
            }
        }
        zzzg();
    }

    private void zzzg() {
        if (this.zzaHH == null && this.zzaHI != null) {
            return;
        }
        if (this.zzaHH != null && this.zzaHI == null) {
            return;
        }
        if (this.zzaHH != null && this.zzaHI != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.zzaHH == null && this.zzaHI == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzadr)) {
            return false;
        }
        zzadr com_google_android_gms_internal_zzadr = (zzadr) obj;
        zzze();
        com_google_android_gms_internal_zzadr.zzze();
        return getId().equals(com_google_android_gms_internal_zzadr.getId()) && this.zzaHH.zzcqy.version == com_google_android_gms_internal_zzadr.zzaHH.zzcqy.version;
    }

    public String getId() {
        zzze();
        return this.zzaHH.zzcqx;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        zzze();
        return zzaa.hashCode(getId(), Integer.valueOf(this.zzaHH.zzcqy.version));
    }

    public String toString() {
        zzze();
        return this.zzaHH.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzadt.zza(this, parcel, i);
    }

    boolean zzzf() {
        return this.zzaHH != null;
    }

    byte[] zzzh() {
        return this.zzaHI != null ? this.zzaHI : zzbut.zzf(this.zzaHH);
    }
}
