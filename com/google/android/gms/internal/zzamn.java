package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzamn extends zza {
    public static final Creator<zzamn> CREATOR;
    final int mVersionCode;
    final String zzVW;
    final boolean zzaPA;
    final String zzaPB;
    final zzamv zzaPC;
    final zzamt zzaPD;
    final zzamz zzaPE;
    final zzanb zzaPF;
    final zzand zzaPG;
    final zzamx zzaPH;
    final zzamr zzaPI;
    final zzaml zzaPJ;
    final zzamj zzaPK;
    final String zzaPr;
    final List<String> zzaPx;
    final boolean zzaPy;
    final boolean zzaPz;
    final String zzach;

    static {
        CREATOR = new zzamo();
    }

    zzamn(int i, String str, String str2, List<String> list, boolean z, boolean z2, boolean z3, String str3, String str4, zzamv com_google_android_gms_internal_zzamv, zzamt com_google_android_gms_internal_zzamt, zzamz com_google_android_gms_internal_zzamz, zzanb com_google_android_gms_internal_zzanb, zzand com_google_android_gms_internal_zzand, zzamx com_google_android_gms_internal_zzamx, zzamr com_google_android_gms_internal_zzamr, zzaml com_google_android_gms_internal_zzaml, zzamj com_google_android_gms_internal_zzamj) {
        this.mVersionCode = i;
        this.zzVW = str;
        this.zzach = str2;
        this.zzaPx = list;
        this.zzaPy = z;
        this.zzaPz = z2;
        this.zzaPA = z3;
        this.zzaPr = str3;
        this.zzaPB = str4;
        this.zzaPC = com_google_android_gms_internal_zzamv;
        this.zzaPD = com_google_android_gms_internal_zzamt;
        this.zzaPE = com_google_android_gms_internal_zzamz;
        this.zzaPF = com_google_android_gms_internal_zzanb;
        this.zzaPG = com_google_android_gms_internal_zzand;
        this.zzaPH = com_google_android_gms_internal_zzamx;
        this.zzaPI = com_google_android_gms_internal_zzamr;
        this.zzaPJ = com_google_android_gms_internal_zzaml;
        this.zzaPK = com_google_android_gms_internal_zzamj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzamo.zza(this, parcel, i);
    }
}
