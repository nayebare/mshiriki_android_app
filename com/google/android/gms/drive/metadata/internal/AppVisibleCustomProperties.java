package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties extends com.google.android.gms.common.internal.safeparcel.zza implements ReflectedParcelable, Iterable<zzc> {
    public static final Creator<AppVisibleCustomProperties> CREATOR;
    public static final AppVisibleCustomProperties zzaNq;
    final int mVersionCode;
    final List<zzc> zzaNr;

    public static class zza {
        private final Map<CustomPropertyKey, zzc> zzaNs;

        public zza() {
            this.zzaNs = new HashMap();
        }

        public AppVisibleCustomProperties zzAE() {
            return new AppVisibleCustomProperties(null);
        }

        public zza zza(CustomPropertyKey customPropertyKey, String str) {
            zzac.zzb((Object) customPropertyKey, (Object) "key");
            this.zzaNs.put(customPropertyKey, new zzc(customPropertyKey, str));
            return this;
        }

        public zza zza(zzc com_google_android_gms_drive_metadata_internal_zzc) {
            zzac.zzb((Object) com_google_android_gms_drive_metadata_internal_zzc, (Object) "property");
            this.zzaNs.put(com_google_android_gms_drive_metadata_internal_zzc.zzAF(), com_google_android_gms_drive_metadata_internal_zzc);
            return this;
        }
    }

    static {
        CREATOR = new zza();
        zzaNq = new zza().zzAE();
    }

    AppVisibleCustomProperties(int i, Collection<zzc> collection) {
        this.mVersionCode = i;
        zzac.zzw(collection);
        this.zzaNr = new ArrayList(collection);
    }

    private AppVisibleCustomProperties(Collection<zzc> collection) {
        this(1, (Collection) collection);
    }

    public boolean equals(Object obj) {
        return this == obj ? true : (obj == null || obj.getClass() != getClass()) ? false : zzAD().equals(((AppVisibleCustomProperties) obj).zzAD());
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaNr);
    }

    public Iterator<zzc> iterator() {
        return this.zzaNr.iterator();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public Map<CustomPropertyKey, String> zzAD() {
        Map hashMap = new HashMap(this.zzaNr.size());
        for (zzc com_google_android_gms_drive_metadata_internal_zzc : this.zzaNr) {
            hashMap.put(com_google_android_gms_drive_metadata_internal_zzc.zzAF(), com_google_android_gms_drive_metadata_internal_zzc.getValue());
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
