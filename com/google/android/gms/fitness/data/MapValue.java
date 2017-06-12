package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

public class MapValue extends zza implements ReflectedParcelable {
    public static final Creator<MapValue> CREATOR;
    private final int mVersionCode;
    private final int zzaTx;
    private final float zzaTy;

    static {
        CREATOR = new zzv();
    }

    public MapValue(int i, float f) {
        this(1, i, f);
    }

    MapValue(int i, int i2, float f) {
        this.mVersionCode = i;
        this.zzaTx = i2;
        this.zzaTy = f;
    }

    private boolean zza(MapValue mapValue) {
        if (this.zzaTx != mapValue.zzaTx) {
            return false;
        }
        switch (this.zzaTx) {
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return asFloat() == mapValue.asFloat();
            default:
                return this.zzaTy == mapValue.zzaTy;
        }
    }

    public static MapValue zzd(float f) {
        return new MapValue(2, f);
    }

    public float asFloat() {
        zzac.zza(this.zzaTx == 2, (Object) "Value is not in float format");
        return this.zzaTy;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof MapValue) && zza((MapValue) obj));
    }

    int getFormat() {
        return this.zzaTx;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return (int) this.zzaTy;
    }

    public String toString() {
        switch (this.zzaTx) {
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return Float.toString(asFloat());
            default:
                return FitnessActivities.UNKNOWN;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzv.zza(this, parcel, i);
    }

    float zzBI() {
        return this.zzaTy;
    }
}
