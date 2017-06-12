package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.awareness.fence.FenceState;
import com.google.android.gms.awareness.fence.FenceStateMap;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzaek extends zza implements FenceStateMap {
    public static final Creator<zzaek> CREATOR;
    public final int versionCode;
    public final Map<String, zzaei> zzaIb;

    static {
        CREATOR = new zzael();
    }

    zzaek(int i, Bundle bundle) {
        this.versionCode = i;
        this.zzaIb = new HashMap();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.zzaIb.put(str, (zzaei) zzd.zza(bundle.getByteArray(str), zzaei.CREATOR));
            }
        }
    }

    public Set<String> getFenceKeys() {
        return this.zzaIb.keySet();
    }

    public /* synthetic */ FenceState getFenceState(String str) {
        return zzdF(str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzael.zza(this, parcel, i);
    }

    public zzaei zzdF(String str) {
        return this.zzaIb.containsKey(str) ? (zzaei) this.zzaIb.get(str) : null;
    }

    Bundle zzzp() {
        if (this.zzaIb == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (Entry entry : this.zzaIb.entrySet()) {
            bundle.putByteArray((String) entry.getKey(), zzd.zza((zzaei) entry.getValue()));
        }
        return bundle;
    }
}
