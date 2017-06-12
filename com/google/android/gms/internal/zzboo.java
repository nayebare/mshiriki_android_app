package com.google.android.gms.internal;

import com.google.android.gms.internal.zzboq.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzboo implements zzboq {
    private final Set<String> zzcgC;
    private final zza zzcgD;

    /* renamed from: com.google.android.gms.internal.zzboo.1 */
    static /* synthetic */ class C12691 {
        static final /* synthetic */ int[] zzcaU;

        static {
            zzcaU = new int[zza.values().length];
            try {
                zzcaU[zza.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzcaU[zza.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzcaU[zza.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zzcaU[zza.DEBUG.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public zzboo(zza com_google_android_gms_internal_zzboq_zza, List<String> list) {
        if (list != null) {
            this.zzcgC = new HashSet(list);
        } else {
            this.zzcgC = null;
        }
        this.zzcgD = com_google_android_gms_internal_zzboq_zza;
    }

    public zza zzWu() {
        return this.zzcgD;
    }

    protected String zza(zza com_google_android_gms_internal_zzboq_zza, String str, String str2, long j) {
        String valueOf = String.valueOf(new Date(j).toString());
        String valueOf2 = String.valueOf(com_google_android_gms_internal_zzboq_zza);
        return new StringBuilder((((String.valueOf(valueOf).length() + 6) + String.valueOf(valueOf2).length()) + String.valueOf(str).length()) + String.valueOf(str2).length()).append(valueOf).append(" [").append(valueOf2).append("] ").append(str).append(": ").append(str2).toString();
    }

    protected boolean zza(zza com_google_android_gms_internal_zzboq_zza, String str) {
        return com_google_android_gms_internal_zzboq_zza.ordinal() >= this.zzcgD.ordinal() && (this.zzcgC == null || com_google_android_gms_internal_zzboq_zza.ordinal() > zza.DEBUG.ordinal() || this.zzcgC.contains(str));
    }

    protected void zzaq(String str, String str2) {
        System.err.println(str2);
    }

    protected void zzar(String str, String str2) {
        System.out.println(str2);
    }

    protected void zzas(String str, String str2) {
        System.out.println(str2);
    }

    protected void zzat(String str, String str2) {
        System.out.println(str2);
    }

    public void zzb(zza com_google_android_gms_internal_zzboq_zza, String str, String str2, long j) {
        if (zza(com_google_android_gms_internal_zzboq_zza, str)) {
            String zza = zza(com_google_android_gms_internal_zzboq_zza, str, str2, j);
            switch (C12691.zzcaU[com_google_android_gms_internal_zzboq_zza.ordinal()]) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    zzaq(str, zza);
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzar(str, zza);
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    zzas(str, zza);
                case Dimension.UNIT_IN /*4*/:
                    zzat(str, zza);
                default:
                    throw new RuntimeException("Should not reach here!");
            }
        }
    }
}
