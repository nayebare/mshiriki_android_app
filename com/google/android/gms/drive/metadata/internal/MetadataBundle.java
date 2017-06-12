package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzahp;
import com.google.android.gms.internal.zzalh;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MetadataBundle extends zza implements ReflectedParcelable {
    public static final Creator<MetadataBundle> CREATOR;
    final int mVersionCode;
    final Bundle zzaNw;

    static {
        CREATOR = new zzi();
    }

    MetadataBundle(int i, Bundle bundle) {
        String valueOf;
        this.mVersionCode = i;
        this.zzaNw = (Bundle) zzac.zzw(bundle);
        this.zzaNw.setClassLoader(getClass().getClassLoader());
        List<String> arrayList = new ArrayList();
        for (String valueOf2 : this.zzaNw.keySet()) {
            if (zzf.zzdN(valueOf2) == null) {
                arrayList.add(valueOf2);
                String str = "MetadataBundle";
                String str2 = "Ignored unknown metadata field in bundle: ";
                valueOf2 = String.valueOf(valueOf2);
                zzahp.zzE(str, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
            }
        }
        for (String valueOf22 : arrayList) {
            this.zzaNw.remove(valueOf22);
        }
    }

    private MetadataBundle(Bundle bundle) {
        this(1, bundle);
    }

    public static MetadataBundle zzAI() {
        return new MetadataBundle(new Bundle());
    }

    public static <T> MetadataBundle zzb(MetadataField<T> metadataField, T t) {
        MetadataBundle zzAI = zzAI();
        zzAI.zzc(metadataField, t);
        return zzAI;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.zzaNw.keySet();
        if (!keySet.equals(metadataBundle.zzaNw.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!zzaa.equal(this.zzaNw.get(str), metadataBundle.zzaNw.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (String str : this.zzaNw.keySet()) {
            i *= 31;
            i = this.zzaNw.get(str).hashCode() + i;
        }
        return i;
    }

    public void setContext(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zzalh.zzaOf);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.zzd(context.getCacheDir());
        }
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzaNw);
        return new StringBuilder(String.valueOf(valueOf).length() + 24).append("MetadataBundle [values=").append(valueOf).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public MetadataBundle zzAJ() {
        return new MetadataBundle(new Bundle(this.zzaNw));
    }

    public Set<MetadataField<?>> zzAK() {
        Set<MetadataField<?>> hashSet = new HashSet();
        for (String zzdN : this.zzaNw.keySet()) {
            hashSet.add(zzf.zzdN(zzdN));
        }
        return hashSet;
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zzs(this.zzaNw);
    }

    public <T> void zzc(MetadataField<T> metadataField, T t) {
        if (zzf.zzdN(metadataField.getName()) == null) {
            String str = "Unregistered field: ";
            String valueOf = String.valueOf(metadataField.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        metadataField.zza(t, this.zzaNw);
    }

    public boolean zzc(MetadataField<?> metadataField) {
        return this.zzaNw.containsKey(metadataField.getName());
    }
}
