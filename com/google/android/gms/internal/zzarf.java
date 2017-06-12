package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class zzarf extends zza {
    public static final Creator<zzarf> CREATOR;
    private String packageName;
    public final int version;
    BitmapTeleporter zzbiB;
    private String zzbiC;
    private String zzbiD;
    private String zzbiE;
    private ArrayList<String> zzbiF;
    private zzaqj zzbiG;

    static {
        CREATOR = new zzarg();
    }

    zzarf(int i, BitmapTeleporter bitmapTeleporter, String str, String str2, String str3, String str4, Collection<String> collection, zzaqj com_google_android_gms_internal_zzaqj) {
        this.version = i;
        this.zzbiB = bitmapTeleporter;
        this.zzbiC = str;
        this.zzbiD = str2;
        this.zzbiE = str3;
        this.packageName = str4;
        this.zzbiF = new ArrayList(collection == null ? 0 : collection.size());
        if (collection != null) {
            this.zzbiF.addAll(collection);
        }
        this.zzbiG = com_google_android_gms_internal_zzaqj;
    }

    public String getDeveloperName() {
        return this.zzbiD;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzarg.zza(this, parcel, i);
    }

    public BitmapTeleporter zzHe() {
        return this.zzbiB;
    }

    public String zzHf() {
        return this.zzbiE;
    }

    public List<String> zzHg() {
        return Collections.unmodifiableList(this.zzbiF);
    }

    public zzaqj zzHh() {
        return this.zzbiG;
    }

    public String zzmx() {
        return this.zzbiC;
    }
}
