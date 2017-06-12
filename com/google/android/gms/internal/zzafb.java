package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.google.android.gms.awareness.AwarenessOptions;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzd;

public class zzafb extends zza {
    public static final Creator<zzafb> CREATOR;
    public final String moduleId;
    public final String packageName;
    public final int uid;
    public final int versionCode;
    public final int zzaIA;
    private zzca zzaIB;
    public final String zzaIv;
    public final int zzaIw;
    public final int zzaIx;
    public final String zzaIy;
    public final String zzaIz;

    static {
        CREATOR = new zzafc();
    }

    zzafb(int i, String str, String str2, int i2, String str3, int i3, int i4, String str4, String str5, int i5) {
        this.versionCode = i;
        this.zzaIv = str;
        this.packageName = str2;
        this.uid = i2;
        this.moduleId = str3;
        this.zzaIw = i3;
        this.zzaIx = i4;
        this.zzaIy = str4;
        this.zzaIz = str5;
        this.zzaIA = i5;
    }

    public zzafb(String str, String str2, int i, String str3, int i2, int i3, String str4, String str5, int i4) {
        this(1, zzac.zzdv(str), zzac.zzdv(str2), i, zzac.zzdv(str3), i2, i3, str4, str5, i4);
    }

    public static zzafb zza(Context context, String str, AwarenessOptions awarenessOptions) {
        return new zzafb(str, context.getPackageName(), Process.myUid(), awarenessOptions.zzrf(), zzd.zzv(context, context.getPackageName()), awarenessOptions.zzrg(), awarenessOptions.zzrh(), awarenessOptions.zzri(), awarenessOptions.zzrj());
    }

    public static zzafb zzz(Context context, String str) {
        return new zzafb(str, context.getPackageName(), Process.myUid(), context.getPackageName(), zzd.zzv(context, context.getPackageName()), 3, null, null, -1);
    }

    public byte[] toByteArray() {
        return com.google.android.gms.common.internal.safeparcel.zzd.zza(this);
    }

    public String toString() {
        String valueOf = String.valueOf(zzzu());
        String str = this.packageName;
        int i = this.uid;
        String str2 = this.moduleId;
        int i2 = this.zzaIw;
        String valueOf2 = String.valueOf(zzzv());
        String str3 = this.zzaIy;
        String str4 = this.zzaIz;
        return new StringBuilder((((((String.valueOf(valueOf).length() + 68) + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(valueOf2).length()) + String.valueOf(str3).length()) + String.valueOf(str4).length()).append("(accnt=").append(valueOf).append(", ").append(str).append("(").append(i).append("):").append(str2).append(", vrsn=").append(i2).append(", ").append(valueOf2).append(", 3pPkg = ").append(str3).append(" ,  3pMdlId = ").append(str4).append(")").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzafc.zza(this, parcel, i);
    }

    public zzca zzzu() {
        if (this.zzaIv == null) {
            return null;
        }
        if (this.zzaIB == null) {
            this.zzaIB = new zzca(this.zzaIv);
        }
        return this.zzaIB;
    }

    public String zzzv() {
        return Integer.toString(this.zzaIx);
    }
}
