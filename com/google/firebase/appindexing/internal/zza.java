package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.firebase.appindexing.Action;

public class zza extends com.google.android.gms.common.internal.safeparcel.zza implements Action {
    public static final Creator<zza> CREATOR;
    public final int mVersionCode;
    private final String zzbUQ;
    private final String zzbUR;
    private final String zzbUS;
    private final String zzbUT;
    private final zza zzbUU;
    private final String zzbUV;

    public static class zza extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final Creator<zza> CREATOR;
        public final int mVersionCode;
        private int zzagU;
        private final String zzaht;
        private final boolean zzbUX;
        private final boolean zzbUY;
        private final String zzbVf;
        private final byte[] zzbVg;

        static {
            CREATOR = new zzj();
        }

        zza(int i, int i2, boolean z, String str, String str2, byte[] bArr, boolean z2) {
            this.zzagU = 0;
            this.mVersionCode = i;
            this.zzagU = i2;
            this.zzbUX = z;
            this.zzbVf = str;
            this.zzaht = str2;
            this.zzbVg = bArr;
            this.zzbUY = z2;
        }

        public zza(boolean z, String str, String str2, byte[] bArr, boolean z2) {
            this.zzagU = 0;
            this.mVersionCode = 1;
            this.zzbUX = z;
            this.zzbVf = str;
            this.zzaht = str2;
            this.zzbVg = bArr;
            this.zzbUY = z2;
        }

        public String getAccountName() {
            return this.zzaht;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MetadataImpl { ");
            stringBuilder.append("{ eventStatus: '").append(this.zzagU).append("' } ");
            stringBuilder.append("{ uploadable: '").append(this.zzbUX).append("' } ");
            if (this.zzbVf != null) {
                stringBuilder.append("{ completionToken: '").append(this.zzbVf).append("' } ");
            }
            if (this.zzaht != null) {
                stringBuilder.append("{ accountName: '").append(this.zzaht).append("' } ");
            }
            if (this.zzbVg != null) {
                stringBuilder.append("{ ssbContext: [ ");
                for (byte toHexString : this.zzbVg) {
                    stringBuilder.append("0x").append(Integer.toHexString(toHexString)).append(" ");
                }
                stringBuilder.append("] } ");
            }
            stringBuilder.append("{ contextOnly: '").append(this.zzbUY).append("' } ");
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzj.zza(this, parcel, i);
        }

        public int zzTG() {
            return this.zzagU;
        }

        public boolean zzTH() {
            return this.zzbUX;
        }

        public String zzTI() {
            return this.zzbVf;
        }

        public byte[] zzTJ() {
            return this.zzbVg;
        }

        public boolean zzTK() {
            return this.zzbUY;
        }

        public void zzpn(int i) {
            this.zzagU = i;
        }
    }

    static {
        CREATOR = new zzb();
    }

    zza(int i, String str, String str2, String str3, String str4, zza com_google_firebase_appindexing_internal_zza_zza, String str5) {
        this.mVersionCode = i;
        this.zzbUQ = str;
        this.zzbUR = str2;
        this.zzbUS = str3;
        this.zzbUT = str4;
        this.zzbUU = com_google_firebase_appindexing_internal_zza_zza;
        this.zzbUV = str5;
    }

    public zza(@NonNull String str, @NonNull String str2, @NonNull String str3, String str4, @NonNull zza com_google_firebase_appindexing_internal_zza_zza, String str5) {
        this.mVersionCode = 1;
        this.zzbUQ = str;
        this.zzbUR = str2;
        this.zzbUS = str3;
        this.zzbUT = str4;
        this.zzbUU = com_google_firebase_appindexing_internal_zza_zza;
        this.zzbUV = str5;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionImpl { ");
        stringBuilder.append("{ actionType: '").append(this.zzbUQ).append("' } ");
        stringBuilder.append("{ objectName: '").append(this.zzbUR).append("' } ");
        stringBuilder.append("{ objectUrl: '").append(this.zzbUS).append("' } ");
        if (this.zzbUT != null) {
            stringBuilder.append("{ objectSameAs: '").append(this.zzbUT).append("' } ");
        }
        if (this.zzbUU != null) {
            stringBuilder.append("{ metadata: '").append(this.zzbUU.toString()).append("' } ");
        }
        if (this.zzbUV != null) {
            stringBuilder.append("{ actionStatus: '").append(this.zzbUV).append("' } ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public String zzTA() {
        return this.zzbUQ;
    }

    public String zzTB() {
        return this.zzbUR;
    }

    public String zzTC() {
        return this.zzbUS;
    }

    public String zzTD() {
        return this.zzbUT;
    }

    public zza zzTE() {
        return this.zzbUU;
    }

    public String zzTF() {
        return this.zzbUV;
    }
}
