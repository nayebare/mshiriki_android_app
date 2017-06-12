package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbpe.zza;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzbpk extends zzbpb<zzbpk> {
    private final String value;

    /* renamed from: com.google.android.gms.internal.zzbpk.1 */
    static /* synthetic */ class C12761 {
        static final /* synthetic */ int[] zzchm;

        static {
            zzchm = new int[zza.values().length];
            try {
                zzchm[zza.V1.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzchm[zza.V2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public zzbpk(String str, zzbpe com_google_android_gms_internal_zzbpe) {
        super(com_google_android_gms_internal_zzbpe);
        this.value = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzbpk)) {
            return false;
        }
        zzbpk com_google_android_gms_internal_zzbpk = (zzbpk) obj;
        return this.value.equals(com_google_android_gms_internal_zzbpk.value) && this.zzcgQ.equals(com_google_android_gms_internal_zzbpk.zzcgQ);
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() + this.zzcgQ.hashCode();
    }

    protected zza zzYV() {
        return zza.String;
    }

    protected int zza(zzbpk com_google_android_gms_internal_zzbpk) {
        return this.value.compareTo(com_google_android_gms_internal_zzbpk.value);
    }

    public String zza(zza com_google_android_gms_internal_zzbpe_zza) {
        String valueOf;
        String str;
        switch (C12761.zzchm[com_google_android_gms_internal_zzbpe_zza.ordinal()]) {
            case MessageApi.FILTER_PREFIX /*1*/:
                valueOf = String.valueOf(zzb(com_google_android_gms_internal_zzbpe_zza));
                str = this.value;
                return new StringBuilder((String.valueOf(valueOf).length() + 7) + String.valueOf(str).length()).append(valueOf).append("string:").append(str).toString();
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                valueOf = String.valueOf(zzb(com_google_android_gms_internal_zzbpe_zza));
                str = String.valueOf(zzbqg.zzjj(this.value));
                return new StringBuilder((String.valueOf(valueOf).length() + 7) + String.valueOf(str).length()).append(valueOf).append("string:").append(str).toString();
            default:
                str = String.valueOf(com_google_android_gms_internal_zzbpe_zza);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 38).append("Invalid hash version for string node: ").append(str).toString());
        }
    }

    public /* synthetic */ zzbpe zzg(zzbpe com_google_android_gms_internal_zzbpe) {
        return zzs(com_google_android_gms_internal_zzbpe);
    }

    public zzbpk zzs(zzbpe com_google_android_gms_internal_zzbpe) {
        return new zzbpk(this.value, com_google_android_gms_internal_zzbpe);
    }
}
