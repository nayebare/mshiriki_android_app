package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.messages.internal.zzg;
import com.google.android.gms.nearby.messages.internal.zzl;
import java.util.UUID;

public class zzavr extends zza {
    public static final Creator<zzavr> CREATOR;
    final int mVersionCode;
    final int zzbyl;
    final byte[] zzbym;
    final boolean zzbyn;

    static {
        CREATOR = new zzavs();
    }

    zzavr(int i, int i2, byte[] bArr, boolean z) {
        this.mVersionCode = i;
        this.zzbyl = i2;
        this.zzbym = bArr;
        this.zzbyn = z;
    }

    private zzavr(int i, byte[] bArr) {
        this(1, i, bArr, false);
    }

    public static zzavr zza(UUID uuid, @Nullable Short sh, @Nullable Short sh2) {
        return new zzavr(3, new zzl(uuid, sh, sh2).getBytes());
    }

    public static zzavr zzae(String str, @Nullable String str2) {
        Object obj;
        String valueOf = String.valueOf(str);
        if (str2 == null) {
            obj = BuildConfig.FLAVOR;
        }
        String valueOf2 = String.valueOf(obj);
        return new zzavr(2, new zzg(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).getBytes());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzavs.zza(this, parcel, i);
    }
}
