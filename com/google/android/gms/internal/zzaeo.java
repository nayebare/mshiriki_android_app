package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.awareness.fence.FenceUpdateRequest;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.Iterator;

public class zzaeo extends zza implements FenceUpdateRequest {
    public static final Creator<zzaeo> CREATOR;
    public final int versionCode;
    public final ArrayList<zzaeu> zzaId;

    static {
        CREATOR = new zzaep();
    }

    @Deprecated
    public zzaeo() {
        this(new ArrayList());
    }

    zzaeo(int i, ArrayList<zzaeu> arrayList) {
        this.versionCode = i;
        this.zzaId = arrayList;
    }

    public zzaeo(ArrayList<zzaeu> arrayList) {
        this(1, arrayList);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaep.zza(this, parcel, i);
    }

    public void zza(zzcg<com.google.android.gms.awareness.fence.zza, zzaeb> com_google_android_gms_internal_zzcg_com_google_android_gms_awareness_fence_zza__com_google_android_gms_internal_zzaeb) {
        Iterator it = this.zzaId.iterator();
        while (it.hasNext()) {
            ((zzaeu) it.next()).zzb(com_google_android_gms_internal_zzcg_com_google_android_gms_awareness_fence_zza__com_google_android_gms_internal_zzaeb);
        }
    }
}
