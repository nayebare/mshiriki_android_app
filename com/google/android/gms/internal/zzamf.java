package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzamf extends zza {
    public static final Creator<zzamf> CREATOR;
    final int mVersionCode;
    final String zzVW;
    final boolean zzaPo;
    final String zzaPp;
    final String zzaPq;
    final String zzach;
    final String zzaiX;
    final boolean zzawq;

    static {
        CREATOR = new zzamg();
    }

    zzamf(int i, boolean z, boolean z2, String str, String str2, String str3, String str4, String str5) {
        this.mVersionCode = i;
        this.zzaPo = z;
        this.zzawq = z2;
        this.zzVW = str;
        this.zzach = str2;
        this.zzaiX = str3;
        this.zzaPp = str4;
        this.zzaPq = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzamf)) {
            return false;
        }
        return this.zzVW.equals(((zzamf) obj).zzVW);
    }

    public int hashCode() {
        return this.zzVW.hashCode();
    }

    public String toString() {
        boolean z = this.zzaPo;
        boolean z2 = this.zzawq;
        String str = this.zzVW;
        String str2 = this.zzach;
        String str3 = this.zzaiX;
        String str4 = this.zzaPp;
        String str5 = this.zzaPq;
        return new StringBuilder(((((String.valueOf(str).length() + 98) + String.valueOf(str2).length()) + String.valueOf(str3).length()) + String.valueOf(str4).length()) + String.valueOf(str5).length()).append("Collaborator [isMe=").append(z).append(", isAnonymous=").append(z2).append(", sessionId=").append(str).append(", userId=").append(str2).append(", displayName=").append(str3).append(", color=").append(str4).append(", photoUrl=").append(str5).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzamg.zza(this, parcel, i);
    }
}
