package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzanl;
import com.google.android.gms.internal.zzaph;

public final class Device extends zza {
    public static final Creator<Device> CREATOR;
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_HEAD_MOUNTED = 6;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    private final int type;
    private final String version;
    private final int versionCode;
    private final String zzaRL;
    private final String zzaRM;
    private final String zzaRN;
    private final int zzaRO;

    static {
        CREATOR = new zzn();
    }

    Device(int i, String str, String str2, String str3, String str4, int i2, int i3) {
        this.versionCode = i;
        this.zzaRL = (String) zzac.zzw(str);
        this.zzaRM = (String) zzac.zzw(str2);
        this.version = BuildConfig.FLAVOR;
        this.zzaRN = zzec(str4);
        this.type = i2;
        this.zzaRO = i3;
    }

    public Device(String str, String str2, String str3, int i) {
        this(str, str2, BuildConfig.FLAVOR, str3, i, TYPE_UNKNOWN);
    }

    public Device(String str, String str2, String str3, String str4, int i, int i2) {
        this(TYPE_PHONE, str, str2, BuildConfig.FLAVOR, str4, i, i2);
    }

    public static Device getLocalDevice(Context context) {
        int zzaX = zzanl.zzaX(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, zzaV(context), zzaX, TYPE_TABLET);
    }

    private boolean zzBz() {
        return zzBy() == TYPE_PHONE;
    }

    private boolean zza(Device device) {
        return zzaa.equal(this.zzaRL, device.zzaRL) && zzaa.equal(this.zzaRM, device.zzaRM) && zzaa.equal(this.version, device.version) && zzaa.equal(this.zzaRN, device.zzaRN) && this.type == device.type && this.zzaRO == device.zzaRO;
    }

    private static String zzaV(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    private String zzec(String str) {
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Device UID is null.");
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Device) && zza((Device) obj));
    }

    public String getManufacturer() {
        return this.zzaRL;
    }

    public String getModel() {
        return this.zzaRM;
    }

    String getStreamIdentifier() {
        Object[] objArr = new Object[TYPE_WATCH];
        objArr[TYPE_UNKNOWN] = this.zzaRL;
        objArr[TYPE_PHONE] = this.zzaRM;
        objArr[TYPE_TABLET] = this.zzaRN;
        return String.format("%s:%s:%s", objArr);
    }

    public int getType() {
        return this.type;
    }

    public String getUid() {
        return this.zzaRN;
    }

    public String getVersion() {
        return this.version;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        Object[] objArr = new Object[TYPE_SCALE];
        objArr[TYPE_UNKNOWN] = this.zzaRL;
        objArr[TYPE_PHONE] = this.zzaRM;
        objArr[TYPE_TABLET] = this.version;
        objArr[TYPE_WATCH] = this.zzaRN;
        objArr[TYPE_CHEST_STRAP] = Integer.valueOf(this.type);
        return zzaa.hashCode(objArr);
    }

    public String toString() {
        Object[] objArr = new Object[TYPE_CHEST_STRAP];
        objArr[TYPE_UNKNOWN] = getStreamIdentifier();
        objArr[TYPE_PHONE] = this.version;
        objArr[TYPE_TABLET] = Integer.valueOf(this.type);
        objArr[TYPE_WATCH] = Integer.valueOf(this.zzaRO);
        return String.format("Device{%s:%s:%s:%s}", objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    public String zzBA() {
        return zzBz() ? this.zzaRN : zzaph.zzeo(this.zzaRN);
    }

    public int zzBy() {
        return this.zzaRO;
    }
}
