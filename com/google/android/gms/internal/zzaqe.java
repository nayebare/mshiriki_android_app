package com.google.android.gms.internal;

import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzaqe extends zza {
    public static final Creator<zzaqe> CREATOR;
    private final String packageName;
    private final String title;
    public final int version;
    private final PackageInfo zzRe;
    final BitmapTeleporter zzbhH;
    private final List<zzara> zzbhI;
    private final List<zzaqg> zzbhJ;
    private final int zzbhK;
    private final byte[] zzbhL;
    private final List<zzard> zzbhM;
    private final Bitmap zzbhN;

    static {
        CREATOR = new zzaqf();
    }

    zzaqe(int i, String str, String str2, BitmapTeleporter bitmapTeleporter, List<zzara> list, List<zzaqg> list2, int i2, byte[] bArr, PackageInfo packageInfo, List<zzard> list3) {
        this.version = i;
        this.packageName = str;
        this.title = str2;
        this.zzbhH = bitmapTeleporter;
        this.zzbhI = list;
        this.zzbhJ = list2;
        this.zzbhK = i2;
        this.zzbhL = bArr;
        this.zzRe = packageInfo;
        this.zzbhM = list3;
        if (bitmapTeleporter == null) {
            this.zzbhN = null;
        } else {
            this.zzbhN = bitmapTeleporter.zzwz();
        }
    }

    public String getPackageName() {
        return this.packageName;
    }

    public List<zzara> getRoutes() {
        return this.zzbhI;
    }

    public String getTitle() {
        return this.title;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaqf.zza(this, parcel, i);
    }

    public List<zzaqg> zzGB() {
        return this.zzbhJ;
    }

    public List<zzard> zzGC() {
        return this.zzbhM;
    }

    public int zzGD() {
        return this.zzbhK;
    }

    public byte[] zzGE() {
        return this.zzbhL;
    }

    public PackageInfo zzGF() {
        return this.zzRe;
    }
}
