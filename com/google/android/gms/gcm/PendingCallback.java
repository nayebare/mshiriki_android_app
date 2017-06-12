package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class PendingCallback implements Parcelable, ReflectedParcelable {
    public static final Creator<PendingCallback> CREATOR;
    final IBinder zzaEa;

    /* renamed from: com.google.android.gms.gcm.PendingCallback.1 */
    class C08641 implements Creator<PendingCallback> {
        C08641() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzgi(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzjv(i);
        }

        public PendingCallback zzgi(Parcel parcel) {
            return new PendingCallback(parcel);
        }

        public PendingCallback[] zzjv(int i) {
            return new PendingCallback[i];
        }
    }

    static {
        CREATOR = new C08641();
    }

    public PendingCallback(Parcel parcel) {
        this.zzaEa = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getIBinder() {
        return this.zzaEa;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zzaEa);
    }
}
