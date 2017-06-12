package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.io.InputStream;

@zzmb
public class zzdl extends zza {
    public static final Creator<zzdl> CREATOR;
    public final int version;
    @Nullable
    private ParcelFileDescriptor zzyw;

    static {
        CREATOR = new zzdm();
    }

    public zzdl() {
        this(1, null);
    }

    zzdl(int i, @Nullable ParcelFileDescriptor parcelFileDescriptor) {
        this.version = i;
        this.zzyw = parcelFileDescriptor;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzdm.zza(this, parcel, i);
    }

    public synchronized boolean zzer() {
        return this.zzyw != null;
    }

    @Nullable
    public synchronized InputStream zzes() {
        InputStream inputStream = null;
        synchronized (this) {
            if (this.zzyw != null) {
                inputStream = new AutoCloseInputStream(this.zzyw);
                this.zzyw = null;
            }
        }
        return inputStream;
    }

    synchronized ParcelFileDescriptor zzet() {
        return this.zzyw;
    }
}
