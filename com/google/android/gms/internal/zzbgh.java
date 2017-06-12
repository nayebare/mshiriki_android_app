package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.util.HashMap;
import java.util.Map;

public class zzbgh {
    private final Context mContext;
    private String zzbDw;
    Map<String, Object> zzbJY;
    private final Map<String, Object> zzbJZ;
    private final zzbgj zzbLj;
    private final zze zzuI;

    public zzbgh(Context context) {
        this(context, new HashMap(), new zzbgj(context), zzh.zzyv());
    }

    zzbgh(Context context, Map<String, Object> map, zzbgj com_google_android_gms_internal_zzbgj, zze com_google_android_gms_common_util_zze) {
        this.zzbDw = null;
        this.zzbJY = new HashMap();
        this.mContext = context;
        this.zzuI = com_google_android_gms_common_util_zze;
        this.zzbLj = com_google_android_gms_internal_zzbgj;
        this.zzbJZ = map;
    }

    public void zzij(String str) {
        this.zzbDw = str;
    }
}
