package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzadj extends zza {
    public static final Creator<zzadj> CREATOR;
    public final int mVersionCode;
    private final String zzQL;
    private final String zzaHA;
    private final String zzaHB;
    private final String zzaHC;
    private final List<String> zzaHD;
    private final int zzaHp;
    private final List<zzadb> zzaHq;
    private final long zzaHy;
    private final DataHolder zzaHz;

    static {
        CREATOR = new zzadk();
    }

    zzadj(int i, String str, long j, DataHolder dataHolder, String str2, String str3, String str4, List<String> list, int i2, List<zzadb> list2) {
        this.mVersionCode = i;
        this.zzQL = str;
        this.zzaHy = j;
        this.zzaHz = dataHolder;
        this.zzaHA = str2;
        this.zzaHB = str3;
        this.zzaHC = str4;
        this.zzaHD = list;
        this.zzaHp = i2;
        this.zzaHq = list2;
    }

    public zzadj(String str, long j, DataHolder dataHolder, String str2, String str3, String str4, List<String> list, int i, List<zzadb> list2) {
        this(2, str, j, dataHolder, str2, str3, str4, list, i, list2);
    }

    public String getAppInstanceId() {
        return this.zzaHB;
    }

    public String getPackageName() {
        return this.zzQL;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzadk.zza(this, parcel, i);
    }

    public int zzyS() {
        return this.zzaHp;
    }

    public long zzyV() {
        return this.zzaHy;
    }

    public DataHolder zzyW() {
        return this.zzaHz;
    }

    public String zzyX() {
        return this.zzaHA;
    }

    public String zzyY() {
        return this.zzaHC;
    }

    public List<String> zzyZ() {
        return this.zzaHD;
    }

    public List<zzadb> zzza() {
        return this.zzaHq;
    }
}
